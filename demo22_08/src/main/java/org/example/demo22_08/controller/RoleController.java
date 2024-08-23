package org.example.demo22_08.controller;

import org.example.demo22_08.entity.Role;
import org.example.demo22_08.mapper.RoleMapper;
import org.example.demo22_08.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping
    public ResponseEntity<?> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Integer id) {
        Optional<Role> role = roleService.getRoleById(id);
        if (role.isPresent()){
            return ResponseEntity.ok(roleMapper.entityToDTO(role.get()));
        }
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleMapper.entityToDTO(roleService.saveRole(role)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Integer id, @RequestBody Role role) {
        if (roleService.getRoleById(id).isPresent()) {
            role.setId(id);
            return ResponseEntity.ok(roleMapper.entityToDTO(roleService.saveRole(role)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        if (roleService.getRoleById(id).isPresent()) {
            roleService.deleteRole(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
