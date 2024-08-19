package org.example.bean.model.postgres;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cats", schema = "animal")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "test_gen")
    @TableGenerator(
            name = "test_gen", // phải map với bên trên
            table = "id_generator", // tên bảng phụ được tạo
            pkColumnName = "gen_name", //  tên cột chứa giá trị tên trường đuọc map
            valueColumnName = "gen_value", // tên cột chứa giá trị tự động tăng
            pkColumnValue = "id", // giá trih tên trường đuọc map
            allocationSize = 1 // số giá trị ID mỗi lần được call
    )
    private Integer id;

    private String name;

}

