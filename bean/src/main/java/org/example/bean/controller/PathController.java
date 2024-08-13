package org.example.bean.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("path")
public class PathController {

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable(name = "id", required = false) String userId) {
        return "User ID: " + (userId != null ? userId : "unknown");
    }

}
