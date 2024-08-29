package org.example.demo27_08.controller;

import org.apache.coyote.BadRequestException;
import org.example.demo27_08.exception.CustomExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ngoai-pham-vi")
public class NgoaiPhamViController {
    @GetMapping(value = "")
    public ResponseEntity<?> abc() throws BadRequestException {
        throw new CustomExceptions.CustomResourceNotFoundException("Xin chào");
    }
}
