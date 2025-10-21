import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdCollection {
    private List<Ad> adds;

    /**
     * Instantiates a new addCollection object
     * @param ads a list of Ad objects
     */
    public AdCollection(List<Ad> ads) {
        this.adds = ads;
    }

    /**
     * Instanciates a new empty Ad collection object
     */
    public AdCollection() {
        this.adds = new ArrayList<Ad>();
    }

    /**
     * Reads an ad collection from a string
     * @param ads string of ads
     * @return ad collection object
     */
    public static AdCollection readAds(String ads) {
        Scanner scanner = new Scanner(ads);
        scanner.useDelimiter("\nADD ");
        AdCollection adCollection = new AdCollection();
        while (scanner.hasNext()) {
            adCollection.add(Ad.readAd(scanner.next()));
        }

        return adCollection;
    }

    /**
     * Gets a single ad string based on id
     * @param id id of ad
     * @return an ad string
     */
    public String getAdString(int id) {
        return adds.get(id).toString();
    }

    /**
     * Returns the size of the adCollection
     * @return size of ad collection
     */
    public int size() {
        return adds.size();
    }

    /**
     * Method to add an ad to the ads
     * @param ad ad object
     */
    public void add(Ad ad) {
        adds.add(ad);
    }

    /**
     * Equals method for AddCollection
     * @param o other addCollection object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdCollection that = (AdCollection) o;
        return Objects.equals(adds, that.adds);
    }

    /**
     * Hashcode method for addcollection
     * @return a hashcode for addcollection
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(adds);
    }
}
