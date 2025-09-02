package com.apartment.ApartmentDemo.controller;

import com.apartment.ApartmentDemo.entity.Apartment;
import com.apartment.ApartmentDemo.entity.Building;
import com.apartment.ApartmentDemo.entity.Floor;
import com.apartment.ApartmentDemo.repository.ApartmentRepository;
import com.apartment.ApartmentDemo.repository.BuildingRepository;
import com.apartment.ApartmentDemo.repository.FloorRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {

    private final ApartmentRepository apartmentRepository;
    private final FloorRepository floorRepository;
    private final BuildingRepository buildingRepository;

    public ApartmentController(ApartmentRepository apartmentRepository,
                               FloorRepository floorRepository,
                               BuildingRepository buildingRepository) {
        this.apartmentRepository = apartmentRepository;
        this.floorRepository = floorRepository;
        this.buildingRepository = buildingRepository;
    }

    // সব apartment দেখানো
    @GetMapping
    public List<Apartment> getAll() {
        return apartmentRepository.findAll();
    }

    // ID অনুযায়ী apartment দেখানো
    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getById(@PathVariable Long id) {
        return apartmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // নতুন apartment create করা
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Apartment> create(@RequestBody Apartment apartment) {

        if (apartment.getFloor() == null || apartment.getBuilding() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Floor fetch করা
        Long floorId = apartment.getFloor().getId();
        Floor floor = floorRepository.findById(floorId)
                .orElseThrow(() -> new RuntimeException("Floor not found"));

        // Building fetch করা
        Long buildingId = apartment.getBuilding().getId();
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new RuntimeException("Building not found"));

        apartment.setFloor(floor);
        apartment.setBuilding(building);

        Apartment savedApartment = apartmentRepository.save(apartment);
        return ResponseEntity.ok(savedApartment);
    }

    // Apartment update করা
    @PutMapping("/{id}")
    public ResponseEntity<Apartment> update(@PathVariable Long id, @RequestBody Apartment apartment) {
        return apartmentRepository.findById(id)
                .map(existing -> {
                    existing.setNumber(apartment.getNumber());

                    // Update floor if provided
                    if (apartment.getFloor() != null) {
                        Floor floor = floorRepository.findById(apartment.getFloor().getId())
                                .orElseThrow(() -> new RuntimeException("Floor not found"));
                        existing.setFloor(floor);
                    }

                    // Update building if provided
                    if (apartment.getBuilding() != null) {
                        Building building = buildingRepository.findById(apartment.getBuilding().getId())
                                .orElseThrow(() -> new RuntimeException("Building not found"));
                        existing.setBuilding(building);
                    }

                    Apartment updated = apartmentRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Apartment delete করা
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!apartmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        apartmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
