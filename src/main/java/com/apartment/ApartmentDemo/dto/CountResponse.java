package com.apartment.ApartmentDemo.dto;

public class CountResponse {
    private long totalBuildings;
    private long totalFloors;
    private long totalApartments;
    private long totalPersons;

    public CountResponse(long totalBuildings, long totalFloors, long totalApartments, long totalPersons) {
        this.totalBuildings = totalBuildings;
        this.totalFloors = totalFloors;
        this.totalApartments = totalApartments;
        this.totalPersons = totalPersons;
    }

    public long getTotalBuildings() {
        return totalBuildings;
    }

    public void setTotalBuildings(long totalBuildings) {
        this.totalBuildings = totalBuildings;
    }

    public long getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(long totalFloors) {
        this.totalFloors = totalFloors;
    }

    public long getTotalApartments() {
        return totalApartments;
    }

    public void setTotalApartments(long totalApartments) {
        this.totalApartments = totalApartments;
    }

    public long getTotalPersons() {
        return totalPersons;
    }

    public void setTotalPersons(long totalPersons) {
        this.totalPersons = totalPersons;
    }
}
