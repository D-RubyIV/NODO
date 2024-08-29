package org.example.intern.mapper;


import org.example.intern.dto.StudentDTO;
import org.example.intern.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO entityToDTO(Student student);
    List<StudentDTO> entityToDTOs(List<Student> students);

    Student DTOtoEntity(StudentDTO studentDTO);
    List<Student> DTOtoEntities(List<StudentDTO> studentDTOS);
}