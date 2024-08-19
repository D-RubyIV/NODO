package org.example.bean.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.bean.model.mysql.Person;
import org.example.bean.repository.mysql.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {

    @PersistenceContext
    private EntityManager em;

    public Person findByIdWithEntityManager(Integer id) {
//        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.id = :id", Person.class);
//        query.setParameter("id", id);
//        return query.getSingleResult();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);// FROM Person p
        criteriaQuery.select(root); // SELECT *
//        criteriaQuery.select(criteriaBuilder.construct(Person.class ,root.get("name"), root.get("age"))); // SELECT name, age
        if (id != null){
            criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id)); // WHERE p.id = 1
        }
        return em.createQuery(criteriaQuery).getSingleResult();
    }


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

    public Page<Person> findAll(Pageable pageable){
        return personRepository.findAllNative(pageable);
    }

    public Person update(Person entity, Integer id) throws Exception {
        Person model = personRepository.findById(id).orElseThrow(() -> new Exception("No entity found"));
        model.setName(entity.getName());
        model.setAge(entity.getAge());
        model.setAddress(entity.getAddress());
        model.setStatus(entity.getStatus());
        return personRepository.save(model);
    }


    public void deleteById(Integer id){
        personRepository.deleteById(id);
    }




}
