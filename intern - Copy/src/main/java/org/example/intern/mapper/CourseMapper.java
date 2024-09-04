package org.example.intern.mapper;

import org.example.intern.dto.CourseDTO;
import org.example.intern.entity.Course;
import org.example.intern.util.FileUploadUtil;
import org.mapstruct.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface CourseMapper {


    @Mapping(target = "courseStudentDTOs", source = "inCourses")
    CourseDTO entityToDTO(Course course);
    List<CourseDTO> entityToDTOs(List<Course> courses);

    @Mapping(target = "inCourses", source = "courseStudentDTOs")
    Course DTOtoEntity(CourseDTO courseDTO);
    List<Course> DTOtoEntities(List<CourseDTO> courseDTOS);


    @BeforeMapping
    default void afterMapDTO(@MappingTarget Course course, CourseDTO courseDTO) {
        FileUploadUtil fileUploadUtil = new FileUploadUtil();
        MultipartFile f = courseDTO.getFile();
        if (f != null) {
            try {
                String nameImage = fileUploadUtil.saveFile(f.getName(), f, courseDTO.getCode());
                courseDTO.setImage(nameImage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
