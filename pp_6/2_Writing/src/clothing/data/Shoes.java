package clothing.data;

import java.util.Objects;

public class Shoes extends ClothingItem {

    private int size; // EU size

    /**
     * Creates a pair of shoes.
     *
     * @param colour The colour
     * @param price The price
     * @param size The size
     */
    public Shoes(String colour, int price, int size) {
        super(colour, price);
        this.size = size;
    }

    /**
     * Gets the size.
     *
     * @return The size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size.
     *
     * @param size The new size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Compares this pair of shoes to another object.
     *
     * @param o The object to compare to
     * @return True if this equals o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shoes shoes = (Shoes) o;
        return size == shoes.size;
    }

    /**
     * Gets the hashcode.
     *
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    /**
     * Gets the string representation of this pair of shoes.
     * Format: Shoes ({colour}) - €{price} - Size {size}
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        return "Shoes " + super.toString() + " - Size " + size;
    }
}
