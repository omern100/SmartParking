package service;

import model.ParkingRecord;

/**
 * compare a parking record (Comparator).
 */
public class ParkingRecordComparator implements java.util.Comparator<ParkingRecord> {
    private String sortType; // "how much time" or "the price"

    /**
     * crate new sort
     * @param sortType how to sort: "how much time" or "the price".
     */
    public ParkingRecordComparator(String sortType) {
        this.sortType = sortType;
    }

    /**
     * compare of 2 record.
     * @param r1 first record.
     * @param r2  second record.
     * @return return number
     */
    @Override
    public int compare(ParkingRecord r1, ParkingRecord r2) {
        if (sortType.equals("fee")) {
            return Double.compare(r1.getFee(), r2.getFee());
        } else {
            return Long.compare(r1.getDuration(), r2.getDuration());
        }
    }
}