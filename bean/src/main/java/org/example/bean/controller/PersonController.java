package org.example.bean.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bean.model.Person;
import org.example.bean.repository.PersonRepository;
import org.example.bean.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
@JsonIgnoreProperties(ignoreUnknown = false)
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "hello", method = RequestMethod.GET,
            consumes = { MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE})
    public String hello(){
        return "Hello world";
    }

    @GetMapping(
            value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> findOne(@PathVariable Integer id){
        Person person = personRepository.findById(id)
                .orElseThrow();
        return ResponseEntity.ok(person);
    }


    @PostMapping(
            value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            headers = "content-type=text/json",
            params = "x-country=USA"
    )
    public ResponseEntity<?> create(@RequestBody Person person){
        Person result = personService.save(person);
        System.out.println(result);
        return ResponseEntity.ok(result);
    }

}
