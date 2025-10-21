import java.util.Objects;

public class Student extends Person{
    private boolean livesInDelft;
    private int nStudied;

    /**
     * Creates a student.
     *
     * @param name The name of the student
     * @param height The height of the student
     * @param livesInDelft Whether the student lives in Delft
     */
    public Student(String name, double height, boolean livesInDelft) {
        super(name, height);
        this.livesInDelft = livesInDelft;
        this.nStudied = 0;
    }

    /**
     * Gets whether the student lives in Delft.
     *
     * @return True iff this student lives in Delft
     */
    public boolean getLivesInDelft() {
        return livesInDelft;
    }

    /**
     * Sets whether the student lives in Delft.
     *
     * @param livesInDelft The new living status of this student
     */
    public void setLivesInDelft(boolean livesInDelft) {
        this.livesInDelft = livesInDelft;
    }

    public String toString() {
        String s;
        if (livesInDelft) {
            s = "lives in Delft";
        }
        else {
            s = "does not live in Delft";
        }
        return "Student:\n" + super.toString() + " and " + s;
    }

    public void study() {
        nStudied++;
    }

    public boolean willPassExam() {
        return nStudied >= 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return livesInDelft == student.livesInDelft && nStudied == student.nStudied;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livesInDelft, nStudied);
    }
}
