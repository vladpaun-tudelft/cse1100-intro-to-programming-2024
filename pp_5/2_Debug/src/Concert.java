import java.util.List;
import java.util.Objects;

public class Concert {

    private final Tour tour;
    private final String location;
    private final List<Song> encores;

    /**
     * Creates a concert.
     *
     * @param tour The tour the concert belongs to
     * @param location The city the concert is performed
     * @param encores The encores played at the concert
     */
    public Concert(Tour tour, String location, List<Song> encores) {
        this.tour = tour;
        this.location = location;
        this.encores = encores;
        tour.addConcert(this);
    }

    /**
     * Checks whether a song is played as an encore at this concert.
     *
     * @param song The song to check
     * @return True if the given song is played as an encore
     */
    public boolean songPlayedAsEncore(Song song) {
        for (int i = 0; i < encores.size(); i++) {
            if (encores.get(i).equals(song)) return true;
        }
        return false;
    }

    /**
     * Gets the duration of this concert in the format h:mm.
     *
     * @return The duration of the concert
     */
    public String getDuration() {
        int totalSeconds = 0;
        for (int i = 0; i < tour.getSetList().size(); i++) {
            totalSeconds += tour.getSetList().get(i).getDuration();
        }
        for (int i = 0; i < encores.size(); i++) {
            totalSeconds += encores.get(i).getDuration();
        }
        int totalMinutes = totalSeconds / 60;
        String duration = "";
        duration += totalMinutes / 60;
        duration += ":";
        if (totalMinutes % 60 < 10) duration += "0" + (totalMinutes % 60);
        else duration += totalMinutes % 60;
        return duration;
    }

    /**
     * Gets the location of this concert.
     *
     * @return The location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Equals method.
     *
     * @param o The object to compare to
     * @return True iff this is equal to o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(tour, concert.tour) &&
                Objects.equals(location, concert.location) &&
                Objects.equals(encores, concert.encores);
    }

    /**
     * Gets the hash code.
     *
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(tour, location, encores);
    }

    /**
     * Gets the string representation of this concert. Format:
     * "Concert in {location} - Set list:
     *  - Song 1
     *  - Song 2
     *  ..."
     *
     * @return The string representation fo this concert
     */
    @Override
    public String toString() {
        String result = "Concert in " + location + " - Set list:";
        for (int i = 0; i < tour.getSetList().size(); i++) {
            result += " - " + tour.getSetList().get(i).getName() + "\n";
        }
        for (int i = 0; i < encores.size(); i++) {
            result += " - " + encores.get(i).getName() + "\n";
        }
        return result;
    }
}
