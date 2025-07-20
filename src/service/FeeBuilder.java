package service;

import model.ParkingRecord;

/**
 * class are sum pay with Builder.
 */
public class FeeBuilder {
    private double hourlyRate; // price to hour
    private boolean isSubscriber; // is subscriber
    private double discount; // discount (0/1)

    /**
     * crate builder pay with defult value
     */
    public FeeBuilder() {
        this.hourlyRate = 5.0; // 5 dollar for one hour
        this.isSubscriber = false;
        this.discount = 0.0;
    }

    /**
     * how mutch for one hour?
     * @param rate the price
     * @return the builder
     */
    public FeeBuilder setHourlyRate(double rate) {
        this.hourlyRate = rate;
        return this;
    }

    /**
     * the car is subscriber?
     * @param isSubscriber is subscriber?
     * @return the builder
     */
    public FeeBuilder setSubscriber(boolean isSubscriber) {
        this.isSubscriber = isSubscriber;
        return this;
    }

    /**
     *  is discount?
     * @param discount the discount (0 or 1).
     * @return the builder
     */
    public FeeBuilder setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    /**
     *  sum of price of record parking
     * @param record the record parking
     * @return sum of the price
     */
    public double calculateFee(ParkingRecord record) {
        if (isSubscriber) {
            return 0.0; // the subscriber is pay a Constant price
        }
        long minutes = record.getDuration();
        double hours = minutes / 60.0;
        return hours * hourlyRate * (1.0 - discount);
    }
}