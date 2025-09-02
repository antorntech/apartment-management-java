package com.apartment.ApartmentDemo.controller;

import com.apartment.ApartmentDemo.entity.Floor;
import com.apartment.ApartmentDemo.repository.FloorRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/floors")
public class FloorController {
    private final FloorRepository repository;

    public FloorController(FloorRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Floor> getAll() { return repository.findAll(); }

    @PostMapping
    public Floor create(@RequestBody Floor floor) { return repository.save(floor); }

    @PutMapping("/{id}")
    public Floor update(@PathVariable Long id, @RequestBody Floor floor) {
        floor.setId(id);
        return repository.save(floor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
