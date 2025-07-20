package model;

import java.time.LocalDateTime;

/**
 * class create car in the parking place. use in Prototype for copy cars
 */
public class Vehicle {
    private String licensePlate; // licensePlate
    private String type; // type: regular or handicap
    private LocalDateTime entryTime; // enter time

    /**
     * crate new car.
     * @param licensePlate  license Plate of the car .
     * @param type type of the car - regular or handicap
     */
    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.entryTime = LocalDateTime.now(); // time enter now
    }

    // func for get the deatels
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    /**
     * copy the car (Prototype).
     * @return same car with same detale
     */
    @Override
    public Vehicle clone() {
        try {
            return (Vehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Vehicle(licensePlate, type); // backup
        }
    }

    @Override
    public String toString() {
        return "car: " + licensePlate + ", type: " + type;
    }
}