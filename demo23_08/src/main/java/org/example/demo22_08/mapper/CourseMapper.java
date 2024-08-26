package org.example.demo22_08.mapper;

import org.example.demo22_08.dto.CourseDTO;
import org.example.demo22_08.entity.Course;
import org.example.demo22_08.entity.CourseRating;
import org.example.demo22_08.entity.CourseRatingKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface CourseMapper {
//    CourseDTO entityToDTO(Course course);
//    Course DTOtoEntity(CourseDTO courseDTO);
}
