package org.example.demo27_08.service;

import org.example.demo27_08.dto.UserDTO;
import org.example.demo27_08.entity.User;
import org.example.demo27_08.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(UserDTO dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return userRepository.save(user);
    }
}
