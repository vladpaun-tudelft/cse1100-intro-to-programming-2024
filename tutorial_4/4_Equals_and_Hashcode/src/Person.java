import java.util.Objects;

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

    public String toString() {return this.name + " is " + this.height + " metres tall"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(height, person.height) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height);
    }
}
