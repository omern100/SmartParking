package observer;

/**
 * send a massage for change in the parking (Observer).
 */
public interface ParkingObserver {
    /**
     * update with message.
     * @param message the message.
     */
    void update(String message);
}