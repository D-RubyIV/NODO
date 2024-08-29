package org.example.demo27_08.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "book")
@Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = {"code"}))
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private Integer price;

    @JsonBackReference
    @JoinColumn(name = "library_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Library library;
}


