package com.apartment.ApartmentDemo.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    // Apartment -> Floor
    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    @JsonIgnoreProperties({"apartments", "building"})
    private Floor floor;

    // Apartment -> Building
    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    @JsonIgnoreProperties({"floors"})
    private Building building;

    // Apartment -> Persons
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("apartment")
    private List<Person> persons;

    // Constructors
    public Apartment() {}

    public Apartment(String number, Floor floor, Building building) {
        this.number = number;
        this.floor = floor;
        this.building = building;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Floor getFloor() { return floor; }
    public void setFloor(Floor floor) { this.floor = floor; }

    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }

    public List<Person> getPersons() { return persons; }
    public void setPersons(List<Person> persons) { this.persons = persons; }
}
