package org.example.intern.controller;

import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.example.intern.dto.CourseDTO;
import org.example.intern.mapper.CourseMapper;
import org.example.intern.service.CourseService;
import org.example.intern.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(courseMapper.entityToDTOs(courseService.findAll()));
    }

    @PostMapping(value = "", consumes = {"multipart/form-data"})
    public ResponseEntity<?> save(@Valid @ModelAttribute CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.save(courseDTO));
    }

    @PutMapping(value = "{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @ModelAttribute CourseDTO courseDTO) throws BadRequestException {
        return ResponseEntity.ok(courseService.updateExceptCode(id, courseDTO));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws BadRequestException {
        return ResponseEntity.ok(courseService.deleteSoft(id));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id) throws BadRequestException {
        return ResponseEntity.ok(courseService.detail(id));
    }
}
