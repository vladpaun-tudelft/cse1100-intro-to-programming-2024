import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class VenueCatalogue {

    private List<Venue> venues;

    /**
     * Creates a venue catalogue.
     */
    public VenueCatalogue() {
        this.venues = new ArrayList<>();
    }

    public VenueCatalogue(List<Venue> venues) {
        this.venues = venues;
    }

    /**
     * Gets the list of quality venues.
     *
     * @return The list of venues with 3 stars or more
     */
    public List<Venue> qualityVenues() {
        return this.venues.stream()
                .filter(venue -> venue.getStars() >= 3)
                .toList();
    }

    /**
     * Gets the list of vegan restaurants names.
     *
     * @return The list of names of restaurants that have vegan menu options
     */
    public List<String> veganRestaurantNames() {
        return this.venues.stream()
                .filter(venue -> venue instanceof Restaurant)
                .filter(venue -> ((Restaurant) venue).hasVeganFood())
                .map(Venue::getName)
                .toList();
    }

    /**
     * Gets the list of cheap drinking locations.
     *
     * @return The list of locations of bars where a beer costs less than 2 euros
     */
    public List<String> cheapDrinkingLocations() {
        return this.venues.stream()
                .filter(venue -> venue instanceof Bar)
                .filter(venue -> ((Bar) venue).getCostOfOneBeer() < 2)
                .map(Venue::getLocation)
                .toList();
    }

    /**
     * Gets the average rating of all venues
     *
     * @return The int value of the average rating of all venues
     */
    public OptionalDouble averageStars() {
        return venues.stream()
                .mapToDouble(Venue::getStars)
                .average();
    }

    public List<String> allUniqueMenuItems() {
        return venues.stream()
                .flatMap(venue -> venue.getMenuItems().stream())
                .distinct()
                .toList();
    }

    /**
     * Adds a venue to the catalogue.
     *
     * @param venue The venue to add
     */
    public void addVenue(Venue venue) {
        this.venues.add(venue);
    }

    /**
     * Gets the list of venues.
     *
     * @return The list of venues in this catalogue
     */
    public List<Venue> getVenues() {
        return venues;
    }

}
