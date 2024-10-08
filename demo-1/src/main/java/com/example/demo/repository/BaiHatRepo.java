package com.example.demo.repository;

import com.example.demo.entity.BaiHat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BaiHatRepo extends JpaRepository<BaiHat, Integer> {
    Page<BaiHat> findAllBy(Pageable pageable);
}

