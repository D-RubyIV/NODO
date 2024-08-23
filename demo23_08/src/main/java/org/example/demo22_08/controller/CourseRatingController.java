package org.example.demo22_08.controller;

import org.example.demo22_08.repository.CourseRatingRepository;
import org.example.demo22_08.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "course-rating")
public class CourseRatingController {
    @Autowired
    private CourseRatingRepository courseRatingRepository;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(courseRatingRepository.findAll());
    }

}
