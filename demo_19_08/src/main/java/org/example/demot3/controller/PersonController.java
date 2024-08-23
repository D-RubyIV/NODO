package org.example.demot3.controller;

import org.example.demot3.dto.PersonDto;
import org.example.demot3.entity.mysql.Person;
//import org.example.demot3.mapper.PersonMapper;
import org.example.demot3.mapper.PersonMapper;
import org.example.demot3.repository.mysql.PersonRepository;
import org.example.demot3.service.PersonService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "persons")
@RestController()
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;


    @GetMapping("")
    public ResponseEntity<?> findAll(){
//        return ResponseEntity.ok(personRepository.findAll());
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody PersonDto dto){
        return ResponseEntity.ok(personService.createPerson(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Person p = personRepository.findById(id).orElse(null);
        return ResponseEntity.ok(p);
    }

}
