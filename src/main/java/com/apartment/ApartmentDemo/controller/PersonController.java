package com.apartment.ApartmentDemo.controller;

import com.apartment.ApartmentDemo.entity.Person;
import com.apartment.ApartmentDemo.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return repository.save(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return repository.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
