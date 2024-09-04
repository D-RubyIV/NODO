package org.example.intern.controller;

import org.apache.coyote.BadRequestException;
import org.example.intern.dto.StudentDTO;
import org.example.intern.mapper.StudentMapper;
import org.example.intern.service.StudentService;
import org.example.intern.validate.group.GroupCreate;
import org.example.intern.validate.group.GroupUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(value = "students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(
            //            @PageableDefault(page = 0, size = 10) Pageable pageable,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate from,
            @RequestParam(value = "to", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate to,
            @RequestParam(value = "page", required = false, defaultValue = "0") Optional<Integer> page,
            @RequestParam(value = "size", required = false, defaultValue = "5") Optional<Integer> size
    ) {
        Pageable pageable = PageRequest.of(page.get(), size.get());
        return ResponseEntity.ok(studentService.findAll(name, code, email, status, from, to, courseId, pageable));
    }

    @PostMapping(value = "", consumes = {"multipart/form-data"})
    public ResponseEntity<?> save(@Validated(GroupCreate.class) @ModelAttribute StudentDTO studentDTO) {
        return ResponseEntity.ok(studentMapper.entityToDTO(studentService.save(studentDTO)));
    }

    @PutMapping(value = "{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> update(@PathVariable Integer id, @Validated(GroupUpdate.class) @ModelAttribute StudentDTO studentDTO) throws BadRequestException {
        return ResponseEntity.ok(studentMapper.entityToDTO(studentService.updateExceptCode(id, studentDTO)));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws BadRequestException {
        return ResponseEntity.ok(studentMapper.entityToDTO(studentService.deleteSoft(id)));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id) throws BadRequestException {
        return ResponseEntity.ok(studentMapper.entityToDTODetail(studentService.detail(id)));
    }


}
