package org.example.intern.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.intern.validate.ZeroOneConstraint;
import org.example.intern.validate.group.GroupCreate;
import org.example.intern.validate.group.GroupUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Integer id;

    @Length(message = "Length-4-8", min = 4, max = 8, groups = {GroupCreate.class})
    @NotNull(message = "NotNull", groups = {GroupCreate.class})
    @NotBlank(message = "NotBlank", groups = {GroupCreate.class})
    private String code;

    @Length(message = "Length-5-25", min = 5, max = 25, groups = {GroupCreate.class, GroupUpdate.class})
    @NotNull(message = "NotNull", groups = {GroupCreate.class, GroupUpdate.class})
    @NotBlank(message = "NotBlank", groups = {GroupCreate.class, GroupUpdate.class})
    @Email(message = "Email", groups = {GroupCreate.class, GroupUpdate.class})
    private String email;

    @NotBlank(message = "NotBlank", groups = {GroupCreate.class, GroupUpdate.class})
    @NotNull(message = "NotNull", groups = {GroupCreate.class, GroupUpdate.class})
    @Length(message = "Length-5-15", min = 5, max = 15, groups = {GroupCreate.class, GroupUpdate.class})
    private String name;

    private String image;

    @ZeroOneConstraint(message = "ZeroOneConstraint", groups = {GroupUpdate.class})
    private Integer status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate updatedDate;

//    private List<CourseDTO> courseDTOS;


    // OTHER
    @JsonIgnore
    private MultipartFile file;

    @JsonIgnore
    private List<CourseStudentDTO> courseStudentDTOs;

    @JsonIgnore
    private List<Integer> courseIds;

    private String courses;
}
