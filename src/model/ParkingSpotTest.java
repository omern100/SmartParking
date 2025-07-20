package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * בדיקות פשוטות למחלקת ParkingSpot.
 */
public class ParkingSpotTest {
    @Test
    void testPark() {
        // בודק חניה של מכונית
        ParkingSpot spot = new ParkingSpot("מקום-1", false);
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        spot.park(vehicle);
        assertTrue(spot.isOccupied(), "המקום צריך להיות תפוס");
    }

    @Test
    void testRelease() {
        // בודק שחרור מקום
        ParkingSpot spot = new ParkingSpot("מקום-1", false);
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        spot.park(vehicle);
        spot.release();
        assertFalse(spot.isOccupied(), "המקום צריך להיות פנוי");
    }
}