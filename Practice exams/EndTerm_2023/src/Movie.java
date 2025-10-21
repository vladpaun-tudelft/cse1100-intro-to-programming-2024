import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Movie extends Entertainment{
    private int revenue;

    /**
     * Instantiates a new movie object
     * @param title title of piece
     * @param genres genre of opiece
     * @param rating rating of piece. is an enum
     * @param duration duration of piece in minutes
     * @param cast list of actors playing in.
     * @param revenue box office revenue
     */
    public Movie(String title, List<String> genres, Rating rating,
                 int duration, List<Actor> cast, int revenue) {
        super(title, genres, rating, duration, cast);
        this.revenue = revenue;
    }

    /**
     * Reads a movie from a string
     * @param movieString string having a movie
     * @return a movie
     */
    public static Movie readMovie(String movieString) {
        Scanner scanner = new Scanner(movieString);
        String firstLine = scanner.nextLine();
        String[] firstLineParts = firstLine.split("; ");
        String title = firstLineParts[0].split("MOVIE ")[1];

        List<String> genres = new ArrayList<>();

        for (String string : firstLineParts[1].split(", ")) {
            genres.add(string);
        }

        StringBuilder ratingParser = new StringBuilder(firstLineParts[2]);
        int index = ratingParser.indexOf("-");
        if (index != -1) {
            ratingParser.replace(index, index + 1, "_");
        }

        Rating rating = Rating.valueOf(ratingParser.toString());

        String durationString = scanner.nextLine().split(" ")[1];
        String[]durationStringParts = durationString.split(":");
        int duration = Integer.parseInt(durationStringParts[0]) * 60
                + Integer.parseInt(durationStringParts[1]);
        int revenue = Integer.parseInt(scanner.nextLine().split(" ")[2]);

        List<Actor> cast = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cast.add(Actor.readActor(scanner.nextLine()));
        }
        return new Movie(title, genres, rating, duration, cast, revenue);
    }

    /**
     * ToStringof a movie
     * @return string repr of a movie
     */
    @Override
    public String toString() {
        return "Movie: " + super.toString() +
                "\n\tBox office revenue: " + revenue
                + " million";
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
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return revenue == movie.revenue;
    }

    /**
     * Hashcode method for this class
     * @return the hashcode of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), revenue);
    }
}
