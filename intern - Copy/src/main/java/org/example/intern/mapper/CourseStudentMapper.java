package org.example.intern.mapper;


import org.example.intern.dto.CourseStudentDTO;
import org.example.intern.entity.CourseStudent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseStudentMapper {

    @Mapping(target = "courseDTO", source = "course")
    CourseStudentDTO toStudentCourseDTO(CourseStudent courseStudent);

}
