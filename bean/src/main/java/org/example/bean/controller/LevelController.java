package org.example.bean.controller;

import org.example.bean.model.mysql.Level;
import org.example.bean.repository.mysql.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "levels")
public class LevelController {
    @Autowired
    private LevelRepository levelRepository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(levelRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Level level){
        return ResponseEntity.ok(levelRepository.save(level));
    }
}
