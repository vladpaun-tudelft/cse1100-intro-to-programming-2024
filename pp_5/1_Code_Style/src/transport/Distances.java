package transport;

import java.util.ArrayList;
import java.util.List;

public class Distances {

    private final List<Location> locations;
    private final List<Double> distances;

    /**
     * Creates a new empty table of distances.
     */
    public Distances() {
        this.locations = new ArrayList<>();
        this.distances = new ArrayList<>();
    }

    /**
     * Gets the distance to a given location.
     *
     * @param to The location to get the distance for
     * @return The distance to the location or a very high number
     */
    public double getDistanceTo(Location to) {
        for (int i = 0; i < locations.size(); i++)
            if (locations.get(i).equals(to))
                return distances.get(i);
        return Double.MAX_VALUE / 4; // A very high number
    }

    /**
     * Sets the distance to a location
     *
     * @param to The location to set the distance for
     * @param distance The new distance
     */
    public void setDistance(Location to, double distance) {
        locations.add(0, to);
        distances.add(0, distance);
    }

}
