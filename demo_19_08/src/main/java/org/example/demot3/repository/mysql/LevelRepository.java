package org.example.demot3.repository.mysql;

import org.example.demot3.entity.mysql.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {
}
