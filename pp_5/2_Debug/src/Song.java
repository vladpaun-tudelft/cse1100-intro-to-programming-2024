import java.util.Objects;

public class Song {

    private final String name;
    private final int duration; // in seconds

    /**
     * Creates a song.
     *
     * @param name The name of the song
     * @param duration The duration of the song in seconds
     */
    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    /**
     * Gets the name of this song.
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the duration of this song.
     *
     * @return The duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Equals method.
     *
     * @param o The object to compare against
     * @return True if this is equal to o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return duration == song.duration && Objects.equals(name, song.name);
    }

    /**
     * Gets the hashcode.
     *
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }
}
