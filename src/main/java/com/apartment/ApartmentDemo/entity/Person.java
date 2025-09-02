package com.apartment.ApartmentDemo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

    // Person -> Apartment
    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    @JsonIgnoreProperties({"persons", "floor", "building"})
    private Apartment apartment;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Apartment getApartment() { return apartment; }
    public void setApartment(Apartment apartment) { this.apartment = apartment; }

    // Convenience methods for frontend
    public String getFloorName() {
        return apartment != null && apartment.getFloor() != null
                ? apartment.getFloor().getName()
                : null;
    }

    public String getBuildingName() {
        return apartment != null && apartment.getBuilding() != null
                ? apartment.getBuilding().getName()
                : null;
    }

    public String getApartmentNumber() {
        return apartment != null ? apartment.getNumber() : null;
    }
}
