package org.example.bean.model.postgres;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_sequences")
    @SequenceGenerator(name = "sequences", initialValue = 1, allocationSize = 2)
    private Integer id;

    private String name;
}
