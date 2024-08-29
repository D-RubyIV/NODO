package org.example.demo21_08.service;

import jakarta.persistence.EntityManager;
import org.example.demo21_08.dto.LibraryDTO;
import org.example.demo21_08.entity.Book;
import org.example.demo21_08.entity.Library;
import org.example.demo21_08.mapper.LibraryMapper;
import org.example.demo21_08.repository.BookRepository;
import org.example.demo21_08.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository repository;
    @Autowired
    private LibraryMapper libraryMapper;

    public List<Library> findAll(){
        return repository.findAll();
    }

    public Library createv1(LibraryDTO e){
        Library library = libraryMapper.DTOtoEntity(e);
        System.out.println("--------------------------------1");
        System.out.println(library);
        System.out.println(library.getBooks());
//        return library;
//        System.out.println("--------------------------------");
        return repository.save(library);
    }

    public Library createv2(Library library){
        System.out.println("--------------------------------2");
        System.out.println(library);
        System.out.println(library.getBooks());
//        return library;
//        System.out.println("--------------------------------");
        return repository.save(library);
    }
}
