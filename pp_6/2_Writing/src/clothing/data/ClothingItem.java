package clothing.data;

import java.io.Serializable;
import java.util.Objects;

public abstract class ClothingItem implements Serializable {

    private String colour;
    private int price; // in cents

    /**
     * Creates a new clothing item.
     *
     * @param colour The colour
     * @param price The price
     */
    public ClothingItem(String colour, int price) {
        this.colour = colour;
        this.price = price;
    }

    /**
     * Gets the colour.
     *
     * @return The colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Gets the price.
     *
     * @return The price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the colour.
     *
     * @param colour The new colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Sets the price.
     *
     * @param price The new price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Compares this to another object.
     *
     * @param o The object to compare to
     * @return True if this equals o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClothingItem that = (ClothingItem) o;
        return price == that.price && Objects.equals(colour, that.colour);
    }

    /**
     * Gets the hashcode.
     *
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(colour, price);
    }

    /**
     * Gets a string representation of this clothing item.
     * Format: ({colour}) - €{euro}.{cents}
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        String priceString = "€";
        priceString += price / 100;
        priceString += ".";
        if (price % 100 < 10) {
            priceString += "0";
        }
        priceString += price % 100;
        return "(" + colour + ") - " + priceString;
    }

}
