package org.example.demo27_08.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResponseStatusController {

    @GetMapping("/success")
    @ResponseStatus(HttpStatus.OK) // 200 OK
    public String success() {
        return "Success!";
    }

    @GetMapping("/created")
    @ResponseStatus(HttpStatus.CREATED) // 201 Created
    public String created() {
        return "Resource created!";
    }
}
