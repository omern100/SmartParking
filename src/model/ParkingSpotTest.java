package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ParkingSpot
 */
public class ParkingSpotTest {
    @Test
    void testPark() {
        // check parking of car
        ParkingSpot spot = new ParkingSpot("spot-1", false);
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        spot.park(vehicle);
        assertTrue(spot.isOccupied(), "the spot need to be occupied");
    }

    @Test
    void testRelease() {
        // chack release
        ParkingSpot spot = new ParkingSpot("spot-1", false);
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        spot.park(vehicle);
        spot.release();
        assertFalse(spot.isOccupied(), "the spot need to be free");
    }
}