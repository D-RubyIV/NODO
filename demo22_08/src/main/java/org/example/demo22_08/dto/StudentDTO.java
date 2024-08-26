package org.example.demo22_08.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Integer id;
    private String name;
    private Integer age;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private BigDecimal balance;
    private Date birthDay;
    private RoomDTO roomDTO;
}
