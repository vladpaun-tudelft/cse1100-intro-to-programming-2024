import java.util.List;
import java.util.Objects;

/**
 * Class for teachers
 * Nothing special here.
 */
public class Teacher {
    private String name;
    private List<String> courses;
    private double height;

    public Teacher(String name, List<String> courses, double height) {
        this.name = name;
        this.courses = courses;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (Double.compare(height, teacher.height) != 0) return false;
        if (!Objects.equals(name, teacher.name)) return false;
        return Objects.equals(courses, teacher.courses);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
