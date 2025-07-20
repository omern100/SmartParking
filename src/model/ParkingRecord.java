package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * class save deatles of car spot
 */
public class ParkingRecord {
    private Vehicle vehicle; // the car
    private LocalDateTime entryTime; // enter time
    private LocalDateTime exitTime; // exit time
    private double fee; // pay

    /**
     * crate a new record of parking
     * @param vehicle the car.
     */
    public ParkingRecord(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.entryTime = vehicle.getEntryTime();
        this.exitTime = null;
        this.fee = 0.0;
    }

    /**
     * set exit time
     * @param exitTime the exit time
     */
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    /**
     * set the pay
     * @param fee sum of pay
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    // func for get detales
    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getFee() {
        return fee;
    }

    /**
     * how much time the car is parking
     * @return time of parking in minutes
     */
    public long getDuration() {
        if (exitTime == null) {
            return ChronoUnit.MINUTES.between(entryTime, LocalDateTime.now());
        }
        return ChronoUnit.MINUTES.between(entryTime, exitTime);
    }

    @Override
    public String toString() {
        return "record: " + vehicle + ", pay: " + fee + ", time: " + getDuration() + " min";
    }
}