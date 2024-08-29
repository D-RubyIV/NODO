package org.example.demo27_08.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "room", targetEntity = User.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;
}
