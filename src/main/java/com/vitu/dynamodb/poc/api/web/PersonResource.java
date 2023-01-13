package com.vitu.dynamodb.poc.api.web;

import com.vitu.dynamodb.poc.api.domain.Person;
import com.vitu.dynamodb.poc.api.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonRepository personRepository;

    @GetMapping
    public Iterator<Person> getAll() {
        return personRepository.findAll().iterator();
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable String id) {
        return personRepository.findById(id);
    }

    @PostMapping
    public Object create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping
    public Object update(@RequestBody Person person) {
        Person savedPerson = personRepository.findById(person.getId()).orElseThrow();
        savedPerson.setDocument(person.getDocument());
        return personRepository.save(savedPerson);
    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable String id) {
        personRepository.deleteById(id);
    }
}
