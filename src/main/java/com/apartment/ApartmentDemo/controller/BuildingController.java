package com.apartment.ApartmentDemo.controller;

import com.apartment.ApartmentDemo.entity.Building;
import com.apartment.ApartmentDemo.repository.BuildingRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    private final BuildingRepository repository;

    public BuildingController(BuildingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Building> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Optional<Building> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Building create(@RequestBody Building building) { return repository.save(building); }

    @PutMapping("/{id}")
    public Building update(@PathVariable Long id, @RequestBody Building building) {
        building.setId(id);
        return repository.save(building);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
