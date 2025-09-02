//package com.example.demo.controller;
//
//import com.example.demo.model.[Entity];
//import com.example.demo.repository.[Entity]Repository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/[entities]") // এখানে plural form দেবে, যেমন buildings, floors, persons
//public class [Entity]Controller {
//
//    private final [Entity]Repository repository;
//
//    public [Entity]Controller([Entity]Repository repository) {
//        this.repository = repository;
//    }
//
//    // ✅ Get all
//    @GetMapping
//    public List<[Entity]> getAll() {
//        return repository.findAll();
//    }
//
//    // ✅ Get by ID
//    @GetMapping("/{id}")
//    public Optional<[Entity]> getById(@PathVariable Long id) {
//        return repository.findById(id);
//    }
//
//    // ✅ Create new
//    @PostMapping
//    public [Entity] create(@RequestBody [Entity] entity) {
//        return repository.save(entity);
//    }
//
//    // ✅ Update existing
//    @PutMapping("/{id}")
//    public [Entity] update(@PathVariable Long id, @RequestBody [Entity] entity) {
//        entity.setId(id);
//        return repository.save(entity);
//    }
//
//    // ✅ Delete
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
//}
