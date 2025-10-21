package transport;

import transport.lines.BusLine;
import transport.lines.PublicTransportLine;
import transport.lines.Route;
import transport.lines.TrainLine;

import java.util.*;

public class TripPlanner {

    /**
     * Main method.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        // Trip from Leiden Science Park to TU Delft Aula

        List<PublicTransportLine> allLines = new ArrayList<>();

        Location leidenSciencePark = new Location("Leiden Science Park");
        Location leidenCentralStation = new Location("Leiden Central Station");
        Location theHagueCentralStation = new Location("The Hague Central Station");
        Location utrechtCentralStation = new Location("Utrecht Central Station");
        Location rotterdamCentralStation = new Location("Rotterdam Central Station");
        Location delftCentralStation = new Location("Delft Central Station");
        Location tuDelftAula = new Location("TU Delft Aula");

        allLines.add(new BusLine("Bus 69",
                delftCentralStation, tuDelftAula, 2.0));
        allLines.add(new TrainLine("NS Train",
                new Route(rotterdamCentralStation, delftCentralStation, 20.0),
                "Intercity", false, 0));
        allLines.add(new TrainLine("NS Train",
                new Route(leidenCentralStation, delftCentralStation, 30.0),
                "Intercity", false, 0));
        allLines.add(new TrainLine("NS Train",
                new Route(leidenCentralStation, theHagueCentralStation, 20.0),
                "Sprinter", false, 0));
        allLines.add(new TrainLine("NS Train",
                new Route(theHagueCentralStation, delftCentralStation, 15.0),
                "Sprinter", false, 0));
        allLines.add(new TrainLine("NS Train",
                new Route(leidenCentralStation, utrechtCentralStation, 40.0),
                "Intercity", false, 0));
        allLines.add(new TrainLine("NS Train",
                new Route(utrechtCentralStation, rotterdamCentralStation, 35.0),
                "Intercity", false, 0));
        allLines.add(new BusLine("Bus 90",
                leidenSciencePark, leidenCentralStation, 1.5));

        System.out.println("Quickest way from " + leidenSciencePark + " to " + tuDelftAula + ":");
        System.out.println(planTrip(leidenSciencePark, tuDelftAula, allLines));
    }

    /**
     * Plans a trip between two locations.
     *
     * @param from The starting location
     * @param to The ending location
     * @param allLines The list of all transport lines
     * @return The trip form the start to the end
     */
    private static Trip planTrip(Location from,Location to,List<PublicTransportLine>allLines){
        Distances distances = new Distances();
        Trip trip = new Trip(from,to);
        List<Location> nextLocations = new ArrayList<>();
        Set<Location> visited = new HashSet<>();

        nextLocations.add(from);
        distances.setDistance(from, 0.0);

        while (!nextLocations.isEmpty()){
            nextLocations.sort(new CompareDistances(distances));
            Location current = nextLocations.removeFirst();

            if(visited.contains(current))continue;
            if(current.equals(to))break;

            visited.add(current);
            updateNextLocations(current, allLines, nextLocations, visited, distances, trip);
        }
        return(trip);
    }

    private static void updateNextLocations(Location current, List<PublicTransportLine> allLines,
                                            List<Location> nextLocations, Set<Location> visited,
                                            Distances distances, Trip trip) {

        for(PublicTransportLine next : availableLines(current,allLines)){
            if(visited.contains(next.getTo()))continue;
            double newDist=distances.getDistanceTo(current)+next.getTime();
            if(newDist<distances.getDistanceTo(next.getTo())){
                distances.setDistance(next.getTo(), newDist);
                trip.setLineToTake(next.getTo(), next);
            }
            nextLocations.add(next.getTo());
        }
    }

    /**
     * Gets all the available lines to take from a given location.
     *
     * @param from The location to check
     * @param allLines The list of all transport lines
     * @return The lines available from the given location
     */
    private static List<PublicTransportLine> availableLines
    (Location from, List<PublicTransportLine> allLines) {
        List<PublicTransportLine> available = new ArrayList<>();
        for (PublicTransportLine line : allLines) {
            if (line.getFrom().equals(from)) available.add(line);
        }
        return available;
    }

}
