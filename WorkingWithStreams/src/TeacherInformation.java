import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class TeacherInformation {

    public static void main(String[] args) {
        Teacher t1 = new Teacher("Thomas", List.of("OOP","Software Project"), 1.97);
        Teacher t2 = new Teacher("Otto", List.of("CO","Software Project"), 1.88);
        Teacher t3 = new Teacher("Stefan", List.of("R&L","Algorithm Design"), 1.72);
        List<Teacher> teachers = List.of(t1, t2, t3);


        List<String> courses = getListOfAllCoursesTaught(teachers);
        System.out.println(courses);

        List<String> coursesAlt = getListOfAllCoursesTaughtFlatMap(teachers);
        System.out.println(coursesAlt);

        OptionalDouble avgHeight = getAverageHeight(teachers);
        System.out.println(avgHeight.getAsDouble());

    }

    /**
     * Method that maps a list of teachers to a list of courses (String) taught by
     * all these teachers without any duplicate entries.
     *
     * @param teachers a list of teachers with the courses they teach
     * @return a combined list of courses taught by all courses in the input without duplicates.
     */
    private static List<String> getListOfAllCoursesTaught(List<Teacher> teachers) {
        // We want all the courses taught everybody (without duplicates).
        // teachers --> List<Teacher>
        // .stream --> Stream<Teacher>
        // .map --> Stream<List<String>>
        List<List<String>> intermediate = teachers
                .stream()
                .map(teacher -> teacher.getCourses())
                .toList();

        // We now have a List<List<String>>. We need to collapse it!
        List<String> combinedResult = new ArrayList<>();

        // For every list in our list of lists, add all elements to our combinedResult.
        intermediate.forEach(innerList -> combinedResult.addAll(innerList));
        return combinedResult.stream().distinct().toList();
    }

    /**
     * Method that maps a list of teachers to a list of courses (String) taught by
     * all these teachers without any duplicate entries.
     * This method uses a flatMap instead of the approach with the forEach.
     *
     * @param teachers a list of teachers with the courses they teach
     * @return a combined list of courses taught by all courses in the input without duplicates.
     */
    private static List<String> getListOfAllCoursesTaughtFlatMap(List<Teacher> teachers) {
        // We want all the courses taught everybody (without duplicates).
        // teachers --> List<Teacher>
        // .stream --> Stream<Teacher>
        // .map --> Stream<List<String>>
        // .flatMap --> Stream<String>
        // .distinct --> Stream<String> remove any duplicate values
        // .toList --> List<Stream>
        return teachers
                .stream()
                .map(teacher -> teacher.getCourses())
                .flatMap(innerList -> innerList.stream())
                .distinct()
                .toList();
    }

    /**
     * Calculate the average height of the teachers.
     *
     * @param teachers a list of Teachers with heights
     * @return the average height in the provided double
     */
    private static OptionalDouble getAverageHeight(List<Teacher> teachers) {
        // teachers --> List<Teacher>
        // .stream --> Stream<Teacher>
        // .map --> Stream<Double>         teacher --> Teacher
        // .mapToDouble --> DoubleStream
        return teachers
                .stream()
                .map(teacher -> teacher.getHeight())
                .mapToDouble(x -> x)
                .average();
    }
}
