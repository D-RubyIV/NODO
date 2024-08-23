package org.example.demo21_08.service;

import jakarta.persistence.EntityManager;
import org.example.demo21_08.entity.Book;
import org.example.demo21_08.entity.Library;
import org.example.demo21_08.repository.BookRepository;
import org.example.demo21_08.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository repository;
    
    public List<Library> findAll(){
        return repository.findAll();
    }

    public Library create(Library e){
        return repository.save(e);
    }

    public Library detail(Integer id) throws Exception {
        Library f = repository.findById(id).orElse(null);
        if (f != null){

            System.out.println(f);
            System.out.println(f.getBooks());

            return f;
        }
        else {
            throw new Exception("Library not found");
        }
    }

    public Library update(Integer id ,Library e) throws Exception {
        Library f = repository.findById(id).orElse(null);
        if (f != null){
            f.setName(e.getName());
            return repository.save(f);
        }
        else {
            throw new Exception("Library not found");
        }
    }

    public Library delete(Integer id) throws Exception {
        Library f = repository.findById(id).orElse(null);
        if (f != null){
            repository.delete(f);
            return f;
        }
        else {
            throw new Exception("Library not found");
        }
    }
}
