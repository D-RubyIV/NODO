package com.example.demo.repository;

import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
//    @Query(value = "select new com.example.demo.response.NhanVienResponse(n.id, n.ten) from  NhanVien n join ChucVu c on n. = c.id")
//    List<NhanVien> findCus();

//    @Query(value = "select n.id, n.ma, concat(n.ho, n.ten) as fullName, n.gioi_tinh, n.dia_chi, c.ten from nhan_vien n join chuc_vu c on n.id_cv = c.id ", nativeQuery = true)
}
