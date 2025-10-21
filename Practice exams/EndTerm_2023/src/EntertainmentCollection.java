import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EntertainmentCollection {

    /**
     * Takes in a file, opens it and gets an entertainment collectionm
     * @param filePath the file to be read from
     * @return an entrertainmentcollection
     */
    public static EntertainmentCollection readFile(String filePath) {
        EntertainmentCollection entertainmentCollection = new EntertainmentCollection();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("(?=MOVIE|SERIES|PODCAST)");

            while (scanner.hasNext()) {
                entertainmentCollection.add(Entertainment.readEntertainment(scanner.next()));
            }
            scanner.close();
            return entertainmentCollection;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Entertainment> videos;

    /**
     * Instantiates a new collection object
     */
    public EntertainmentCollection() {
        videos = new ArrayList<>();
    }

    /**
     * Makes a new Entertainment collection copy
     * @param videos old collection
     * @return new collection
     */
    public static EntertainmentCollection copy(EntertainmentCollection videos) {
        EntertainmentCollection entertainmentCollection = new EntertainmentCollection();
        entertainmentCollection.setVideos(List.copyOf(videos.getVideos()));
        return entertainmentCollection;
    }

    /**
     * gets the videos
     * @return videos
     */
    public List<Entertainment> getVideos() {
        return videos;
    }

    /**
     * To string of EntertainmentCollection
     * @return string repr of a collection
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("We have ").append(videos.size()).append(" thing(s) in the collection.\n");
        for (Entertainment video : videos) {
            sb.append(video).append("\n");
        }
        return sb.toString();
    }

    /**
     * Sets the videos
     * @param videos videos
     */
    public void setVideos(List<Entertainment> videos) {
        this.videos = videos;
    }

    /**
     * Adds a new entertainment piece t the collection
     * @param e an entertainment object
     */
    public void add(Entertainment e) {
        videos.add(e);
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
        EntertainmentCollection that = (EntertainmentCollection) o;
        return Objects.equals(videos, that.videos);
    }

    /**
     * Hashcode method for this class
     * @return the hashcode of this object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(videos);
    }

    /**
     * Method to filter the object on a condition
     * @param genre string of genre to filter on
     */
    public void filterOnGenre(String genre) {
        this.videos = videos.stream()
                .filter(video -> video.getGenres().contains(genre))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Filtered.");
    }

    /**
     * Method to filter the object on a condition
     * @param playtime playtime to filter on
     */
    public void filterOnMaxPlaytime(int playtime) {

        this.videos = videos.stream()
                .filter(video -> video.getDuration() <= playtime)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Filtered.");
    }

    /**
     * Method to filter the object on a condition
     * @param playtime playtime to filter on
     */
    public void filterOnMinPlaytime(int playtime) {

        this.videos = videos.stream()
                .filter(video -> video.getDuration() >= playtime ||
                        (video instanceof Series series
                                && series.getDuration() * series.getEpisodes() >= playtime) ||
                        (video instanceof Podcast podcast
                                && podcast.getDuration() * podcast.getEpisodes() >= playtime))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Filtered.");
    }

    /**
     * Method to filter the object on a condition
     * @param rating rating to filter on
     */
    public void filterOnRating(Rating rating) {

        this.videos = videos.stream()
                .filter(video -> video.getRating().compareTo(rating) <= 0)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Filtered.");
    }
}
