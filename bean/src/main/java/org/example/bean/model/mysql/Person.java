package org.example.bean.model.mysql;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.example.bean.enums.EStatus;
import org.example.bean.model.postgres.Role;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties(value = {"balance"}, allowSetters = false, allowGetters = true, ignoreUnknown = false)
@Table(
        name = "persons",
        uniqueConstraints = @UniqueConstraint(name = "abc", columnNames = {"name", "address"}),
        indexes = {
                @Index(name = "index_1", columnList = "name"),
                @Index(name = "index_2", columnList = "address"),
                @Index(name = "index_3", columnList = "fakeName", unique = true),
                @Index(name = "index_name_address", columnList = "name, address")
        }
)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonProperty(value = "FakeName")
    private String fakeName;

    @JsonProperty(value = "customAge")
    private int age;

    private String address;

    private Double balance;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EStatus status;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss",
            timezone = "America/New_York",
            lenient = OptBoolean.TRUE
    )
    private LocalDateTime createAtDay;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    @JsonSetter("set_age")
    public void setAge(int age) {
        this.age = age;
    }

    @JsonGetter("getCustomPropertiesAge")
    public String getCustomPropertiesAge() {
        return age + " Custom";
    }

    @JsonGetter("get_age")
    public int getAge() {
        return age;
    }

    @ManyToOne
    @JoinColumn
    private Level level;
}