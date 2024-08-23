package org.example.demot3;

import jakarta.annotation.PostConstruct;
import org.example.demot3.entity.mysql.Level;
import org.example.demot3.repository.mysql.LevelRepository;
import org.example.demot3.repository.mysql.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase {
    @Autowired
    private LevelRepository levelRepository;

    @PostConstruct
    public void init(){
        if (levelRepository.findById(1).isEmpty()){
            Level level = new Level();
            level.setName("Level 1");
            levelRepository.save(level);
        }
    }

}
