package transport.lines;
import transport.Location;

public class Route {
    private Location from;
    private Location to;
    private double distance;

    /**
     * Class containing a to Location, a from Location and a distance
     * @param from
     * @param to
     * @param distance
     */
    public Route(Location from, Location to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    /**
     * Gets the 'from' Location
     * @return 'from' Location
     */
    public Location getFrom() {
        return from;
    }

    /**
     * Gets the 'to' Location
     * @return 'to' Location
     */
    public Location getTo() {
        return to;
    }

    /**
     * gets the distance
     * @return distance
     */
    public double getDistance() {
        return distance;
    }
}
