/**
 * The type Torch.
 */
public class Torch extends Equipment implements PowerSupply {
    /**
     * Instantiates a new Torch.
     *
     * @param requirements the requirements
     */
    public Torch(String requirements){
        super(requirements);
    }

    /**
     * Returns a string of the Torch
     * @return string of torch
     */
    @Override
    public String toString() {
        return "Torch - requires Butane Gas: " + super.toString();
    }

    /**
     * Equals method for torches
     * @param other other equipment object
     * @return true if equal
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Torch that = (Torch) other;
        return super.getRequirements().equals(that.getRequirements());
    }


    /**
     * Get power supply of equipment
     * @return power supply
     */
    @Override
    public String getPowerSupply() {
        return "Butane Gas";
    }

    /**
     * Method to be able to compare equipment and sort it
     * @param o the object to be compared.
     * @return order of equipment
     */
    @Override
    public int compareTo(Equipment o) {
        if (o instanceof Torch) {
            return this.getRequirements().compareTo(o.getRequirements());
        } else if (o instanceof JackHammer) {
            return 1;
        } else if (o instanceof ScaffoldingTower) {
            return 1;
        } else if(o instanceof ConcreteMixer) {
            return 1;
        }
        return 0;
    }
}
