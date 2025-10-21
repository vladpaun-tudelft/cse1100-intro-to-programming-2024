import java.util.*;

public class Podcast extends Entertainment{
    private int episodes;

    /**
     * Instantiates a new podcast object
     * @param title title of piece
     * @param genres genre of opiece
     * @param rating rating of piece. is an enum
     * @param duration duration of piece in minutes
     * @param cast list of actors playing in.
     * @param episodes the number of episodes
     */
    public Podcast(String title, List<String> genres,
                   Rating rating, int duration, List<Actor> cast, int episodes) {
        super(title, genres, rating, duration, cast);
        this.episodes = episodes;
    }

    /**
     * Instantiates a new podcast object
     * @param title title of piece
     * @param genres genre of opiece
     * @param rating rating of piece. is an enum
     * @param duration duration of piece in minutes
     * @param cast list of actors playing in.
     */
    public Podcast(String title, List<String> genres,
                   Rating rating, int duration, List<Actor> cast) {
        super(title, genres, rating, duration, cast);
        this.episodes = 1;
    }

    /**
     * gets the number of episodes
     * @return the number of episodes
     */
    public int getEpisodes() {
        return episodes;
    }

    /**
     * reads a new podcast from a string
     * @param podcastString string containing podcast
     * @return new podcast object
     */
    public static Podcast readPodcast(String podcastString) {
        Scanner scanner = new Scanner(podcastString);
        String firstLine = scanner.nextLine();
        String[] firstLineParts = firstLine.split("; ");
        String title = firstLineParts[0].split("PODCAST ")[1];

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
        int episodes;
        if (stuffStringParts.length > 2) {
            episodes = Integer.parseInt(stuffStringParts[2]);

        } else episodes = 1;
        String[]durationStringParts = stuffStringParts[1].split(":|;");

        int duration = Integer.parseInt(durationStringParts[0]) * 60
                + Integer.parseInt(durationStringParts[1]);


        List<Actor> cast = new ArrayList<>();
        while (scanner.hasNextLine()) {
            cast.add(Actor.readActor(scanner.nextLine()));
        }
        return new Podcast(title, genres, rating, duration, cast, episodes);
    }

    /**
     * ToString representation of a podcast
     * @return a string representation of podcast
     */
    @Override
    public String toString() {
        return "Podcast: " + super.toString() +
            "\n\t" + episodes + " Episode(s).";
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
        Podcast podcast = (Podcast) o;
        return episodes == podcast.episodes;
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
