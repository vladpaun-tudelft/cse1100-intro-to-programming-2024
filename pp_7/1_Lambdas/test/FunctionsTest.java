import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionsTest {

    @Test
    void randomNumberSupplier() {
        var supplier = Functions.randomNumberSupplier();
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            nums.add(supplier.getAsInt());
        }
        assertEquals(Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), nums);
    }

    @Test
    void stringWriter() {
        StringWriter writer = new StringWriter();
        Functions.stringWriter(writer).accept("This is a test string");
        assertEquals("This is a test string", writer.toString());
    }

    @Test
    void stringRepeater() {
        var repeater = Functions.stringRepeater();
        assertEquals("abcabcabc", repeater.apply("abc", 3));
        assertEquals("", repeater.apply("1234", 0));
    }

    @Nested
    @DisplayName("isPassing()")
    class PassingGrade {
        @Test
        @DisplayName("If both grades are >=5.8, student passes")
        void passIfBothSufficient() {
            var checkPass = Functions.isPassing();
            assertTrue(checkPass.test(5.8, 5.8));
        }

        @Test
        @DisplayName("If both grades are >=5.0, and their average is >=5.8, student passes")
        void passIfAverageSufficientAndBothAtLeast5() {
            var checkPass = Functions.isPassing();
            assertTrue(checkPass.test(5.0, 10.0));
            assertTrue(checkPass.test(10.0, 5.0));
            assertTrue(checkPass.test(5.0, 6.6));
            assertTrue(checkPass.test(6.6, 5.0));
        }

        @Test
        @DisplayName("If one grade is <5.0, regardless of average, student fails")
        void failIfOneLowerThan5() {
            var checkPass = Functions.isPassing();
            assertFalse(checkPass.test(4.9, 10.0));
            assertFalse(checkPass.test(10.0, 4.9));
        }

        @Test
        @DisplayName("If both grades are >=5.0, but their average is <5.8, student fails")
        void failIfAverageNotSufficient() {
            var checkPass = Functions.isPassing();
            assertFalse(checkPass.test(5.7, 5.7));
        }
    }

}
