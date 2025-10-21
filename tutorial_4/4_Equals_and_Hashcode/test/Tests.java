import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Tests {

    @Test
    public void PersonEqualsTests(){
        Person p = new Person("Vlad", 1.85);
        Person p2 = new Person("Vlad", 1.85);
        Person p3 = new Person("Athul", 1.99);
        assertEquals(p, p);
        assertEquals(p,p2);
        assertNotEquals(p,p3);
    }

    @Test
    public void PersonHashCodeTests(){
        Person p = new Person("Vlad", 1.85);
        Person p2 = new Person("Vlad", 1.85);
        Person p3 = new Person("Athul", 1.99);
        assertEquals(p.hashCode(), p2.hashCode());
        assertNotEquals(p.hashCode(), p3.hashCode());
    }

    @Test
    public void StudentEqualsTests(){
        Student s = new Student("Vlad", 1.85, true);
        Student s2 = new Student("Vlad", 1.85, true);
        Student s3 = new Student("Athul", 1.99, true);
        assertEquals(s, s);
        assertEquals(s, s2);
        assertNotEquals(s, s3);
    }

    @Test
    public void StudentHashCodeTests(){
        Student s = new Student("Vlad", 1.85, true);
        Student s2 = new Student("Vlad", 1.85, true);
        Student s3 = new Student("Athul", 1.99, true);
        assertEquals(s.hashCode(), s2.hashCode());
        assertNotEquals(s.hashCode(), s3.hashCode());
    }

    @Test
    public void TeacherEqualsTests(){
        Teacher t = new Teacher("Otto", 1.65, 5);
        Teacher t2 = new Teacher("Otto", 1.65, 5);
        Teacher t3 = new Teacher("Athul", 1.65, 5);
        assertEquals(t, t);
        assertEquals(t, t2);
        assertNotEquals(t, t3);
    }

    @Test
    public void TeacherHashCodeTests(){
        Teacher t = new Teacher("Otto", 1.65, 5);
        Teacher t2 = new Teacher("Otto", 1.65, 5);
        Teacher t3 = new Teacher("Athul", 1.65, 5);
        assertEquals(t.hashCode(), t2.hashCode());
        assertNotEquals(t.hashCode(), t3.hashCode());
        
    }
}
