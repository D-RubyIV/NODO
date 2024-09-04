package org.example.intern.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.apache.coyote.BadRequestException;
import org.example.intern.dto.CourseDTO;
import org.example.intern.entity.Course;
import org.example.intern.entity.CourseStudent;
import org.example.intern.mapper.CourseMapper;
import org.example.intern.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Page<CourseDTO> findAll(
            String title,
            Integer status,
            String code,
            LocalDate from,
            LocalDate to,
            Pageable pageable
    ) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = cb.createQuery(Course.class);
        Root<Course> course = query.from(Course.class);
        course.fetch("inCourses", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if (title != null) {
            predicates.add(cb.like(course.get("title"), "%" + title + "%"));
        }
        if (status != null) {
            predicates.add(cb.equal(course.get("status"), status));
        }
        if (code != null) {
            predicates.add(cb.equal(course.get("code"), code));
        }
        if (from != null) {
            predicates.add(cb.greaterThanOrEqualTo(course.get("createdDate"), from));
        }
        if (to != null) {
            predicates.add(cb.lessThanOrEqualTo(course.get("createdDate"), to));
        }

        query.where(predicates.toArray(new Predicate[0]));

        List<Course> allCourses = entityManager.createQuery(query).getResultList();

        // Lấy tổng element
        int totalElements = allCourses.size();
        // Lấy offset End
        int start = (int) pageable.getOffset();
        // Lấy offset Start
        int end = Math.min((start + pageable.getPageSize()), totalElements);
        // Split elements
        List<Course> pagedCourses = allCourses.subList(start, end);

        return new PageImpl<>(courseMapper.entityToDTOs(pagedCourses), pageable, totalElements);
    }

    @Transactional(readOnly = true)
    public Course detail(Integer id) throws BadRequestException {
//      FIND BY ID
        return courseRepository.findByIdWithFetchJoin(id).orElseThrow(() -> new BadRequestException("Course not found"));
    }

    @Transactional
    public Course save(CourseDTO courseDTO) {
        Course course = courseMapper.DTOtoEntity(courseDTO);
        course.setStatus(1);
        return courseRepository.save(course);
    }

    @Transactional
    public Course updateExceptCode(Integer id, CourseDTO courseDTO) throws BadRequestException {
//      FIND BY ID
        Course entityFound = courseRepository.findByIdWithFetchJoin(id).orElseThrow(() -> new BadRequestException("Course not found"));
//      MAP TO ENTITY
        Course courseMapped = courseMapper.DTOtoEntity(courseDTO);
//      SET AGAIN
        entityFound.setCode(entityFound.getCode());
        entityFound.setTitle(courseMapped.getTitle());
        entityFound.setDescription(courseMapped.getDescription());
        entityFound.setImage(courseMapped.getImage());
        entityFound.setStatus(courseMapped.getStatus());
//      SAVE AGAIN
        return courseRepository.save(entityFound);
    }

    @Transactional
    public Course deleteSoft(Integer id) throws BadRequestException {
//      FIND BY ID
        Course entityFound = courseRepository.findByIdWithFetchJoin(id).orElseThrow(() -> new BadRequestException("Course not found"));
//        SET AGAIN
        entityFound.setStatus(0);
//        SAVE AGAIN
        return courseRepository.save(entityFound);
    }

}
