package org.example.bean.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("param")
public class ParamController {
    @GetMapping

    public ResponseEntity<?> test(
            // Nếu không có thì gán null
            @RequestParam(value = "name", required = false) String name ,
            //
            @RequestParam(name = "age", defaultValue = "0") Integer age
    ){

        String result = String.format("Name: %s - Age: %s", name, age);
        return ResponseEntity.ok(result);
    }

}
