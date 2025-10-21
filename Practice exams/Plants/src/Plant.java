
import java.util.*;

public abstract class Plant {
    private final Names names;
    private int minSize;
    private int maxSize;
    private FlowerDetails flowerDetails;

    /**
     * Constructor to initiate an object of this class
     * @param names a record of the two names. normal name and latin name
     * @param minSize theminimum size in cm
     * @param maxSize the max size in cm
     * @param flowerDetails the details regarding flowers
     */
    public Plant(Names names, int minSize,
                 int maxSize, FlowerDetails flowerDetails) {
        this.names = names;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.flowerDetails = flowerDetails;
    }

    /**
     * Reads a plant from a given string
     * @param plantString
     * @return the plant object
     */
    public static Plant read(String plantString) {
        Scanner scanner = new Scanner(plantString);
        String defaultDetails = scanner.nextLine();

        Scanner defaultDetailScanner = new Scanner(defaultDetails);
        defaultDetailScanner.useDelimiter("; |: ");

        PlantType type = PlantType.valueOf(defaultDetailScanner.next());

        Names names = new Names(defaultDetailScanner.next(), defaultDetailScanner.next());

        Scanner sizesScanner = new Scanner(defaultDetailScanner.next());

        sizesScanner.useDelimiter("\\(|, |\\)");

        int minSize = sizesScanner.nextInt();
        int maxSize = sizesScanner.nextInt();


        return switch (type) {
            case PlantType.HERB -> Herb.read(names, minSize, maxSize, scanner);
            case TREE -> new Tree(names, minSize, maxSize, getFlowerDetails(scanner));
            case SHRUB -> new Shrub(names, minSize, maxSize, getFlowerDetails(scanner));
        };
    }

    /**
     * gets the flower details given a scanner
     * @param scanner the scanner o read from
     * @return the flower details
     */
    public static FlowerDetails getFlowerDetails(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            return new FlowerDetails(false,
                    Optional.empty(),
                    Optional.empty(),
                    OptionalInt.empty());
        } else {
            scanner.useDelimiter("FLOWER DETAILS: |; ");
            Optional<String> color = Optional.of(scanner.next());
            Optional<String> size = Optional.of(scanner.next());
            OptionalInt petals = OptionalInt.of(
                    Integer.parseInt(scanner.next().split(" ")[0])
            );

            return new FlowerDetails(true,
                    color,
                    size,
                    petals
            );
        }
    }

    /**
     * Gets the flower details
     * @return the flower details
     */
    public FlowerDetails getFlowerDetails() {
        return flowerDetails;
    }

    /**
     * Gets theminSize
     * @return the min size
     */
    public int getMinSize() {
        return minSize;
    }

    /**
     * Gets the max size
     * @return the max size
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * ToString method of a plant
     * @return the string of a plant
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(" named ").append(names.name())
                .append(" (latin: ").append(names.latinName())
                .append("), ");
        sb.append("typical size between ").append(minSize)
                .append("cm and ").append(maxSize).append("cm.\n");
        sb.append("\t\tThis plant ");
        sb.append(
                flowerDetails.hasFlowers()
                        ? "has " + flowerDetails.size().get() + ", " +
                                flowerDetails.color().get() + " flowers with " +
                                flowerDetails.petals().getAsInt() + " petals.\n"
                        : "does not have flowers.\n"
        );

        return sb.toString();
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
        Plant plant = (Plant) o;
        return minSize == plant.minSize &&
                maxSize == plant.maxSize &&
                Objects.equals(names, plant.names)
                && Objects.equals(flowerDetails, plant.flowerDetails);
    }

    /**
     * Gets the names
     * @return the names
     */
    public Names getNames() {
        return names;
    }

    /**
     * Hashcode method for objects of this class
     * @return the int hashcode of such an instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(names, minSize, maxSize, flowerDetails);
    }

    /**
     * Simulates global warming by increasing the size of the plants
     * @return a ne plant object
     */
    public abstract Plant globalWarming();
}
