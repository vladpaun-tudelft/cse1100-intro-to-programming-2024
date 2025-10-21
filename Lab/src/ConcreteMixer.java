/**
 * The type Concrete mixer.
 */
public class ConcreteMixer extends Equipment{
    /**
     * Instantiates a new Concrete mixer.
     *
     * @param requirements the requirements
     */
    public ConcreteMixer(String requirements) {
        super(requirements);
    }

    /**
     * Returns a string of the Concrete mixer
     * @return string of the concrete mixer
     */
    @Override
    public String toString() {
        return "Concrete mixer: " + super.toString();
    }

    /**
     * Equals method for concrete mixers
     * @param other other equipment object
     * @return true if equal
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ConcreteMixer that = (ConcreteMixer) other;
        return super.getRequirements().equals(that.getRequirements());
    }

    /**
     * Method to be able to compare equipment and sort it
     * @param o the object to be compared.
     * @return order of equipment
     */
    @Override
    public int compareTo(Equipment o) {
        if (o instanceof ConcreteMixer) {
            return this.getRequirements().compareTo(o.getRequirements());
        } else if (o instanceof JackHammer) {
            return -1;
        } else if (o instanceof ScaffoldingTower) {
            return -1;
        } else if(o instanceof Torch) {
            return -1;
        }
        return 0;
    }
}
