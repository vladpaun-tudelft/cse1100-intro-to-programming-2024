import java.util.HashSet;
import java.util.Set;

public class FruitBasket {

    private int discountPercentage;
    private Set<Fruit> contents;

    /**
     * Creates a fruit basket.
     *
     * @param discountPercentage The percentage of discount someone gets for buying the entire fruit basket
     */
    public FruitBasket(int discountPercentage) {
        this.discountPercentage = discountPercentage;
        contents = new HashSet<>();
    }

    /**
     * Adds a fruit to the basket.
     *
     * @param fruit The fruit to be added
     */
    public void addFruit(Fruit fruit) {
        contents.add(fruit);
    }

    /**
     * Calculates the price of the fruit basket.
     *
     * @return The total price of this fruit basket including discount
     */
    public double calculatePrice() {
        double total = 0.0;
        for (Fruit fruit : contents) {
            total += fruit.getPrice();
        }
        double factor = (1 - (double)discountPercentage / 100);
        return factor * total;
    }

    /**
     * Gets the discount percentage.
     *
     * @return The percentage of discount you get for buying this entire fruit basket
     */
    public int getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * Checks if this fruit basket is equal to a given other object.
     *
     * @param other The object to compare to
     * @return True iff the other object is an identical fruit basket
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof FruitBasket)) return false;
        FruitBasket that = (FruitBasket) other;
        return this.discountPercentage == that.discountPercentage &&
                this.contents.equals(that.contents);
    }

    /**
     * Converts this fruit basket to a string representation of the form "FruitBasket(Discount: discount, Contents: [fruit1, fruit2...])".
     *
     * @return The string representation of this fruit basket
     */
    @Override
    public String toString() {
        return "FruitBasket(Discount: " + discountPercentage + "%, Contents: " + contents + ")";
    }

}
