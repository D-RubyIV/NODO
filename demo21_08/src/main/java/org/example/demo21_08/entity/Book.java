package org.example.demo21_08.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
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


