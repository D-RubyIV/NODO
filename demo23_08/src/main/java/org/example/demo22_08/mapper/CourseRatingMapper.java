package org.example.demo22_08.mapper;

import org.example.demo22_08.dto.CourseRatingDTO;
import org.example.demo22_08.entity.CourseRating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseRatingMapper {

//    @Mapping(source = "id", target = "id",ignore = true)
//    CourseRatingDTO entityToDTO(CourseRating courseRating);
//
//    CourseRating DTOtoEntity(CourseRatingDTO courseRatingDTO);
}
