package service;

import model.ParkingRecord;
import model.ParkingSpot;
import model.Vehicle;
import observer.ParkingObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * management the func in the parking lot (Facade).
 */
public class ParkingManager {
    private ParkingLot parkingLot; // the parking lot
    private FeeBuilder feeBuilder; // the pay

    /**
     * crate a management of the parking
     * @param spots the number of spots
     * @param feeBuilder sum of pay
     */
    public ParkingManager(int spots, FeeBuilder feeBuilder) {
        this.parkingLot = ParkingLot.getInstance(spots);
        this.feeBuilder = feeBuilder;
    }

    /**
     * add people to get the notification
     * @param observer who get the notification
     */
    public void addObserver(ParkingObserver observer) {
        parkingLot.addObserver(observer);
    }

    /**
     * parking the car
     * @param vehicle the car.
     * @return true - succsess false - not empety place
     */
    public boolean enterVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingLot.findFreeSpot(vehicle);
        if (spot == null) {
            System.out.println("not have a empety place!");
            return false;
        }
        parkingLot.parkVehicle(vehicle, spot);
        return true;
    }

    /**
     *  release vehicle
     * @param licensePlate license plate
     * @return the parking record or null
     */
    public ParkingRecord exitVehicle(String licensePlate) {
        return parkingLot.releaseVehicle(licensePlate, feeBuilder);
    }

    /**
     * status of the parking lot
     * @return the status
     */
    public String getStatus() {
        return parkingLot.getStatus();
    }

    /**
     * the daily revenue
     * @return sum of all pay
     */
    public double getDailyRevenue() {
        return parkingLot.getDailyRevenue();
    }

    /**
     * get avarage parking time
     * @return avarage time in min
     */
    public double getAverageParkingTime() {
        return parkingLot.getAverageParkingTime();
    }

    /**
     * sort history of the parking
     * @param sortType how to sort : "duration" or "fee".
     * @return the history
     */
    public String getHistory(String sortType) {
        List<ParkingRecord> records = new ArrayList<>();
        for (ParkingRecord record : parkingLot) {
            records.add(record);
        }
        Collections.sort(records, new ParkingRecordComparator(sortType));
        String result = "history (sort: " + sortType + "):\n";
        for (ParkingRecord record : records) {
            result += record.toString() + "\n";
        }
        return result;
    }
}