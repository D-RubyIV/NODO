package org.example.bean.repository.postgres;

import org.example.bean.model.postgres.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
