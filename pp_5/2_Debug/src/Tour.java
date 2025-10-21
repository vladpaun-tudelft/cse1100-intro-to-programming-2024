import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tour {

    private final String artist;
    private final List<Concert> concerts;
    private final List<Song> setList;

    /**
     * Creates a new tour.
     *
     * @param artist The artist performing the tour
     * @param setList The set list to be played for every concert (excluding encores)
     */
    public Tour(String artist, List<Song> setList) {
        this.artist = artist;
        this.concerts = new ArrayList<>();
        this.setList = setList;
    }

    /**
     * Gets whether this tour is coming to a given city.
     *
     * @param city The city to check
     * @return True if there is a concert of this tour in the city
     */
    public boolean comingTo(String city) {
        for (int i = 0; i < concerts.size(); i++) {
            if (concerts.get(i).getLocation().equals(city)) return true;
        }
        return false;
    }

    /**
     * Gets whether a given song has been played as an encore at any concert in this tour.
     *
     * @param encore The song to check
     * @return True if there is a concert where the given song was played as an encore
     */
    public boolean alreadyPlayedEncore(Song encore) {
        for (int i = 0; i < concerts.size(); i++) {
            if (concerts.get(i).songPlayedAsEncore(encore)) return true;
        }
        return false;
    }

    /**
     * Adds a concert to this tour.
     *
     * @param concert The concert to add
     */
    public void addConcert(Concert concert) {
        this.concerts.add(concert);
    }

    /**
     * Gets the set list of this tour.
     *
     * @return The set list
     */
    public List<Song> getSetList() {
        return setList;
    }

    /**
     * Equals method.
     *
     * @param o The object to compare to
     * @return True if this is equal to o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(artist, tour.artist) && Objects.equals(setList, tour.setList);
    }

    /**
     * Gets the hashcode.
     *
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(artist, concerts, setList);
    }

    /**
     * Gets a string representation of this tour. Format:
     * "{artist} - Coming to:
     *  - City 1
     *  - City 2
     *  - ..."
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        String result = artist + " - Coming to:\n";
        for (int i = 0; i < concerts.size(); i++) {
            result += " - " + concerts.get(i).getLocation() + "\n";
        }
        return result;
    }

}
