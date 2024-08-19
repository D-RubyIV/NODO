package org.example.bean.controller;

import org.example.bean.model.mysql.Level;
import org.example.bean.model.postgres.Dog;
import org.example.bean.repository.postgres.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "dogs")
public class DogController {
    @Autowired
    private DogRepository dogRepository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(dogRepository.findAll()
        );
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Dog e){
        return ResponseEntity.ok(dogRepository.save(e));
    }

}
