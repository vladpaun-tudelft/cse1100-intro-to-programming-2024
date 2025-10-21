import java.util.Scanner;

public class Course {

    /**
     * Reads a course from a given input string.
     *
     * @param input The input to read from
     * @return The course read from the input
     */
    public static Course read(String input) {
        Scanner scanner = new Scanner(input).useDelimiter(",");
        return new Course(scanner.next(), scanner.next(), scanner.next());
    }

    private String name;
    private String abbreviation;
    private String code;

    /**
     * Creates a new course.
     *
     * @param name The name of the course
     * @param abbreviation The abbreviation of the course
     * @param code The code of the course
     */
    public Course(String name, String abbreviation, String code) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.code = code;
    }

    /**
     * Gets the name of the course.
     *
     * @return This course's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the abbreviation of the course.
     *
     * @return This course's abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Gets the code of the course.
     *
     * @return This course's code
     */
    public String getCode() {
        return code;
    }

    /**
     * Converts this course to a string representation of the form:
     *      "Course(Name: name, Abbreviation: abbreviation, Code: code)".
     *
     * @return The string representation of this course
     */
    @Override
    public String toString() {
        return "Course(Name: " + name + ", Abbreviation: " + abbreviation + ", Code: " + code + ")";
    }

    /**
     * Gets whether this course is a mathematics course.
     *
     * @return True iff this course is a mathematics course
     */
    public boolean isMathematics() {
        char courseType = code.charAt(4);
        return courseType == '2';
    }
}
