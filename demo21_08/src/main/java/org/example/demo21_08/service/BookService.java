package org.example.demo21_08.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.demo21_08.entity.Book;
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

    public Page<Book> findAll(Pageable pageable){
        // C1;
//        return bookRepository.findAllByQuery(pageable);
        // C2:
        return bookRepository.findAll(pageable);



    }

    @Transactional
    public Book create(Book e){
        if (e.getLibrary().getId() != null && libraryRepository.findById(e.getLibrary().getId()).isPresent()){
            return entityManager.merge(e);
        }
        else {
            return bookRepository.save(e);
        }
    }

    public Book detail(Integer id) throws Exception {

        // C1
//        Book f = bookRepository.findById(id).orElse(null);
//        if (f != null){
//            System.out.println(f.getLibrary());
//            return f;
//        }
//        else {
//            throw new Exception("Book not found");
//        }
        // C2:
//        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM book b where b.id = :id", Book.class);
//        query.setParameter("id", id);
//        return query.getSingleResult();
        // C3:
        return bookRepository.findByQuery(id);
    }

    public Book update(Integer id ,Book e) throws Exception {
        Book f = bookRepository.findById(id).orElse(null);
        if (f != null){
            f.setName(e.getName());
            f.setPrice(e.getPrice());
            return bookRepository.save(f);
        }
        else {
            throw new Exception("Book not found");
        }
    }

    public Book delete(Integer id) throws Exception {
        Book f = bookRepository.findById(id).orElse(null);
        if (f != null){
            bookRepository.delete(f);
            return f;
        }
        else {
            throw new Exception("Book not found");
        }
    }
}
