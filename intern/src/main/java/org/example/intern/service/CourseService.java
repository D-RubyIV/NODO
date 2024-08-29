package org.example.intern.service;

import org.apache.coyote.BadRequestException;
import org.example.intern.dto.CourseDTO;
import org.example.intern.entity.Course;
import org.example.intern.mapper.CourseMapper;
import org.example.intern.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Course detail(Integer id ) throws BadRequestException {
//      FIND BY ID
        return courseRepository.findById(id).orElseThrow(() -> new BadRequestException("Course not found"));
    }

    public Course save(CourseDTO courseDTO){
        Course course = courseMapper.DTOtoEntity(courseDTO);
        return courseRepository.save(course);
    }

    public Course updateExceptCode(Integer id ,CourseDTO courseDTO) throws BadRequestException {
//      FIND BY ID
        Course entityFound = courseRepository.findById(id).orElseThrow(() -> new BadRequestException("Course not found"));
        Course courseMapped = courseMapper.DTOtoEntity(courseDTO);
//        SET AGAIN
        entityFound.setCode(entityFound.getCode());
        entityFound.setTitle(courseMapped.getTitle());
        entityFound.setDescription(courseMapped.getDescription());
        entityFound.setImage(courseMapped.getImage());
//        SAVE AGAIN
        return courseRepository.save(entityFound);
    }

    public Course deleteSoft(Integer id) throws BadRequestException {
//      FIND BY ID
        Course entityFound = courseRepository.findById(id).orElseThrow(() -> new BadRequestException("Course not found"));
//        SET AGAIN
        entityFound.setStatus(false);
//        SAVE AGAIN
        return courseRepository.save(entityFound);
    }
}
