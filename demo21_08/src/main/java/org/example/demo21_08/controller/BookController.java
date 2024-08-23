package org.example.demo21_08.controller;

import org.example.demo21_08.entity.Book;
import org.example.demo21_08.mapper.BookMapper;
import org.example.demo21_08.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookMapper bookMapper;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(
            @PageableDefault(page = 0, size = 20) Pageable pageable
    ) {
        return ResponseEntity.ok(bookService.findAll(pageable));
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody Book e) {
        return ResponseEntity.ok(bookService.create(e));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Book e) throws Exception {
        return ResponseEntity.ok(bookService.update(id, e));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(bookMapper.eToDto(bookService.detail(id)));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(bookService.delete(id));
    }
}
