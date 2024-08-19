package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "ca_si")
public class Casi {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     private String ten_ca_si;
     private String que_quan;
     private Integer tuoi;
     private String cong_ty;
     private String sdt;
     private boolean gioi_tinh;
}
