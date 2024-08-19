package org.example.bean.repository.mysql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.bean.model.mysql.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT * FROM persons p", nativeQuery = true)
    Page<Person> findAllNative (Pageable pageable);


}
