package org.example.demo22_08.repository;

import org.example.demo22_08.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query(value = "select s from student s join fetch s.room")
//    @EntityGraph(attributePaths = {"room"})
    List<Student> findAll();
}
