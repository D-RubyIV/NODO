package org.example.demo22_08.mapper;

import org.example.demo22_08.dto.StudentDTO;
import org.example.demo22_08.entity.CourseRatingKey;
import org.example.demo22_08.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CourseRatingMapper.class)
public interface StudentMapper {
//    StudentDTO entityToDTO(Student student);
//    Student DTOtoEntity(StudentDTO studentDTO);
}
