import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Album {
    private String artist;
    private String name;
    private int year;
    private List<Song> songs;

    /**
     * Initiates an album object
     *
     * @param artist string of the artist
     * @param name   name of the album
     * @param year   year of release of album
     */
    public Album(String artist, String name, int year) {
        this.artist = artist;
        this.name = name;
        this.year = year;
        this.songs = new ArrayList<>();
    }

    public Album() {
        this.songs = new ArrayList<>();
    }

    public static Album readUserAlbum(Scanner userInput) {
        System.out.println("Enter artist: ");
        String artist = userInput.nextLine();
        artist = userInput.nextLine();

        System.out.println("Enter title of album: ");
        String name = userInput.nextLine();
        System.out.print("Enter year of release: ");
        int year = userInput.nextInt();
        Album album = new Album(artist, name, year);
        System.out.println("How many songs in the album?");
        int songs = userInput.nextInt();

        for (int i = 0; i < songs; i++) {
            album.addSong(Song.readUserSong(userInput, i+1));
        }
        return album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Method to read a new album
     * @param albumString string of album
     * @return Album object
     */
    public static Album readAlbum(String albumString) {
        Album album = new Album();
        Scanner scanner = new Scanner(albumString);
        scanner.useDelimiter("\nSONG ");
        String albumInfo = scanner.next();
        String[] info = albumInfo.split(", ");
        album.setArtist(info[0]);
        album.setName(info[1]);

        album.setYear(Integer.parseInt(info[2]));

        while (scanner.hasNext()) {
            album.addSong(Song.readSong(scanner.next()));
        }

        return album;
    }

    /**
     * Adds a song to the list of songs
     * @param s a song instance
     */
    public void addSong(Song s) {
        songs.add(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Album: ").append(artist).append("'s ").append(name).append("\n");
        for (Song song : songs) {
            sb.append(song).append("\n");
        }
        return sb.toString();
    }

    /**
     * MEthod to return a string for one song within an album
     * @param id id of song
     * @return string method of such song eith its album
     */
    public String getSongString(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("Album: ").append(artist).append("'s ").append(name).append("\n");
        sb.append(songs.get(id));
        return sb.toString();
    }

    /**
     * Equals method for an album instance
     * @param o other album instance
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return year == album.year && Objects.equals(artist, album.artist) && Objects.equals(name, album.name) && Objects.equals(songs, album.songs);
    }

    /**
     * Hashcode method of an Album
     * @return hashcode of album
     */
    @Override
    public int hashCode() {
        return Objects.hash(artist, name, year, songs);
    }

    /**
     * Returns size of album
     * @return size of album
     */
    public int size() {
        return this.songs.size();
    }
}
