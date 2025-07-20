package service;

import model.ParkingRecord;
import model.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * FeeBuilder.
 */
public class FeeBuilderTest {
    @Test
    void testCalculateFee() {
        // check the calculate fee of hour
        Vehicle vehicle = new Vehicle("123-ABC", "regular");
        ParkingRecord record = new ParkingRecord(vehicle);
        record.setExitTime(record.getEntryTime().plusHours(1));
        FeeBuilder feeBuilder = new FeeBuilder();
        assertEquals(5.0, feeBuilder.calculateFee(record), "the price need to be 5.0");
    }
}