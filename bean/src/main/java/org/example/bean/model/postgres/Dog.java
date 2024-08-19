package org.example.bean.model.postgres;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "dogs", schema = "animal")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "test_gen")
    @TableGenerator(
            name = "test_gen",
            table = "id_generator",
            pkColumnName = "gen_name",
            valueColumnName = "gen_value",
            pkColumnValue = "id",
            allocationSize = 1)
    private Integer id;

    private String name;

}
