package org.example.demo22_08.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo22_08.entity.CourseRating;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private Integer id;
    private String name;
    private Set<StudentDTO> ratings;
}
