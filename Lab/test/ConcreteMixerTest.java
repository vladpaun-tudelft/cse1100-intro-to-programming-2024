import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMixerTest {

    @Test
    void getRequirements() {
        ConcreteMixer c = new ConcreteMixer("concrete");
        assertEquals("concrete", c.getRequirements());
    }

    @Test
    void testToString() {
        ConcreteMixer c = new ConcreteMixer("concrete");
        assertEquals("Concrete mixer: concrete", c.toString());
    }

    @Test
    void testEquals() {
        ConcreteMixer c = new ConcreteMixer("concrete");
        ConcreteMixer c2 = new ConcreteMixer("concrete");
        ConcreteMixer c3 = new ConcreteMixer("not concrete");
        assertEquals(c,c);
        assertEquals(c, c2);
        assertNotEquals(c, c3);
        assertNotEquals(c, null);
        assertNotEquals(c, new Object());
    }
}