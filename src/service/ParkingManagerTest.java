package service;

import model.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  ParkingManager.
 */
public class ParkingManagerTest {
    @Test
    void testEnterVehicle() {
        // check parking of vehicle
        FeeBuilder feeBuilder = new FeeBuilder();
        ParkingManager manager = new ParkingManager(2, feeBuilder);
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        assertTrue(manager.enterVehicle(vehicle), "the vehicle need to succsess");
    }

    @Test
    void testGetStatus() {
        // check status
        FeeBuilder feeBuilder = new FeeBuilder();
        ParkingManager manager = new ParkingManager(2, feeBuilder);
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        manager.enterVehicle(vehicle);
        assertEquals("status of the parking lot: " + 2 + " of " + 2 + " is occupied", manager.getStatus(), "need to be 0 occupied");
    }
}