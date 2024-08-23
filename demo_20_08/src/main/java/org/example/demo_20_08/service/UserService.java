package org.example.demo_20_08.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.demo_20_08.dto.UsersDTO;
import org.example.demo_20_08.entity.Role;
import org.example.demo_20_08.entity.User;
import org.example.demo_20_08.mapper.UserMapper;
import org.example.demo_20_08.repository.RoleRepository;
import org.example.demo_20_08.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public List<UsersDTO> findAll() {
//        return userRepository.findAll();
        return userRepository.findAll().stream().map(s -> userMapper.entityToUserDto(s)).toList();
    }

    @Transactional
    public User create(User user) {
        if (user.getRole().getId() != null){
            return entityManager.merge(user);
        }
        else{
            return userRepository.save(user) ;
        }
    }

    @Transactional
    public User update(int id, User user) {
        Role r = roleRepository.findById(user.getId()).orElse(null);
        User u = userRepository.findById(id).orElse(null);

        if (u != null){
            BeanUtils.copyProperties(user, u);
        }
        if (r != null){
            return entityManager.merge(u);
        }
        return null;
    }

    @Transactional
    public User delete(int id) {
        User u = userRepository.findById(id).orElse(null);
        if (u != null){
            userRepository.deleteById(id);
            return u;
        }
        return null;
    }
}
