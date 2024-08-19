package org.example.bean.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.bean.model.mysql.Person;
import org.example.bean.repository.mysql.PersonRepository;
import org.example.bean.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @GetMapping(value = "hello" , produces = "application/xml", consumes = "application/json")
    public String hello(){
        return "Hello world";
    }

    // FIND ALL BY PAGE
    @GetMapping(
            value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<?> findAll(
            @RequestParam(value = "limit", defaultValue = "5") int limit,
            @RequestParam(value = "offset", defaultValue = "0") int offset
    ){
        Pageable pageable = PageRequest.of(offset, limit);
        return ResponseEntity.ok(personService.findAll(pageable));
    }

    // @PAGE_DEFAULT
    @GetMapping(
            value = "v2",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<?> findAllV2(
            @PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    ){
        return ResponseEntity.ok(personService.findAll(pageable));
    }

    // FIND_BY_ID
    @GetMapping(
            value = "/{id}",
            produces = "application/xml"
    )
    public ResponseEntity<?> findOne(@PathVariable Integer id){
        Person person = personService.findByIdWithEntityManager(id);
        return ResponseEntity.ok(person);
    }

    // CREATE
    @PostMapping(
            value = "",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            headers = "content-type=text/json",
            params = "x-country=USA"
    )
    public ResponseEntity<?> create(@RequestBody Person person){
        Person result = personService.save(person);
        System.out.println(result);
        return ResponseEntity.ok(result);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Person entity, @PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(personService.update(entity, id));
    }
    // DELETE
    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> delete(@PathVariable Integer id){
        personService.deleteById(id);
        return ResponseEntity.ok("");
    }

}
