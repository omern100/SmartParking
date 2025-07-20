import model.Vehicle;
import service.FeeBuilder;
import service.ParkingManager;
import observer.ParkingObserver;

public class Main {
    public static void main(String[] args) {
        FeeBuilder feeBuilder = new FeeBuilder()
                .setHourlyRate(5.0)
                .setDiscount(0.1);

        ParkingManager manager = new ParkingManager(10, feeBuilder);

        manager.addObserver(new ParkingObserver() {
            @Override
            public void update(String message) {
                System.out.println("update: " + message);
            }
        });

        Vehicle car1 = new Vehicle("123-ABC", "regular");
        Vehicle car2 = new Vehicle("789-XYZ", "handicap");
        Vehicle car3 = car1.clone();
        car3 = new Vehicle(car3.getLicensePlate() + "-COPY", car3.getType());

        manager.enterVehicle(car1);
        manager.enterVehicle(car2);
        manager.enterVehicle(car3);

        System.out.println(manager.getStatus());

        manager.exitVehicle("123-ABC");

        System.out.println("sum of the revenue day: " + manager.getDailyRevenue() + " dollar");
        System.out.println("avarage parking time: " + manager.getAverageParkingTime() + " min");
        System.out.println(manager.getHistory("fee"));
    }
}