import java.util.ArrayList;
import java.util.List;

public class Year {

    /**
     * Reads the year from a given list of strings as input.
     *
     * @param lines The lines to read from
     * @return The year read from the input
     */
    public static Year read(List<String> lines) {
        if (lines.size() != 4) throw new IllegalArgumentException("Year does not contain 4 quarters");
        Year year = new Year();
        for (int i = 0; i < lines.size(); i++) {
            year.setQuarter(i, Quarter.read(lines.get(i)));
        }
        return year;
    }

    private Quarter[] quarters;

    /**
     * Creates a year
     */
    public Year() {
        this.quarters = new Quarter[4];
    }

    /**
     * Sets the quarter at the given index.
     *
     * @param index The index to change
     * @param quarter The new quarter
     */
    public void setQuarter(int index, Quarter quarter) {
        this.quarters[index] = quarter;
    }

    /**
     * Gets the quarters in the year.
     *
     * @return This year's quarters
     */
    public Quarter[] getQuarters() {
        return quarters;
    }

    /**
     * Converts this year to a string representation of the form "Year(Q1: quarter1, Q2: quarter2, Q3: quarter3, Q4: quarter4)".
     *
     * @return The string representation of this year
     */
    @Override
    public String toString() {
        return "Year(Q1: " + quarters[0] + ", Q2: " + quarters[1] + ", Q3: " + quarters[2] + ", Q4: " + quarters[3] + ")";
    }

    /**
     * Gets all courses in the year.
     *
     * @return The list of all courses in this year
     */
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Course> coursesPerQuarter = quarters[i].getCourses();
            for (Course course : coursesPerQuarter) {
                courses.add(course);
            }
        }
        return courses;
    }

}
