package org.example.demo_20_08.controller;

import org.example.demo_20_08.entity.User;
import org.example.demo_20_08.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value = "")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody User e){
        return ResponseEntity.ok(service.create(e));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody User user){
        return ResponseEntity.ok(service.update(id, user));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ResponseEntity.ok(service.delete(id));
    }
}
