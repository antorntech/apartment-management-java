package com.apartment.ApartmentDemo.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "floors")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "building_id")
    @JsonIgnoreProperties("floors") // Prevent recursion when serializing building
    private Building building;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("floor") // Prevent recursion when serializing apartments
    private List<Apartment> apartments;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }

    public List<Apartment> getApartments() { return apartments; }
    public void setApartments(List<Apartment> apartments) { this.apartments = apartments; }
}
