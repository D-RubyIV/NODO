package org.example.demot3.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demot3.entity.mysql.Level;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDto {
    private Integer id;

    private String address;

    private Integer age;

    private Double balance;

    private LocalDateTime createAt;

    private String lastName;

    private String firstName;

    private Byte status;

    private LocalDateTime updateAt;

    private String nameMapper;

    private String nameMapperV2;

    private Integer levelId;


}
