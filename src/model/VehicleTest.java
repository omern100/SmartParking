package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test for Vehicle.
 */
public class VehicleTest {
    @Test
    void testGetLicensePlate() {
        // crate car and check the id number
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        assertEquals("123-ABC", vehicle.getLicensePlate(), "ther id need to be 123-ABC");
    }

    @Test
    void testClone() {
        // chack if clone is working
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        Vehicle cloned = vehicle.clone();
        assertEquals("123-ABC", cloned.getLicensePlate(), "the number of the clone vehicle" +
                                                                    " is need to be equal");
    }
}