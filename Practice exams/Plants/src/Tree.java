public class Tree extends Plant{
    /**
     * Instantiates a new Tree
     * @param names a record of the two names. normal name and latin name
     * @param minSize theminimum size in cm
     * @param maxSize the max size in cm
     * @param flowerDetails the details regarding flowers
     */
    public Tree(Names names, int minSize, int maxSize, FlowerDetails flowerDetails) {
        super(names, minSize, maxSize, flowerDetails);
    }

    /**
     * ToString of a tree
     * @return the string of a tree
     */
    @Override
    public String toString() {
        return "Tree" + super.toString();
    }

    /**
     * Simulates global warming
     * @return a new Plant
     */
    @Override
    public Tree globalWarming() {
        return new Tree(
                this.getNames(),
                (int) (getMinSize() * 11.0 / 10.0),
                (int) (getMaxSize() * 11.0 / 10.0),
                this.getFlowerDetails()
        );
    }
}
