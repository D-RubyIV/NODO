package org.example.demo22_08.service;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.demo22_08.dto.RoleDTO;
import org.example.demo22_08.entity.Role;
import org.example.demo22_08.entity.User;
import org.example.demo22_08.mapper.RoleMapper;
import org.example.demo22_08.repository.RoleRepository;
import org.example.demo22_08.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private RoleMapper roleMapper;

    @Transactional
    public List<RoleDTO> getAllRoles() {
        return roleMapper.entityToDTOs(roleRepository.findAll());
    }

    @Transactional
    public Optional<Role> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    public Role saveRole(Role role) {

        Role result = roleRepository.save(role);

        Set<User> users = new HashSet<>(role.getUsers()); // Tạo bản sao
        users.forEach(e -> {
            e.setRoles(new HashSet<>(Set.of(role)));
            userRepository.save(e);
        });

        return result;
    }


    @Transactional
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
