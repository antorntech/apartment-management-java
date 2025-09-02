package com.apartment.ApartmentDemo.repository;

import com.apartment.ApartmentDemo.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {}
