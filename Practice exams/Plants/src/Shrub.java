public class Shrub extends Plant {
    /**
     * Instantiates a new Shrub
     * @param names a record of the two names. normal name and latin name
     * @param minSize theminimum size in cm
     * @param maxSize the max size in cm
     * @param flowerDetails the details regarding flowers
     */
    public Shrub(Names names, int minSize, int maxSize, FlowerDetails flowerDetails) {
        super(names, minSize, maxSize, flowerDetails);
    }

    /**
     * ToString of a shrub
     * @return the string of a shrub
     */
    @Override
    public String toString() {
        return "Shrub" + super.toString();
    }

    /**
     * Simulates global warming
     * @return a new Plant
     */
    @Override
    public Shrub globalWarming() {
        return new Shrub(
                this.getNames(),
                (int) (getMinSize() * 11.0 / 10.0),
                (int) (getMaxSize() * 11.0 / 10.0),
                this.getFlowerDetails()
        );
    }
}
