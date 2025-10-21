package clothing.data;

import java.util.Objects;

public class Shirt extends ClothingItem {

    private char size; // 'S', 'M', or 'L'

    /**
     * Creates a shirt.
     *
     * @param colour The colour
     * @param price The price
     * @param size The size
     */
    public Shirt(String colour, int price, char size) {
        super(colour, price);
        this.size = size;
    }

    /**
     * Gets the size.
     *
     * @return The size
     */
    public char getSize() {
        return size;
    }

    /**
     * Sets the size.
     *
     * @param size The new size
     */
    public void setSize(char size) {
        this.size = size;
    }

    /**
     * Compares this shirt to another object.
     *
     * @param o The object to compare to
     * @return True if this equals o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shirt shirt = (Shirt) o;
        return size == shirt.size;
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
     * Gets the string representation of this shirt.
     * Format: Shirt ({colour}) - €{price} - Size {size}
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        return "Shirt " + super.toString() + " - Size " + size;
    }
}
