package org.example.demo22_08.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.demo22_08.validate.CapitalizedConstraint;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "student")
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
//    @NotBlank
//    @NotNull
//    @CapitalizedConstraint
//    @Length(min = 3, max = 10, message = "Name must from 3 - 10 char")
//    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Must not contain special characters")
    private String name;

//    @Column(name = "age")
//    @Positive(message = "age must is positive")
//    @NotNull
//    @Min(value = 0)
//    @Max(value = 116)
//    @Range(min = 0, max = 116)
    private Integer age;

//    @Past(message = "Date invalid")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//    @Column(name = "birth_day")
//    @NotNull
    private Date birthDay;


//    @DecimalMin(value = "10.0", inclusive = true)
//    @DecimalMax(value = "2000.0", inclusive = false)
//    @Digits(integer = 3, fraction = 2)
//    @NotNull
    private BigDecimal balance;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true, targetEntity = Room.class)
    private Room room;

}
