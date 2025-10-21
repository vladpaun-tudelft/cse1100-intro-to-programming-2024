import java.util.Objects;
import java.util.Scanner;

public class Song {
    private int id;
    private String name;
    private int length;

    /**
     * Initiates an instance of a song
     * @param id track number within a CD
     * @param name Sont title
     * @param length Song length in seconds
     */
    public Song(int id, String name, int length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    /**
     * MEthod to read a nes song in
     * @param songString string repr of sa song
     * @return song object
     */
    public static Song readSong(String songString) {
        Scanner scanner = new Scanner(songString);
        scanner.useDelimiter(", ");
        int id = Integer.parseInt(scanner.next());
        String name = scanner.next();
        String[] times = scanner.next().split(":");
        int length = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

        return new Song(id, name, length);
    }

    public static Song readUserSong(Scanner userInput, int id) {
        System.out.println("Enter song name:");
        String name = userInput.nextLine();
        name = userInput.nextLine();
        System.out.println("Enter song length in seconds:");
        int length = userInput.nextInt();
        return new Song(id, name, length);

    }

    /**
     * String method for song
     * @return string representation of a song
     */
    @Override
    public String toString() {
        return "\tTrack " + name + " (" + length / 60 + ":" + length % 60 + ")";
    }

    /**
     * Equals method for a Song
     * @param o another song object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id && length == song.length && Objects.equals(name, song.name);
    }

    /**
     * Hash code method for a Song
     * @return hashcode of Song
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, length);
    }
}
