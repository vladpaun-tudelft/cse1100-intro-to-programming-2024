public class Person {

    private String name;
    private double height;

    /**
     * Creates a person.
     */
    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    /**
     * Gets the name of the person.
     *
     * @return This person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the height of the person.
     *
     * @return This person's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the person.
     *
     * @param height The new height for this person
     */
    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {return this.name + "is " + this.height + "metres tall"; }

}
