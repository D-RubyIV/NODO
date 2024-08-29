package org.example.demo21_08.service;

import org.example.demo21_08.dto.LibraryDTO;
import org.example.demo21_08.entity.Book;
import org.example.demo21_08.entity.Library;
import org.example.demo21_08.mapper.LibraryMapper;
import org.example.demo21_08.repository.BookRepository;
import org.example.demo21_08.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository repository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private LibraryMapper libraryMapper;

    @Transactional(readOnly = true)
    public List<Library> findAll() {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Library createv1(LibraryDTO e) {
        Library library = libraryMapper.DTOtoEntity(e);
        Library rs = repository.save(library);
        try {
            bookService.saveNewBook();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return rs;
    }

    @Transactional
    public Library createv2(Library library) {
        System.out.println("--------------------------------2");
        System.out.println(library);
        System.out.println(library.getBooks());
        Library rs  = repository.save(library);

        return rs;
    }


}
