package org.example.bean.model.postgres;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @SequenceGenerator(name = "custom_sequences", sequenceName = "custom_sequences", initialValue = 5, allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_sequences")
    private Integer id;
    private String name;
}
