package service;

import model.ParkingSpot;
import model.ParkingRecord;
import model.Vehicle;
import observer.ParkingObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * the class are managment the parking place (Singleton + Iterator).
 */
public class ParkingLot implements Iterable<ParkingRecord> {
    private static ParkingLot instance; // instance
    private List<ParkingSpot> spots; // list of parking spot
    private List<ParkingRecord> history; // record of the parking
    private List<ParkingObserver> observers; // who are get the notification
    private int maxSpots; // how much sot have

    /**
     *crate a new parking lot (private becouse is a Singleton).
     * @param maxSpots number of parking spot in the parking lot
     */
    private ParkingLot(int maxSpots) {
        this.maxSpots = maxSpots;
        this.spots = new ArrayList<>();
        this.history = new ArrayList<>();
        this.observers = new ArrayList<>();
        // crate a spot of parking
        for (int i = 1; i <= maxSpots; i++) {
            boolean isHandicap = (i % 10 == 0); // every 9 spots the 10 is a handicap place.
            spots.add(new ParkingSpot("spot-" + i, isHandicap));
        }
    }

    /**
     * return the parking lot (Singleton).
     * @param maxSpots number of parking spot in the parking lot.
     * @return the parking lot.
     */
    public static ParkingLot getInstance(int maxSpots) {
        if (instance == null) {
            instance = new ParkingLot(maxSpots);
        }
        return instance;
    }

    /**
     * add who get the notification (Observer).
     * @param observer who get the notification.
     */
    public void addObserver(ParkingObserver observer) {
        observers.add(observer);
    }

    /**
     * send a notification.
     * @param message the message.
     */
    private void notifyObservers(String message) {
        for (ParkingObserver observer : observers) {
            observer.update(message);
        }
    }

    /**
     * find a empety spot for the car.
     * @param vehicle the car.
     * @return spot or if not have - null
     */
    public ParkingSpot findFreeSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && (!spot.isHandicap() || vehicle.getType().equals("handicap"))) {
                return spot;
            }
        }
        return null;
    }

    /**
     * parking car instead of
     * @param vehicle the car.
     * @param spot the spot.
     */
    public void parkVehicle(Vehicle vehicle, ParkingSpot spot) {
        spot.park(vehicle);
        history.add(new ParkingRecord(vehicle));
        notifyObservers("car " + vehicle.getLicensePlate() + " instead of  " + spot.getSpotId());
    }

    /**
     * release car from the spot
     * @param licensePlate license plate
     * @param feeBuilder how mutch pay?
     * @return recourd of the parking - if there is not have - null
     */
    public ParkingRecord releaseVehicle(String licensePlate, FeeBuilder feeBuilder) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getLicensePlate().equals(licensePlate)) {
                for (ParkingRecord record : history) {
                    if (record.getVehicle().getLicensePlate().equals(licensePlate) && record.getExitTime() == null) {
                        record.setExitTime(java.time.LocalDateTime.now());
                        record.setFee(feeBuilder.calculateFee(record));
                        spot.release();
                        notifyObservers("car " + licensePlate + " exit, pay: " + record.getFee());
                        return record;
                    }
                }
            }
        }
        return null;
    }

    /**
     * status of the parking lot
     * @return how mutch oocupied in the parking lot
     */
    public String getStatus() {
        int occupied = 0;
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied()) {
                occupied++;
            }
        }
        return "status of the parking lot: " + occupied + " of " + maxSpots + " is occupied";
    }

    /**
     *  get a daily revenue
     * @return sum of total pay
     */
    public double getDailyRevenue() {
        double total = 0.0;
        for (ParkingRecord record : history) {
            if (record.getExitTime() != null) {
                total += record.getFee();
            }
        }
        return total;
    }

    /**
     * get average parking time
     * @return average in min
     */
    public double getAverageParkingTime() {
        int count = 0;
        long totalTime = 0;
        for (ParkingRecord record : history) {
            if (record.getExitTime() != null) {
                totalTime += record.getDuration();
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return totalTime / (double) count;
    }

    /**
     * can to see the history (Iterator).
     * @return iterator for the record.
     */
    @Override
    public Iterator<ParkingRecord> iterator() {
        return history.iterator();
    }
}