package org.example.demo21_08.controller;

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

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody Library e){
        return ResponseEntity.ok(service.create(e));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Library e) throws Exception {
        return ResponseEntity.ok(service.update(id, e));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.detail(id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.delete(id));
    }
}
