package org.example.demo22_08;

import jakarta.annotation.PostConstruct;
import org.example.demo22_08.entity.Course;
import org.example.demo22_08.entity.CourseRating;
import org.example.demo22_08.entity.CourseRatingKey;
import org.example.demo22_08.entity.Student;
import org.example.demo22_08.repository.CourseRatingRepository;
import org.example.demo22_08.repository.CourseRepository;
import org.example.demo22_08.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitDatabase {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseRatingRepository courseRatingRepository;

    @PostConstruct
    public void init(){
        if (courseRepository.findById(1).isEmpty()){
            Course course = new Course();
            course.setName("Course 1");
            courseRepository.save(course);

        }
        if (courseRepository.findById(2).isEmpty()){
            Course course = new Course();
            course.setName("Course 2");
            courseRepository.save(course);

        }
        if (studentRepository.findById(1).isEmpty()){
            Student student = new Student();
            student.setName("Student 1");
            studentRepository.save(student);
        }
        if (studentRepository.findById(2).isEmpty()){
            Student student = new Student();
            student.setName("Student 2");
            studentRepository.save(student);
        }
        if (courseRatingRepository.findById(new CourseRatingKey(1, 1)).isEmpty()){
            CourseRating courseRating = new CourseRating();
            courseRating.setId(new CourseRatingKey(1, 1));
            courseRating.setRating(10);
            courseRating.setStudent(studentRepository.findById(1).orElse(null));
            courseRating.setCourse(courseRepository.findById(1).orElse(null));
            courseRatingRepository.save(courseRating);
        }
    }

}
