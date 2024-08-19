package org.example.bean.repository.mysql;

import org.example.bean.model.mysql.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {
}
