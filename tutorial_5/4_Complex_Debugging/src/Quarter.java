import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quarter {

    /**
     * Reads a quarter from the given string input.
     *
     * @param line The input to read from
     * @return The quarter read from the input
     */
    public static Quarter read(String line) {
        Scanner scanner = new Scanner(line).useDelimiter(";");
        Quarter quarter = new Quarter();
        while (scanner.hasNext()) {
            quarter.addCourse(Course.read(scanner.next()));
        }
        return quarter;
    }

    private List<Course> courses;

    /**
     * Creates a quarter.
     */
    public Quarter() {
        this.courses = new ArrayList<>();
    }

    /**
     * Adds a course to the quarter.
     *
     * @param course The course to add
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Gets the list of courses.
     *
     * @return The list of courses in this quarter
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Converts this quarter to a string representation of the form "Quarter(Course: [course1, course2])".
     *
     * @return The string representation of this quarter
     */
    @Override
    public String toString() {
        return "Quarter(Courses: " + courses + ")";
    }

}
