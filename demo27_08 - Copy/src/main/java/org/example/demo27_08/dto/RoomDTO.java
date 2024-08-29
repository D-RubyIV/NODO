package org.example.demo27_08.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private Integer id;
    private String name;
    private List<UserDTO> userDTOs;
}
