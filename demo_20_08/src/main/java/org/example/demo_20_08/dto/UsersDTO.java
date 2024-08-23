package org.example.demo_20_08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo_20_08.entity.Role;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String role;
}
