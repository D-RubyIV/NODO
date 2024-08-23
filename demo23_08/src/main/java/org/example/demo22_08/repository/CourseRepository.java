package org.example.demo22_08.repository;

import org.example.demo22_08.entity.Course;
import org.example.demo22_08.entity.CourseRating;
import org.example.demo22_08.entity.CourseRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
