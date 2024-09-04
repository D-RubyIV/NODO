package org.example.intern.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentDTO {
    private CourseDTO courseDTO;
    private StudentDTO studentDTO;
    private Integer joined;
}
