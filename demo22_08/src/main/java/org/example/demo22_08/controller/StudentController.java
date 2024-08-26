package org.example.demo22_08.controller;

import jakarta.validation.Valid;
import org.example.demo22_08.entity.Student;
import org.example.demo22_08.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<?> save(@Valid @RequestBody Student student, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }
        return ResponseEntity.ok(studentService.saveStudent(student));
    }
}
