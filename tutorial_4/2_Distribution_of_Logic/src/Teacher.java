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

}
