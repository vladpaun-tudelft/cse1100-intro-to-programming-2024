import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Entertainment {
    private String title;
    private List<String> genres;
    private Rating rating;
    private int duration;
    private List<Actor> cast;

    /**
     * gtets the list of genres
     * @return a list of genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * gets the duration
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the rating
     * @return rating enum
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Instantiates a new entertainment object
     * @param title title of piece
     * @param genres genre of opiece
     * @param rating rating of piece. is an enum
     * @param duration duration of piece in minutes
     * @param cast list of actors playing in.
     */
    public Entertainment(String title, List<String> genres,
                         Rating rating, int duration, List<Actor> cast) {
        this.title = title;
        this.genres = genres;
        this.rating = rating;
        this.duration = duration;
        this.cast = cast;
    }

    /**
     * Reads the entertainment from a string
     * @param entertainmentString a string of any entertainment
     * @return an entertainment object
     */
    public static Entertainment readEntertainment(String entertainmentString) {
        Scanner scanner = new Scanner(entertainmentString);
        return switch(scanner.next()) {
            case "MOVIE" -> Movie.readMovie(entertainmentString);
            case "SERIES" -> Series.readSeries(entertainmentString);
            case "PODCAST" -> Podcast.readPodcast(entertainmentString);
            default -> null;
        };

    }

    /**
     * Equals method for this class
     * @param o other object to be compared with
     * @return true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entertainment that = (Entertainment) o;
        return duration == that.duration && Objects.equals(title, that.title)
                && Objects.equals(genres, that.genres) && rating == that.rating &&
                Objects.equals(cast, that.cast);
    }

    /**
     * Tostring method of Entertainment object
     * @return a string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(" - Genres: ");
        for (int i = 0; i < genres.size(); i++) {
            sb.append(genres.get(i));
            if (i < genres.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(". Maturity rating: ");
        sb.append(rating);
        sb.append("\n\tDuration: ");
        sb.append(duration / 60);
        sb.append(" hour and ");
        sb.append(duration % 60);
        sb.append(" minutes");
        sb.append("\n\tCast members: ");
        for (int i = 0; i < cast.size(); i++) {
            sb.append(cast.get(i));
            if (i < cast.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Hashcode method for this class
     * @return the hashcode of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, genres, rating, duration, cast);
    }
}
