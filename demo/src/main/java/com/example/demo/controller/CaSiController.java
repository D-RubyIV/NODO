package com.example.demo.controller;

import com.example.demo.entity.Casi;
import com.example.demo.repository.CaSiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ca-si")
public class CaSiController {

    @Autowired
    private CaSiRepo caSiRepo;

    // C4
    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Casi casi){
        return ResponseEntity.ok(caSiRepo.save(casi));
    }
    // C5
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        caSiRepo.deleteById(id);
    }

}
