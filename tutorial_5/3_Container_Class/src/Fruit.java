import java.util.Objects;

public class Fruit {

    private String name;
    private double price;

    /**
     * Creates a fruit.
     *
     * @param name The name of the fruit
     * @param price The price of the fruit
     */
    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the fruit.
     *
     * @return This fruit's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the fruit.
     *
     * @return This fruit's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Checks if this fruit is equal to a given other object.
     *
     * @param other The object to compare to
     * @return True iff the other object is an identical fruit
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Fruit that = (Fruit) other;
        return this.price == that.price && Objects.equals(this.name, that.name);
    }

    /**
     * Generates a hashcode for the fruit.
     *
     * @return The hash of the name and price
     */
    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    /**
     * Converts this fruit to a string representation of the form "Fruit(Name: name, Price: price)".
     *
     * @return The string representation of this fruit
     */
    @Override
    public String toString() {
        return "Fruit(Name: " + name + ", Price: " + price + ")";
    }
}
