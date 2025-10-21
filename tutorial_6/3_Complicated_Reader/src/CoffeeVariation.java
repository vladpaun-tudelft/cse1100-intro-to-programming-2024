import java.util.Objects;
import java.util.Scanner;

public class CoffeeVariation {

    private String name;
    private double extraCost;

    /**
     * Creates a coffee variation.
     *
     * @param name The name of the variation
     * @param extraCost The extra cost of the variation
     */
    public CoffeeVariation(String name, double extraCost) {
        this.name = name;
        this.extraCost = extraCost;
    }

    public static CoffeeVariation read(String coffeeVariation) {
        Scanner variation = new Scanner(coffeeVariation);
        variation.useDelimiter(",");
        variation.next();
        return new CoffeeVariation(variation.next(), variation.nextDouble());
    }

    @Override
    public String toString() {
        return "\n\t\t\t\tName: '" + name + '\'' +
                ", extraCost: " + extraCost;
    }

    /**
     * Gets the name of the variation.
     *
     * @return This variation's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the extra cost of the varation.
     *
     * @return This variation's extra cost.
     */
    public double getExtraCost() {
        return extraCost;
    }

    /**
     * Checks whether an object is equal to the coffee variation.
     *
     * @param other The other object
     * @return True iff the other is an identical coffee variation
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        CoffeeVariation that = (CoffeeVariation) other;
        return Objects.equals(this.name, that.name) && this.extraCost == that.extraCost;
    }

}
