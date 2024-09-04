package org.example.intern.mapper;


import org.example.intern.dto.CourseDTO;
import org.example.intern.dto.StudentDTO;
import org.example.intern.entity.Course;
import org.example.intern.entity.Student;
import org.example.intern.util.FileUploadUtil;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring", uses = CourseStudentMapper.class)
public interface StudentMapper {


    @Mapping(target = "courseStudentDTOs", source = "inCourses")
    StudentDTO entityToDTO(Student student);
    List<StudentDTO> entityToDTOs(List<Student> students);

    @Mapping(target = "inCourses", source = "courseStudentDTOs")
    Student DTOtoEntity(StudentDTO studentDTO);
    List<Student> DTOtoEntities(List<StudentDTO> studentDTOS);

    @BeforeMapping
    default void afterMapDTO(@MappingTarget Student course, StudentDTO studentDTO) {
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        MultipartFile f = studentDTO.getFile();
        if (f != null) {
            try {
                String nameImage = fileUploadUtil.saveFile(f.getName(), f, studentDTO.getCode());
                studentDTO.setImage(nameImage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}