package org.example.demo_20_08.service;

import jakarta.transaction.Transactional;
import org.example.demo_20_08.entity.Role;
import org.example.demo_20_08.entity.User;
import org.example.demo_20_08.repository.RoleRepository;
import org.example.demo_20_08.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    @Transactional
    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    @Transactional
    public Role create(Role e){
        return roleRepository.save(e);
    }

    @Transactional
    public Role detail(int id){
        Role rs = roleRepository.findById(id).orElse(null);
        System.out.println(rs);
        if(rs != null){
            System.out.println(rs.getUsers());
        }
        return rs;
    }

    @Transactional
    public Role delete(int id) {
        Role u = roleRepository.findById(id).orElse(null);
        if (u != null){
            roleRepository.deleteById(id);
            return u;
        }
        return null;
    }

}
