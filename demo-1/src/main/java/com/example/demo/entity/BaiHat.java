package com.example.demo.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "bai_hat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ten_bai_hat;
    private String ten_tac_gia;
    private Integer thoi_luong;
    private LocalDateTime ngay_san_xuat;
    private Float gia;

    @ManyToOne
    @JoinColumn(name = "ca_si_id")
    private Casi casi;

    private String phat_hanh_dia;
    private LocalDateTime ngay_ra_mat;
}
