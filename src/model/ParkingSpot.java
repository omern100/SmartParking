package model;

/**
 * class place of parking.
 */
public class ParkingSpot {
    private String spotId; // Id of the spot
    private boolean isOccupied; // occupied or not
    private boolean isHandicap; // is for Handicap or not
    private Vehicle vehicle; // car of parking (if have)

    /**
     * crate new parking spot
     * @param spotId  Id of the spot
     * @param isHandicap is for Handicap or not
     */
    public ParkingSpot(String spotId, boolean isHandicap) {
        this.spotId = spotId;
        this.isOccupied = false;
        this.isHandicap = isHandicap;
        this.vehicle = null;
    }

    /**
     *parking a new car
     * @param vehicle  car of parking
     */
    public void park(Vehicle vehicle) {
        if (isOccupied) {
            System.out.println("alert: spot " + spotId + " is occupied!");
            return;
        }
        if (isHandicap && !vehicle.getType().equals("handicap")) {
            System.out.println("alert: only a handicap car can parking here!");
            return;
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    /**
     *  release the spot.
     */
    public void release() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    // get a detales
    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isHandicap() {
        return isHandicap;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSpotId() {
        return spotId;
    }
}