package service;

import model.ParkingRecord;
import model.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *ParkingRecordComparator.
 */
public class ParkingRecordComparatorTest {
    @Test
    void testCompareByFee() {
        // check sort by fee
        Vehicle vehicle1 = new Vehicle("123-ABC", "regular");
        Vehicle vehicle2 = new Vehicle("456-XYZ", "regular");
        ParkingRecord record1 = new ParkingRecord(vehicle1);
        ParkingRecord record2 = new ParkingRecord(vehicle2);
        record1.setFee(10.0);
        record2.setFee(20.0);
        ParkingRecordComparator comparator = new ParkingRecordComparator("fee");
        assertTrue(comparator.compare(record1, record2) < 0, "the record 10 need to " +
                                                                              "be before 20");
    }
}