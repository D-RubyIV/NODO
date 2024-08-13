package org.example.bean.service;

import org.example.bean.model.Person;
import org.example.bean.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){
        if (!Objects.equals(person.getName(), "D")){
            return personRepository.save(person);
        }
        else {
            return null;
        }
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }
}
