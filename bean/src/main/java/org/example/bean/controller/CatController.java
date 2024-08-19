package org.example.bean.controller;


import org.example.bean.model.mysql.Level;
import org.example.bean.model.postgres.Cat;
import org.example.bean.model.postgres.Dog;
import org.example.bean.repository.mysql.LevelRepository;
import org.example.bean.repository.postgres.CatRepository;
import org.example.bean.repository.postgres.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cats")
public class CatController {
    @Autowired
    private CatRepository catRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(catRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cat e){
        return ResponseEntity.ok(catRepository.save(e));
    }

}
