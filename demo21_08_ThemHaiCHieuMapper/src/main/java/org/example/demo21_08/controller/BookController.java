package org.example.demo21_08.controller;

import org.example.demo21_08.dto.BookDTO;
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
        return ResponseEntity.ok(bookMapper.entityToDTOs(bookService.findAll()));
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody BookDTO dto) {
        return ResponseEntity.ok(bookMapper.entityToDTO(bookService.create(dto)));
    }


}
