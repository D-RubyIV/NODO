package org.example.intern.controller;

import org.apache.coyote.BadRequestException;
import org.example.intern.dto.CourseDTO;
import org.example.intern.mapper.CourseMapper;
import org.example.intern.repository.CourseRepository;
import org.example.intern.service.CourseService;
import org.example.intern.validate.group.GroupCreate;
import org.example.intern.validate.group.GroupUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(value = "courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(
//            @PageableDefault(page = 0, size = 10) Pageable pageable,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate from,
            @RequestParam(value = "to", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate to,
            @RequestParam(value = "page", required = false, defaultValue = "0") Optional<Integer> page,
            @RequestParam(value = "size", required = false, defaultValue = "5") Optional<Integer> size
    ) {
        Pageable pageable = PageRequest.of(page.get(), size.get());
        return ResponseEntity.ok(courseService.findAll(title, status, code, from, to, pageable));
    }

    @PostMapping(value = "", consumes = {"multipart/form-data"})
    public ResponseEntity<?> save(@Validated(GroupCreate.class) @ModelAttribute CourseDTO courseDTO, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        return ResponseEntity.ok(courseMapper.entityToDTO(courseService.save(courseDTO)));
    }

    @PutMapping(value = "{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> update(@PathVariable Integer id, @Validated(GroupUpdate.class) @ModelAttribute CourseDTO courseDTO, BindingResult bindingResult) throws BadRequestException, BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        return ResponseEntity.ok(courseMapper.entityToDTO(courseService.updateExceptCode(id, courseDTO)));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws BadRequestException {
        return ResponseEntity.ok(courseMapper.entityToDTO(courseService.deleteSoft(id)));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id) throws BadRequestException {
        return ResponseEntity.ok(courseMapper.entityToDTO(courseService.detail(id)));
    }
}
