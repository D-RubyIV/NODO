package org.example.demo21_08.controller;

import org.example.demo21_08.dto.LibraryDTO;
import org.example.demo21_08.entity.Library;
import org.example.demo21_08.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "libraries")
public class LibraryController {
    @Autowired
    private LibraryService service;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(value = "v1")
    public ResponseEntity<?> createv1(@RequestBody LibraryDTO e){
        return ResponseEntity.ok(service.createv1(e));
    }

    @PostMapping(value = "v2")
    public ResponseEntity<?> createv2(@RequestBody Library e){
        return ResponseEntity.ok(service.createv2(e));
    }
}
