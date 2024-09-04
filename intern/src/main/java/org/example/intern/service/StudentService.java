package org.example.intern.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.apache.coyote.BadRequestException;
import org.example.intern.dto.CourseDTO;
import org.example.intern.dto.StudentDTO;
import org.example.intern.entity.Course;
import org.example.intern.entity.Student;
import org.example.intern.mapper.StudentMapper;
import org.example.intern.repository.CourseRepository;
import org.example.intern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.DTD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Page<StudentDTO> findAll(
            String name,
            String code,
            String email,
            Integer status,
            LocalDate from,
            LocalDate to,
            Integer courseId,
            Pageable pageable
    ) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> student = query.from(Student.class);
        student.fetch("courses", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(cb.like(student.get("name"), "%" + name + "%"));
        }
        if (code != null) {
            predicates.add(cb.equal(student.get("code"), code));
        }
        if (email != null) {
            predicates.add(cb.equal(student.get("email"), email));
        }
        if (status != null) {
            predicates.add(cb.equal(student.get("status"), status));
        }
        if (courseId != null) {
            predicates.add(cb.equal(student.get("courses").get("id"), courseId));
        }
        if (from != null) {
            predicates.add(cb.greaterThanOrEqualTo(student.get("createdDate"), from));
        }
        if (to != null) {
            predicates.add(cb.lessThanOrEqualTo(student.get("createdDate"), to));
        }

        query.where(predicates.toArray(new Predicate[0]));

        List<Student> allStudents = entityManager.createQuery(query).getResultList();

        // Lấy tổng element
        int totalElements = allStudents.size();
        // Lấy offset End
        int start = (int) pageable.getOffset();
        // Lấy offset Start
        int end = Math.min((start + pageable.getPageSize()), totalElements);
        // Split elements
        List<Student> pagedStudents = allStudents.subList(start, end);

        return new PageImpl<>(studentMapper.entityToDTOs(pagedStudents), pageable, totalElements);

    }

    @Transactional(readOnly = true)
    public Student detail(Integer id) throws BadRequestException {
//      FIND BY ID
        return studentRepository.findByIdWithFetchJoin(id).orElseThrow(() -> new BadRequestException("Student not found"));
    }

    public Student save(StudentDTO studentDTO) {


        Student student = studentMapper.DTOtoEntity(studentDTO);
        student.setStatus(1);

        if (studentDTO.getCourseIds() != null){
            List<Course> courses = courseRepository.findAllById(studentDTO.getCourseIds());
            student.setCourses(courses);
        }

        return studentRepository.save(student);
    }

    @Transactional
    public Student updateExceptCode(Integer id, StudentDTO studentDTO) throws BadRequestException {
//      FIND BY ID
        Student entityFound = studentRepository.findByIdWithFetchJoin(id).orElseThrow(() -> new BadRequestException("Student not found"));
//      MAP TO ENTITY
        Student studentMapped = studentMapper.DTOtoEntity(studentDTO);
//      SET AGAIN
        entityFound.setCode(entityFound.getCode());
        if (studentDTO.getCourseIds() != null){
            List<Course> courses = courseRepository.findAllById(studentDTO.getCourseIds());
            entityFound.setCourses(courses);
        }
        entityFound.setStatus(studentMapped.getStatus());
        entityFound.setEmail(studentMapped.getEmail());
        entityFound.setName(studentMapped.getName());
        entityFound.setImage(studentMapped.getImage());
        entityFound.setStatus(studentMapped.getStatus());
//      SAVE AGAIN
        return studentRepository.save(entityFound);
    }

    @Transactional
    public Student deleteSoft(Integer id) throws BadRequestException {
//      FIND BY ID
        Student entityFound = studentRepository.findByIdWithFetchJoin(id).orElseThrow(() -> new BadRequestException("Student not found"));
//      SET AGAIN
        entityFound.setStatus(0);
//      SAVE AGAIN
        return studentRepository.save(entityFound);
    }

}
