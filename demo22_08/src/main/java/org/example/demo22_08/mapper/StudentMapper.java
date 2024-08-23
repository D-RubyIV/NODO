package org.example.demo22_08.mapper;

import jakarta.persistence.Entity;
import org.example.demo22_08.dto.StudentDTO;
import org.example.demo22_08.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "roomDTO", source = "room")
    StudentDTO EntityToDTO(Student student);
    List<StudentDTO> EntityToDTOs(List<Student> students);
}
