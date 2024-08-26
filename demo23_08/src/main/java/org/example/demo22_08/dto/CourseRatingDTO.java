package org.example.demo22_08.dto;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo22_08.entity.Course;
import org.example.demo22_08.entity.CourseRatingKey;
import org.example.demo22_08.entity.Student;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRatingDTO {
    CourseRatingKey id;
    Student student;
    Course course;
    int rating;
}
