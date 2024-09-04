package org.example.intern.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class CourseStudentKey implements Serializable {

    @Column(name = "student_id")
    Integer studentId;

    @Column(name = "course_id")
    Integer courseId;


}