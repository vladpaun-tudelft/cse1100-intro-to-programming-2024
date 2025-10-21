import java.util.Objects;

public class Ad {
    private String advertiser;
    private int length;

    /**
     * Initiates an instance of an add
     * @param advertiser Advretiser name
     * @param length length of add in seconds
     */
    public Ad(String advertiser, int length) {
        this.advertiser = advertiser;
        this.length = length;
    }

    /**
     * reads an ad from a string
     * @param adString string of an ad
     * @return ad object
     */
    public static Ad readAd(String adString) {
        String[] parts = adString.split(", ");
        String[] time = parts[1].split(":");
        int length = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        return new Ad(parts[0], length);
    }

    /**
     * To string method for an add
     * @return a string representatuon of an add
     */
    @Override
    public String toString() {
        return advertiser + " (" + length / 60 + ":" + length % 60 + ")";
    }

    /**
     * Equals method for an add
     * @param o another add object
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return length == ad.length && Objects.equals(advertiser, ad.advertiser);
    }

    /**
     * Hashcode method of add
     * @return int hashcode of add
     */
    @Override
    public int hashCode() {
        return Objects.hash(advertiser, length);
    }
}
