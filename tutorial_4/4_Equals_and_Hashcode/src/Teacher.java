import java.util.Objects;

public class Teacher extends Person{
    private int amountOfCourses;

    /**
     * Creates a new teacher.
     *
     * @param name The name of the teacher
     * @param height The height of the teacher
     * @param amountOfCourses The amount of courses the teacher teaches
     */
    public Teacher(String name, double height, int amountOfCourses) {
        super(name, height);
        this.amountOfCourses = amountOfCourses;
    }

    /**
     * Gets the amount of courses the teacher teaches.
     *
     * @return The amount of courses this teacher teaches
     */
    public int getAmountOfCourses() {
        return amountOfCourses;
    }

    /**
     * Sets the amount of courses the teacher teaches.
     *
     * @param amountOfCourses The new amount of courses this teacher teaches
     */
    public void setAmountOfCourses(int amountOfCourses) {
        this.amountOfCourses = amountOfCourses;
    }

    public String toString() {
        return "Teacher:\n" + super.toString() + "and has " + amountOfCourses + "courses";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return amountOfCourses == teacher.amountOfCourses;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountOfCourses);
    }
}
