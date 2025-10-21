import java.util.Objects;
import java.util.Scanner;

public class Actor {
    private String name;
    private String role;

    /**
     * Instantiates a new actor object
     * @param name name of actor
     * @param role the role he plays
     */
    public Actor(String name, String role) {
        this.name = name;
        this.role = role;
    }

    /**
     * Reads an actor from a string
     * @param s string to be read from
     * @return actor object
     */
    public static Actor readActor(String s) {

        Scanner scanner = new Scanner(s);
        scanner.useDelimiter("CAST ");
        String test = scanner.next();
        Scanner scanner2 = new Scanner(test);
        scanner2.useDelimiter("; ");
        String test2 = scanner2.next();
        String test3 = scanner2.next();
        return new Actor(test2, test3);
    }

    /**
     * Equals method for this class
     * @param o other object to be compared with
     * @return true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) && Objects.equals(role, actor.role);
    }

    /**
     * ToString method of an actor
     * @return string repr of actor
     */
    @Override
    public String toString() {
        return name + " (" + role + ")";
    }

    /**
     * Hashcode method for this class
     * @return the hashcode of this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }
}
