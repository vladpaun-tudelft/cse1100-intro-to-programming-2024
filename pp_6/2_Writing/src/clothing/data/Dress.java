package clothing.data;

import java.util.Objects;

public class Dress extends ClothingItem {

    private double length; // in metres

    /**
     * Creates a dress.
     *
     * @param colour The colour
     * @param price The price
     * @param length The length
     */
    public Dress(String colour, int price, double length) {
        super(colour, price);
        this.length = length;
    }

    /**
     * Gets the length.
     *
     * @return The length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length.
     *
     * @param length The new length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Compares this dress to another object.
     *
     * @param o The object to compare to
     * @return True if this equals o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dress dress = (Dress) o;
        return Double.compare(length, dress.length) == 0;
    }

    /**
     * Gets the hashcode.
     *
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

    /**
     * Gets a string representation of this dress.
     * Format: Dress ({colour}) - €{price} - {length}m
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        return "Dress " + super.toString() + " - " + length + "m";
    }

}
