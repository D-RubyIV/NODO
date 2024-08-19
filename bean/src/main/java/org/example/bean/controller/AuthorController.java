package org.example.bean.controller;

import org.example.bean.model.mysql.Level;
import org.example.bean.model.postgres.Author;
import org.example.bean.repository.postgres.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Author author){
        return ResponseEntity.ok(authorRepository.save(author));
    }
}
