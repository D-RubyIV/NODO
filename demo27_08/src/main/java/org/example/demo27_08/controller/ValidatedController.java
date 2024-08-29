package org.example.demo27_08.controller;

import jakarta.validation.Valid;
import org.example.demo27_08.dto.ValidatedDTO;
import org.example.demo27_08.group.GroupOne;
import org.example.demo27_08.group.GroupTwo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vali")
public class ValidatedController {
    @PostMapping
    public ResponseEntity<?> create(@Validated(GroupOne.class) ValidatedDTO dto){
        return ResponseEntity.ok("OK");
    }
}
