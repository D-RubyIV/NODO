package org.example.demo21_08.repository;

import org.example.demo21_08.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
//    @Query(value = "select l from library l join fetch l.books")
//    List<Library> findAll();
}
