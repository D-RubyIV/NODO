package org.example.demo20_08_02.repository;


import org.example.demo20_08_02.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{
}
