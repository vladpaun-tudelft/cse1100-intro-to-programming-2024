import java.util.*;
import java.util.stream.Collectors;

public class Gradebook {
    Collection<StudentGrade> studentGrades;

    public Gradebook(Collection<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public double highestGrade() {
        return studentGrades.stream()
                .mapToDouble(value -> value.getGrade())
                .max()
                .orElse(0.0);
    }

    public double averageGrade() {
        return studentGrades.stream()
                .mapToDouble(value -> value.getGrade())
                .average()
                .orElse(0.0);
    }

    public boolean anyoneWithQ() {
        return studentGrades.stream()
                .map(value -> value.getStudentName())
                .anyMatch(name -> name.contains("Q"));
    }

    public Collection<String> studentsWhoPassed() {
        return studentGrades.stream()
                .filter(value -> value.getGrade() >= 5.8)
                .map(StudentGrade::getStudentName)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public String longestName() {
        return studentGrades.stream()
                .map(StudentGrade::getStudentName)
                .sorted(Comparator.comparing(value -> value.length()))
                .toList()
                .reversed()
                .stream().findFirst()
                .orElse("");
    }

    public Collection<String> top5Students() {
        return studentGrades.stream()
                .sorted(Comparator.comparing(value -> value.getGrade()))
                .toList()
                .reversed()
                .stream().limit(5)
                .map(StudentGrade::getStudentName)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
