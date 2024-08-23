package org.example.demo_20_08;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.example.demo_20_08.entity.Role;
import org.example.demo_20_08.entity.User;
import org.example.demo_20_08.repository.RoleRepository;
import org.example.demo_20_08.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    @Transactional
    public void init(){
//        if (roleRepository.findById(1).isEmpty()){
//            Role e = new Role();
//            e.setName("Admin");
//            roleRepository.save(e);
//        }
//        if(userRepository.findById(1).isEmpty()){
//            User u = new User();
//            u.setUsername("phah04");
//            u.setPassword("123456");
//            u.setFirstName("Pham");
//            u.setLastName("Ha Anh");
//            u.setRole(roleRepository.findById(1).orElse(null));
//            userRepository.save(u);
//        }

    }

}
