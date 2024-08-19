package com.example.demo.controller;

import com.example.demo.entity.BaiHat;
import com.example.demo.repository.BaiHatRepo;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bai-hat")
public class BaiHatController {
    @Autowired
    private BaiHatRepo baiHatRepo;

    // C2
    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(baiHatRepo.findAll());
    }

    // C3
    @GetMapping("/page")
    public ResponseEntity<?> findAllByPage(
            @RequestParam(name = "limit", defaultValue = "5") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset
    ){
        Pageable pageable = PageRequest.of(offset, limit);
        return ResponseEntity.ok(baiHatRepo.findAllBy(pageable));
    }


}
