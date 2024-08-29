package org.example.demo21_08.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.demo21_08.dto.BookDTO;
import org.example.demo21_08.entity.Book;
import org.example.demo21_08.mapper.BookMapper;
import org.example.demo21_08.repository.BookRepository;
import org.example.demo21_08.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookMapper bookMapper;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(BookDTO dto) {
        Book book = bookMapper.DTOtoEntity(dto);
        return bookRepository.save(book);
    }

}
