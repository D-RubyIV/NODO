package org.example.intern.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Integer id;
    private String code;
    private String email;
    private String image;
    private String name;
    private Boolean status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createAt;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime updateAt;
}
