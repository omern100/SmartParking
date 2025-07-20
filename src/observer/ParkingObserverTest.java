package observer;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
  ParkingObserver.
 */
public class ParkingObserverTest {
    @Test
    void testUpdate() {
        // chack the observer is get a massage
        List<String> notifications = new ArrayList<>();
        ParkingObserver observer = new ParkingObserver() {
            @Override
            public void update(String message) {
                notifications.add(message);
            }
        };
        observer.update("the car is parking");
        assertEquals("the car is parking", notifications.get(0), "the massage need to be car is parking");
    }
}