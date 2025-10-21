/**
 * The type Jack hammer.
 */
public class JackHammer extends Equipment implements PowerSupply {
    /**
     * Instantiates a new Jack hammer.
     *
     * @param requirements the requirements
     */
    public JackHammer(String requirements) {
        super(requirements);
    }


    /**
     * Returns a string of the jack hammer
     * @return string of jack hammer
     */
    @Override
    public String toString() {
        return "Jack hammer - requires Air Compressor: " + super.toString();
    }

    /**
     * Equals method for jack hammer
     * @param other other equipment object
     * @return true if equal
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        JackHammer that = (JackHammer) other;
        return super.getRequirements().equals(that.getRequirements());
    }

    /**
     * Gets the required power supply of equipment
     * @return power supply
     */
    @Override
    public String getPowerSupply() {
        return "Air Compressor";
    }

    /**
     * Method to be able to compare equipment and sort it
     * @param o the object to be compared.
     * @return order of equipment
     */
    @Override
    public int compareTo(Equipment o) {
        if (o instanceof JackHammer) {
            return this.getRequirements().compareTo(o.getRequirements());
        } else if (o instanceof ConcreteMixer) {
            return 1;
        } else if (o instanceof ScaffoldingTower) {
            return -1;
        } else if(o instanceof Torch) {
            return -1;
        }
        return 0;
    }
}
