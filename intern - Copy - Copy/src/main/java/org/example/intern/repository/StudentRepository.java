package org.example.intern.repository;

import org.example.intern.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select s from Student s left join fetch s.inCourses")
    List<Student> findAllWithFetchJoin();

    @Query(value = "select s from Student s left join fetch s.inCourses where s.id = :id")
    Optional<Student> findByIdWithFetchJoin(Integer id);


}
