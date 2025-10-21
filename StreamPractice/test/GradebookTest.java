import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradebookTest {

    StudentGrade sg1, sg2, sg3, sg4, sg5;
    Collection<StudentGrade> grades;
    Gradebook gb, gbEmpty;

    @BeforeEach
    void setUp() {
        sg5 = new StudentGrade("John Smith sfdsf", 10);
        sg1 = new StudentGrade("John Smith", 9);
        sg2 = new StudentGrade("John Smith", 8);
        sg3 = new StudentGrade("John Smith", 7);
        sg4 = new StudentGrade("John Smith", 6);

        grades = List.of(sg1, sg2, sg3, sg4, sg5);

        gb = new Gradebook(grades);

        gbEmpty = new Gradebook(new ArrayList<>());
    }

    @Test
    void highestGradeExists() {
        assertEquals(10, gb.highestGrade());
    }

    @Test
    void emptyGradeBooks() {
        assertEquals(0.0, gbEmpty.highestGrade());
        assertEquals(0, gbEmpty.averageGrade());
    }

    @Test
    void averageGrade() {
        assertEquals(8, gb.averageGrade());
    }

    @Test
    void anyoneWithQ() {
        assertFalse(gb.anyoneWithQ());
    }

    @Test
    void studentsWhoPassed() {
    }

    @Test
    void longestName() {
        assertEquals("John Smith sfdsf", gb.longestName());
    }

    @Test
    void top5Students() {
    }
}