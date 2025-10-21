package transport;

import transport.lines.PublicTransportLine;

import java.util.ArrayList;
import java.util.List;

public class Trip {

    private final Location from;
    private final Location to;
    private final List locations;
    private final List linesToTake;

    /**
     * Creates a new trip.
     *
     * @param from The starting location
     * @param to The ending location
     */
    public Trip(Location from, Location to) {
        this.from = from;
        this.to = to;
        this.locations = new ArrayList();
        this.linesToTake = new ArrayList();
    }

    /**
     * Gets the line to take to get to a location.
     *
     * @param to The location to check
     * @return The line to take or null if no line is set
     */
    public PublicTransportLine getLineToTake(Location to) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).equals(to))
                return (PublicTransportLine) linesToTake.get(i);
        }
        return null;
    }

    /**
     * Sets the line to take to get to a location.
     *
     * @param to The location to check
     * @param line The line to take
     */
    public void setLineToTake(Location to, PublicTransportLine line) {
        locations.add(0, to);
        linesToTake.add(0, line);
    }

    /**
     * Gets a string representation for this trip.
     *
     * @return The string representation for this trip
     */
    @Override
    public String toString() {
        if (!locations.contains(to)) return "No route";

        String result = "";
        Location current = to;
        while (current != from) {
            PublicTransportLine line = getLineToTake(current);
            result = " --(" + line + ")-> " + line.getTo() + result;
            current = line.getFrom();
        }
        result = from + result;
        return result;
    }

}
