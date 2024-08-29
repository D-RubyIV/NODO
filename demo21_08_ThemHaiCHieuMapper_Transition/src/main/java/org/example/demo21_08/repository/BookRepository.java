package org.example.demo21_08.repository;

import org.example.demo21_08.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllBy(Pageable pageable);

    @Query(value = "select b from book b")
    Page<Book> findAllByQuery(Pageable pageable);


    @Query(value = "select b from book b where b.id = ?1")
    Book findByQuery(Integer id);
}
