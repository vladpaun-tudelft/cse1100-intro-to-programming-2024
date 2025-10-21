import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AlbumCollection {
    private ArrayList<Album> albums;

    /**
     * Getter for the album list
     * @return album list
     */
    public ArrayList<Album> getAlbums() {
        return albums;
    }

    /**
     * Method to creacte new album collection
     * @param albums a list of albums
     */
    public AlbumCollection(ArrayList<Album> albums) {
        this.albums = albums;
    }

    /**
     * Method to create new empty album collection
     */
    public AlbumCollection() {
        this.albums = new ArrayList<>();
    }

    /**
     * Method to read a new AlbumCollection from string
     * @param albums string of albums
     * @return albumCollection object
     */
    public static AlbumCollection readAlbums(String albums) {
        AlbumCollection albumCollection = new AlbumCollection();
        Scanner scanner = new Scanner(albums);
        scanner.useDelimiter("\nCD ");
        while (scanner.hasNext()) {
            albumCollection.add(Album.readAlbum(scanner.next()));
        }
        return albumCollection;
    }

    /**
     * Equals method for album collection
     * @param o other album collection object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumCollection that = (AlbumCollection) o;
        return Objects.equals(albums, that.albums);
    }

    /**
     * hashcode method of albumCollection
     * @return an int hashcode for albumcollection
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(albums);
    }

    /**
     * Method to add new album
     * @param album Album object
     */
    public void add(Album album) {
        albums.add(album);
    }
}
