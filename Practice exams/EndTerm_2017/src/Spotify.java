import javax.xml.crypto.AlgorithmMethod;
import java.lang.foreign.PaddingLayout;
import java.util.Objects;

public class Spotify {
    private AlbumCollection albums;
    private AdCollection ads;

    /**
     * Constructor to create a spotify object with args
     * @param albums album collection
     * @param ads add collection
     */
    public Spotify(AlbumCollection albums, AdCollection ads) {
        this.albums = albums;
        this.ads = ads;
    }

    /**
     * Contructor to create new empty spotify object
     */
    public Spotify() {
        this.albums = new AlbumCollection();
        this.ads = new AdCollection();
    }

    /**
     * Method to read a new spotify from a string of albums and a string of ads
     * @param albums string of albumd
     * @param ads string of ads
     * @return new spotify object
     */
    public static Spotify readSpotify(String albums, String ads) {
        return new Spotify(AlbumCollection.readAlbums(albums), AdCollection.readAds(ads));
    }

    /**
     * Method to add new album
     * @param album Album object
     */
    public void addAlbum(Album album) {
        albums.add(album);
    }

    /**
     * Getter for albums
     * @return albums
     */
    public AlbumCollection getAlbums() {
        return albums;
    }

    /**
     * method to add new ad
     * @param ad ad object
     */
    public void addAd(Ad ad) {
        ads.add(ad);
    }

    /**
     * Equals method of spotify object
     * @param o pther spotify object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spotify spotify = (Spotify) o;
        return Objects.equals(albums, spotify.albums) && Objects.equals(ads, spotify.ads);
    }

    /**
     * Hashcode method of spotify object
     * @return hashcode of spotify
     */
    @Override
    public int hashCode() {
        return Objects.hash(albums, ads);
    }

    /**
     * Gets the ad collection
     * @return the ad collection
     */
    public AdCollection getAds() {
        return ads;
    }
}
