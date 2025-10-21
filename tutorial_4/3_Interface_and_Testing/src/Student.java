public class Student extends Person implements HasToStudy {
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

    @Override
    public void study() {
        nStudied++;
    }

    @Override
    public boolean willPassExam() {
        return nStudied >= 5;
    }
}
