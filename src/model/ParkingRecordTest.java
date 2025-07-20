package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  ParkingRecord.
 */
public class ParkingRecordTest {
    @Test
    void testGetVehicle() {
        // check if the vehicle is in same record
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        ParkingRecord record = new ParkingRecord(vehicle);
        assertEquals("123-ABC", record.getVehicle().getLicensePlate(), "the vehicle need to be 123-ABC");
    }

    @Test
    void testSetFee() {
        // check the fee
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        ParkingRecord record = new ParkingRecord(vehicle);
        record.setFee(10.0);
        assertEquals(10.0, record.getFee(), "the pay need to be 10.0");
    }
}