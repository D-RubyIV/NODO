package org.example.demo27_08.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo27_08.group.GroupOne;
import org.example.demo27_08.group.GroupTwo;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidatedDTO {
    @NotNull(groups = GroupOne.class)
    @Email(groups = GroupOne.class)
    private String email;

    @NotNull(groups = GroupTwo.class)
    private String password;

    @NotNull
    private String name;
}
