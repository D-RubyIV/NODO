package org.example.intern.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.apache.coyote.BadRequestException;
import org.example.intern.dto.StudentDTO;
import org.example.intern.entity.Course;
import org.example.intern.entity.CourseStudent;
import org.example.intern.entity.CourseStudentKey;
import org.example.intern.entity.Student;
import org.example.intern.mapper.StudentMapper;
import org.example.intern.repository.CourseRepository;
import org.example.intern.repository.CourseStudentRepository;
import org.example.intern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private CourseStudentService courseStudentService;

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
        student.fetch("inCourses", JoinType.LEFT);

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
            predicates.add(cb.equal(student.get("inCourses").get("course").get("id"), courseId));
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
//        return pagedStudents;

    }

    @Transactional(readOnly = true)
    public Student detail(Integer id) throws BadRequestException {
//      FIND BY ID
        return studentRepository.findByIdWithFetchJoin(id).orElseThrow(() -> new BadRequestException("Student not found"));
    }

    @Transactional
    public Student save(StudentDTO studentDTO) {

        Student student = studentMapper.DTOtoEntity(studentDTO);
        student.setStatus(1);

        if (studentDTO.getCourseIds() != null) {
//          FIND COURSES BY ID
            List<Course> coursesByIds = courseRepository.findAllById(studentDTO.getCourseIds());
//          CREATE COURSE STUDENTS
            Student studentSaved = studentRepository.save(student);
            List<CourseStudent> inCourses = new ArrayList<>();
            coursesByIds.forEach(s -> {
                CourseStudent courseStudent = new CourseStudent();
                courseStudent.setStudent(studentSaved);
                courseStudent.setCourse(s);
                courseStudent.setJoined(1);
                courseStudent.setId(new CourseStudentKey(studentSaved.getId(), s.getId()));
                inCourses.add(courseStudentService.save(courseStudent));
            });
            student.setInCourses(inCourses);
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
        if (studentDTO.getCourseIds() != null) {
//          FIND COURSES BY ID
            List<Course> coursesByIds = courseRepository.findAllById(studentDTO.getCourseIds());
            List<CourseStudent> coursesByOrigin = entityFound.getInCourses();
//          SET JOINED TO 0
            entityFound.setInCourses(coursesByOrigin.stream().peek(s -> s.setJoined(0)).toList());
//          CREATE COURSE STUDENTS
            List<CourseStudent> inCourses = new ArrayList<>();
            coursesByIds.forEach(s -> {
                CourseStudent courseStudent = new CourseStudent();
                courseStudent.setStudent(entityFound);
                courseStudent.setCourse(s);
                courseStudent.setJoined(1);
                courseStudent.setId(new CourseStudentKey(entityFound.getId(), s.getId()));
                inCourses.add(courseStudentService.save(courseStudent));
            });
            entityFound.setInCourses(inCourses);
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
