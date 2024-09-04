package org.example.intern.mapper;


import org.example.intern.dto.CourseDTO;
import org.example.intern.dto.CourseStudentDTO;
import org.example.intern.dto.StudentDTO;
import org.example.intern.dto.StudentDetailDTO;
import org.example.intern.entity.Course;
import org.example.intern.entity.Student;
import org.example.intern.util.FileUploadUtil;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring", uses = CourseStudentMapper.class)
public interface StudentMapper {

    @Mapping(target = "courseStudentDTOs", source = "inCourses")
    StudentDTO entityToDTO(Student student);
    List<StudentDTO> entityToDTOs(List<Student> students);

    @Named(value = "v2")
    @Mapping(target = "courseStudentDTOs", source = "inCourses")
    StudentDetailDTO entityToDTODetail(Student student);

    @Mapping(target = "inCourses", source = "courseStudentDTOs")
    Student DTOtoEntity(StudentDTO studentDTO);
    List<Student> DTOtoEntities(List<StudentDTO> studentDTOS);

    @BeforeMapping
    default void beforeMapDTO(@MappingTarget Student course, StudentDTO studentDTO) {
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        MultipartFile f = studentDTO.getFile();
        if (f != null) {
            try {
                String nameImage = fileUploadUtil.saveFile(f.getOriginalFilename(), f, studentDTO.getCode());
                studentDTO.setImage(nameImage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMapping
    default void afterMapDTO(@MappingTarget StudentDTO studentDTO, Student course ) {
        // Set List Course
        List<CourseDTO> list = studentDTO.getCourseStudentDTOs().stream().map(CourseStudentDTO::getCourseDTO).toList();
//        studentDTO.setCourseDTOS(list);
        // Set Course Code
        List<String> listCode = list.stream().map(CourseDTO::getCode).toList();
        studentDTO.setCourses(String.join(", ", listCode));
    }

    @AfterMapping
    default void afterMapDTOStudentDetailDTO(@MappingTarget StudentDetailDTO studentDetailDTO, Student course ) {
        // Set List Course
        List<CourseDTO> list = studentDetailDTO.getCourseStudentDTOs().stream().map(CourseStudentDTO::getCourseDTO).toList();
        studentDetailDTO.setCourseDTOS(list);
    }
}