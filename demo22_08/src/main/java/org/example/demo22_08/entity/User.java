package org.example.demo22_08.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "user")
@Table(name = "users")
@EqualsAndHashCode(exclude = {"roles"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role", // Cái này là ta đặt tên bảng cho mối quan hệ là gì
            joinColumns = @JoinColumn(name = "user_id"), // Column mà bảng hiện tại sẽ liên kết với bảng trung gian
            inverseJoinColumns = @JoinColumn(name = "role_id")//Column mà bảng phụ sẽ liên kết với bảng trung gian
    )
    private Set<Role> roles;
}

