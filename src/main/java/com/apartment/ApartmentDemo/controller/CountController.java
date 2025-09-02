package com.apartment.ApartmentDemo.controller;

import com.apartment.ApartmentDemo.dto.CountResponse;
import com.apartment.ApartmentDemo.repository.BuildingRepository;
import com.apartment.ApartmentDemo.repository.FloorRepository;
import com.apartment.ApartmentDemo.repository.ApartmentRepository;
import com.apartment.ApartmentDemo.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/count")
public class CountController {

    private final BuildingRepository buildingRepository;
    private final FloorRepository floorRepository;
    private final ApartmentRepository apartmentRepository;
    private final PersonRepository personRepository;

    public CountController(BuildingRepository buildingRepository,
                           FloorRepository floorRepository,
                           ApartmentRepository apartmentRepository,
                           PersonRepository personRepository) {
        this.buildingRepository = buildingRepository;
        this.floorRepository = floorRepository;
        this.apartmentRepository = apartmentRepository;
        this.personRepository = personRepository;
    }

    @GetMapping
    public CountResponse getCounts() {
        long totalBuildings = buildingRepository.count();
        long totalFloors = floorRepository.count();
        long totalApartments = apartmentRepository.count();
        long totalPersons = personRepository.count();

        return new CountResponse(totalBuildings, totalFloors, totalApartments, totalPersons);
    }
}
