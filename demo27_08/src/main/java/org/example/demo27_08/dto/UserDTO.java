package org.example.demo27_08.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo27_08.validate.CapitalizedConstraint;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Integer id;

    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "{customer.name.invalid}")
    @CapitalizedConstraint(message = "{CapitalizedConstraint}")
    @Length(min = 2, max = 10)
    private String username;

    @NotBlank(message = "{NotBlank}")
    private String password;

    @NotNull(message = "{NotNull}")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDay;

    @NotNull(message = "{NotNull}")
    @DecimalMin(value = "10", inclusive = true)
    @DecimalMax(value = "100", inclusive = true)
    @PositiveOrZero
    @Range(min = 0, max = 1000)
    private Long balance;
}
