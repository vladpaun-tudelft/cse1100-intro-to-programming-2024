/**
 * The type Scaffolding tower.
 */
public class ScaffoldingTower extends Equipment{
    /**
     * Instantiates a new Scaffolding tower.
     *
     * @param requirements the requirements
     */
    public ScaffoldingTower(String requirements) {
        super(requirements);
    }

    /**
     * Returns a string of the Scaffolding
     * @return string of scaffolding tower
     */
    @Override
    public String toString() {
        return "Scaffolding tower: " + super.toString();
    }

    /**
     * Equals method for scaffolding
     * @param other other equipment object
     * @return true if equal
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ScaffoldingTower that = (ScaffoldingTower) other;
        return super.getRequirements().equals(that.getRequirements());
    }

    /**
     * Method to be able to compare equipment and sort it
     * @param o the object to be compared.
     * @return order of equipment
     */
    @Override
    public int compareTo(Equipment o) {
        if (o instanceof ScaffoldingTower) {
            return this.getRequirements().compareTo(o.getRequirements());
        } else if (o instanceof JackHammer) {
            return 1;
        } else if (o instanceof ConcreteMixer) {
            return 1;
        } else if(o instanceof Torch) {
            return -1;
        }
        return 0;
    }
}
