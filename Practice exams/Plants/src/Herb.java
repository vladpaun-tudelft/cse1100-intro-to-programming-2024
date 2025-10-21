import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

public class Herb extends Plant{
    private boolean edible;
    private String taste;

    /**
     * Instantiates a new herb
     * @param names the names of the herb normal and latin
     * @param minSize the minimum size of the herb
     * @param maxSize the max size of the herb
     * @param flowerDetails the flowerdetails
     * @param edible is it edible?
     * @param taste taste notes
     */
    public Herb(Names names, int minSize,
                int maxSize, FlowerDetails flowerDetails,
                boolean edible, String taste) {
        super(names, minSize, maxSize, flowerDetails);
        this.edible = edible;
        this.taste = taste;
    }

    /**
     * ToString of a herb
     * @return the string of a herb
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Herb" + super.toString());
        sb.append("\t\tThis herb is ");
        sb.append(!edible? "not ":"");
        sb.append("safe to eat. ").append(taste).append("\n");

        return sb.toString();
    }

    /**
     * Returns the edibility of the herb
     * @return the edibility property of the herb
     */
    public boolean isEdible() {
        return edible;
    }

    /**
     * Reads a new gherb given the default stuff
     * @param names names
     * @param minSize minsize
     * @param maxSize maxsize
     * @param scanner scanner containing the rest fo the info
     * @return the herb
     */
    public static Herb read(Names names, int minSize, int maxSize, Scanner scanner) {
        String line = scanner.nextLine();
        Scanner lineScanner = new Scanner(line);


        FlowerDetails flowerDetails;
        String taste;
        boolean edible;

        lineScanner.useDelimiter(": ");
        String test = lineScanner.next();

        if (test.equals("FLOWER DETAILS")) {
            flowerDetails = Plant.getFlowerDetails(new Scanner(line));
            String[] parts = scanner.nextLine().split("EDIBILITY: |; ");

            taste = parts[2];
            edible = parts[1].equals("Yes");
        } else {
            flowerDetails = new FlowerDetails(false,
                    Optional.empty(),
                    Optional.empty(),
                    OptionalInt.empty());;
            String[] parts = line.split("EDIBILITY: |; ");

            taste = parts[2];
            edible = parts[1].equals("Yes");
        }

        return new Herb(names, minSize, maxSize, flowerDetails, edible, taste);
    }

    /**
     * Equals method for objects of this class
     * @param o the object to be compared with
     * @return true if objrcts are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Herb herb = (Herb) o;
        return edible == herb.edible && Objects.equals(taste, herb.taste);
    }

    /**
     * Hashcode method for objects of this class
     * @return the int hashcode of such an instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), edible, taste);
    }

    /**
     * Simulates global warming
     * @return a new Plant
     */
    @Override
    public Herb globalWarming() {
        return new Herb(
                this.getNames(),
                (int) (getMinSize() * 11.0 / 10.0),
                (int) (getMaxSize() * 11.0 / 10.0),
                this.getFlowerDetails()
                ,edible,taste
        );
    }
}
