package org.example.intern.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private Integer id;

    @NotBlank(message = "{NotNull}")
    @Length(max = 15, message = "{Length}")
    private String code;


    @NotBlank(message = "{NotBlank}")
    @Size(max = 255, message = "{Size}")

    private String description;


    private String image;

    @NotNull(message = "{NotNull}")
    private Boolean status;

    @NotBlank(message = "{NotBlank}")
    @Size(max = 255, message = "{Size}")
    private String title;

    @JsonIgnore
    private MultipartFile file;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createAt;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime updateAt;
}
