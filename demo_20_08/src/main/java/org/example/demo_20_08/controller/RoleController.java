package org.example.demo_20_08.controller;

import org.example.demo_20_08.entity.Role;
import org.example.demo_20_08.entity.User;
import org.example.demo_20_08.service.RoleService;
import org.example.demo_20_08.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody Role e){
        return ResponseEntity.ok(service.create(e));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> detail(@PathVariable int id){
        return ResponseEntity.ok(service.detail(id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ResponseEntity.ok(service.delete(id));
    }

}
