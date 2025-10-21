import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarsTest {

    @Test
    void e() {
        double result = Stars.e(40);
        assertEquals(Math.E, result, 1e-15);
    }
}