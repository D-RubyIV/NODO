package org.example.intern.repository;

import org.example.intern.entity.Course;
import org.example.intern.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "select s from Course s")
    List<Course> findAllWithFetchJoin();

    @Query(value = "select s from Course s where s.id = :id")
    Optional<Course> findByIdWithFetchJoin(Integer id);
}
