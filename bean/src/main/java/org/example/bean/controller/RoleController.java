package org.example.bean.controller;

import org.example.bean.model.postgres.Author;
import org.example.bean.model.postgres.Role;
import org.example.bean.repository.postgres.AuthorRepository;
import org.example.bean.repository.postgres.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roles")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(roleRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Role e){
        return ResponseEntity.ok(roleRepository.save(e));
    }
}
