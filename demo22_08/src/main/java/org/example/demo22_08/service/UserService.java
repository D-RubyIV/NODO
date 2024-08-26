package org.example.demo22_08.service;

import org.example.demo22_08.entity.Role;
import org.example.demo22_08.entity.User;
import org.example.demo22_08.mapper.UserMapper;
import org.example.demo22_08.repository.RoleRepository;
import org.example.demo22_08.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public User saveUser(User user) throws SQLException {
        Set<Role> set = saveRoles(user);
        user.setRoles(set);
        return userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Set<Role> saveRoles(User user) throws SQLException {
        return user.getRoles().stream().map(s -> {
            if (s.getId() != null) {
                Optional<Role> optional = roleRepository.findById(s.getId());
                return optional.orElseGet(() -> roleRepository.save(s));
            } else {
                return roleRepository.save(s);
            }
        }).collect(Collectors.toSet());
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteUser(Integer id) throws RuntimeException {
        userRepository.deleteById(id);
        throw new RuntimeException();
    }

// NO ROLLBACK FOR

//    @Transactional(noRollbackFor = {ArithmeticException.class})
//    public void deleteUser(Integer id) throws RuntimeException{
//        userRepository.deleteById(id);
//        int rs = 1/0;
//    }

// ROLLBACK FOR

//    @Transactional(rollbackFor = {ArithmeticException.class})
//    public void deleteUser(Integer id) throws RuntimeException{
//        userRepository.deleteById(id);
//        int rs = 1/0;
//    }

//   KHÔNG ROLLBACK VỚI CHECKED EXCEPTION
//    @Transactional()
//    public void deleteUser(Integer id) throws RuntimeException, SQLException {
//        userRepository.deleteById(id);
//        throw new SQLException();
//    }

//   ROLLBACK VỚI CHECKED EXCEPTION
//    @Transactional(rollbackFor = {SQLException.class})
//    public void deleteUser(Integer id) throws RuntimeException, SQLException {
//        userRepository.deleteById(id);
//        throw new SQLException();
//    }
}

