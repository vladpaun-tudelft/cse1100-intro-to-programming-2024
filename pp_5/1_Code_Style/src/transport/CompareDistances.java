package transport;

import java.util.Comparator;

public class CompareDistances implements Comparator<Location> {

    private final Distances distances;

    /**
     * Creates a comparator that compares distances to locations using the given distance table.
     *
     * @param distances The distances
     */
    public CompareDistances(Distances distances) {
        this.distances = distances;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compare(Location l1, Location l2) {
        return Double.compare(distances.getDistanceTo(l1), distances.getDistanceTo(l2));
    }

}
