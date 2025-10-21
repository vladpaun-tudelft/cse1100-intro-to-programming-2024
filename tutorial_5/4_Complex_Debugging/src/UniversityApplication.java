import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityApplication {

    /**
     * Reads a list of years from curriculum.txt and prints out the years.
     * Then, prints out all the mathematics course names.
     *
     * @throws IOException If the file reading fails
     */
    public static void main(String[] args) throws IOException {
        // PART 1
        List<Year> years = readYears(new Scanner(new File("resources/curriculum.txt")));
        System.out.println("Years from file:");
        for (Year year : years) {
            System.out.println(year);
        }

        // PART 2
        for (Year year : years) {
            System.out.println(getAllMathematicsCourseNames(year));
        }
    }

    /**
     * Reads a list of years from a given scanner.
     *
     * @param scanner The scanner to read from
     * @return The list of years read from the scanner
     */
    public static List<Year> readYears(Scanner scanner) {
        List<Year> years = new ArrayList<>();
        List<String> currentYear = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("Year")) {
                if (!currentYear.isEmpty())
                    years.add(Year.read(currentYear));
                currentYear = new ArrayList<>();
            } else {
                currentYear.add(line);
            }
        }
        years.add(Year.read(currentYear));
        return years;
    }

    /**
     * Gets all course names of mathematics courses in the given year.
     *
     * @param year The year to get the courses from
     * @return The list of names of all the mathematics courses in the year
     */
    public static List<String> getAllMathematicsCourseNames(Year year) {
        List<Course> courses = year.getAllCourses();
        List<String> mathematicsNames = new ArrayList<>();
        for (Course course : courses) {
            if (course.isMathematics()) {
                mathematicsNames.add(course.getName());
            }
        }
        return mathematicsNames;
    }

}
