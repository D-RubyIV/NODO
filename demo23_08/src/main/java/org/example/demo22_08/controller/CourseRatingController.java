package org.example.demo22_08.controller;

import org.example.demo22_08.dto.CourseRatingDTO;
import org.example.demo22_08.dto.CourseRatingRequestsDTO;
import org.example.demo22_08.entity.Course;
import org.example.demo22_08.entity.CourseRating;
import org.example.demo22_08.entity.CourseRatingKey;
import org.example.demo22_08.entity.Student;
import org.example.demo22_08.repository.CourseRatingRepository;
import org.example.demo22_08.repository.CourseRepository;
import org.example.demo22_08.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "course-rating")
public class CourseRatingController {
    @Autowired
    private CourseRatingRepository courseRatingRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(courseRatingRepository.findAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<?> save(@RequestBody CourseRatingRequestsDTO dto) throws Exception {
        Student student = studentRepository.findById(dto.getIdStudent()).orElse(null);
        Course course = courseRepository.findById(dto.getIdCourse()).orElse(null);
        if (student != null && course != null){
            CourseRating courseRating = new CourseRating();
            courseRating.setStudent(student);
            courseRating.setCourse(course);
            courseRating.setRating(dto.getRating());
            courseRating.setId(new CourseRatingKey(student.getId(), course.getId()));
            return ResponseEntity.ok(courseRatingRepository.save(courseRating));
        }
        else {
            throw new Exception("Error");
        }
    }

}
