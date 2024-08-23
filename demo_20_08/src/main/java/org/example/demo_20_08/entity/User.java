package org.example.demo_20_08.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(index = 1)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @JsonProperty(index = 2)
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty(index = 3)
    @Column(name = "last_name")
    private String lastName;

    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @JoinColumn(name = "role_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Role role;


    @JsonGetter(value = "fullName")
    @JsonProperty(index = 4)
    public String getFullName(){
        return firstName + " " + lastName;
    }
}
