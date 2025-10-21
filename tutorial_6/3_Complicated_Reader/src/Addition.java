import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Addition {

    private String name;
    private double price;
    private List<String> allergies;

    /**
     * Creates an addition.
     *
     * @param name The name of the addition
     * @param price The price of the addition
     * @param allergies The list of allergies for the addition
     */
    public Addition(String name, double price, List<String> allergies) {
        this.name = name;
        this.price = price;
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "\n\t\tName:'" + name + '\'' +
                ", price:" + price +
                ", allergies:" + allergies;
    }

    public static Addition read(String additionString) {
        Scanner additionScanner = new Scanner(additionString);
        additionScanner.useDelimiter(",");
        additionScanner.next();
        String name = additionScanner.next();
        double price = additionScanner.nextDouble();
        List<String> allergies = new ArrayList<>();
        while (additionScanner.hasNext()) {
            allergies.add(additionScanner.next());
        }
        return new Addition(name, price, allergies);
    }

    /**
     * Gets the name of the addition.
     *
     * @return This addition's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the addition.
     *
     * @return This addition's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the list of allergies.
     *
     * @return The list of allergies for this addition.
     */
    public List<String> getAllergies() {
        return allergies;
    }

    /**
     * Checks whether an object is equal to the addition.
     *
     * @param other The other object
     * @return True iff the other is an identical addition
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        Addition that = (Addition) other;
        return Objects.equals(this.name, that.name) && this.price == that.price && Objects.equals(this.allergies, that.allergies);
    }

}
