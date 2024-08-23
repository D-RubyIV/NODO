package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class ChucVuController {
    @Autowired
    private ChucVuRepositoty chucVuRepositoty;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ChucVu chucVu){
        return ResponseEntity.ok(chucVuRepositoty.save(chucVu));
    }



}
