import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testConstructor() {
        Student s = new Student("ANdy", 1.86, false);
        assertNotNull(s);
        assertEquals("ANdy", s.getName());
        assertEquals(1.86, s.getHeight());
        assertFalse(s.getLivesInDelft());
    }

    @Test
    public void testConstructor2() {
        Student s = new Student("ANdy", 1.86, true);
        assertTrue(s.getLivesInDelft());
    }

    @Test
    public void testWillPassExam_true() {
        Student s = new Student("Vlad", 1.85, true);
        s.study();
        s.study();
        s.study();
        s.study();
        s.study();
        assertTrue(s.willPassExam());
    }

    @Test
    public void testWillPassExam_false() {
        Student s = new Student("Vlad", 1.85, false);
        s.study();
        assertFalse(s.willPassExam());
    }


    @Test
    void testToString() {
        Student s = new Student("Vlad", 1.85, true);
        assertEquals("Student:\nVlad is 1.85 metres tall and lives in Delft", s.toString());
    }
}
