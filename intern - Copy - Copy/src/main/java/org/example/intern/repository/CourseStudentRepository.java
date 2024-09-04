package org.example.intern.repository;


import org.example.intern.entity.CourseStudent;
import org.example.intern.entity.CourseStudentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseStudentRepository extends JpaRepository<CourseStudent, CourseStudentKey> {
}
