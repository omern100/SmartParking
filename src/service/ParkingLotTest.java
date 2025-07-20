package service;

import model.ParkingSpot;
import model.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  ParkingLot.
 */
public class ParkingLotTest {
    @Test
    void testParkVehicle() {
        // check parking of car
        ParkingLot parkingLot = ParkingLot.getInstance(2);
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        ParkingSpot spot = parkingLot.findFreeSpot(vehicle);
        parkingLot.parkVehicle(vehicle, spot);
        assertTrue(spot.isOccupied(), "the spot need to be occupied");
    }

    @Test
    void testGetStatus() {
        // check status
        ParkingLot parkingLot = ParkingLot.getInstance(2);
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        ParkingSpot spot = parkingLot.findFreeSpot(vehicle);
        parkingLot.parkVehicle(vehicle, spot);
        assertEquals("status of the parking lot: " + 1 + " of " + 2 + " is occupied", parkingLot.getStatus(), "need to be 1 occupied");
    }
}