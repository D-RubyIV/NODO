package org.example.intern.service;

import org.example.intern.entity.CourseStudent;
import org.example.intern.repository.CourseStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseStudentService {
    @Autowired
    private CourseStudentRepository courseStudentRepository;

    public CourseStudent save(CourseStudent courseStudent){
        return courseStudentRepository.save(courseStudent);
    }
}
