import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Series extends Entertainment{
    private int episodes;

    /**
     * Instantiates a new series object
     * @param title title of piece
     * @param genres genre of opiece
     * @param rating rating of piece. is an enum
     * @param duration duration of one episode in minutes
     * @param cast list of actors playing in.
     * @param episodes number of episodes
     */
    public Series(String title, List<String> genres, Rating rating,
                  int duration, List<Actor> cast, int episodes) {
        super(title, genres, rating, duration, cast);
        this.episodes = episodes;
    }

    /**
     * reads new series object from a string
     * @param seriesString stringcontaingng a series
     * @return new series object
     */
    public static Series readSeries(String seriesString) {
        Scanner scanner = new Scanner(seriesString);
        String firstLine = scanner.nextLine();
        String[] firstLineParts = firstLine.split("; ");
        String title = firstLineParts[0].split("SERIES ")[1];

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

        String[] stuffStringParts = scanner.nextLine().split(" ");
        int episodes = Integer.parseInt(stuffStringParts[2]);
        String[] durationStringParts = stuffStringParts[1].split(":|;");

        int duration = Integer.parseInt(durationStringParts[0]) * 60
                + Integer.parseInt(durationStringParts[1]);

        List<Actor> cast = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cast.add(Actor.readActor(scanner.nextLine()));
        }
        return new Series(title, genres, rating, duration, cast, episodes);
    }

    /**
     * gets the episodes
     * @return the episode number
     */
    public int getEpisodes() {
        return episodes;
    }

    /**
     * Tostring method of a series
     * @return a string repr of a series
     */
    @Override
    public String toString() {
        return "Series: " + super.toString() +
                "\n\t" + episodes
                + " Episdoes.";
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
        Series series = (Series) o;
        return episodes == series.episodes;
    }

    /**
     * Hashcode method for this class
     * @return the hashcode of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), episodes);
    }
}
