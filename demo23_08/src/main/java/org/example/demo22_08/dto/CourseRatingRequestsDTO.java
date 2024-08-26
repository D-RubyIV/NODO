package org.example.demo22_08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRatingRequestsDTO {
    private Integer idStudent;
    private Integer idCourse;
    private Integer rating;
}
