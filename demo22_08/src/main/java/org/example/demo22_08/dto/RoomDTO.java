package org.example.demo22_08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo22_08.entity.Student;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private Integer id;
    private String name;
//    private Set<StudentDTO> studentDTOS;

}
