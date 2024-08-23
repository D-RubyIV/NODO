package org.example.demot3.service;

import org.example.demot3.dto.PersonDto;
import org.example.demot3.entity.mysql.Person;
import org.example.demot3.mapper.PersonMapper;
import org.example.demot3.repository.mysql.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;


    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream().map(s -> personMapper.toDto(s)).collect(Collectors.toList());
    }

    public Person createPerson(PersonDto personDto){
        Person person = personMapper.toEntity(personDto);
       Person result = personRepository.save(person);
       return personRepository.findById(result.getId()).orElse(null);
    }

}
