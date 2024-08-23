package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@RequestMapping("staffs")
@RestController
public class NhanVienController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(nhanVienRepository.findAll());
    }

    @GetMapping("v2")
    public ResponseEntity<?> findAllByPage(
            @PageableDefault(size = 5, page = 0) Pageable pageable
    ) {
        return ResponseEntity.ok(nhanVienRepository.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<NhanVien> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(nhanVienRepository.findById(id).orElseThrow(() -> new Exception("Error")));
    }

}
