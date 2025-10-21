import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TorchTest {

    @Test
    void getRequirements() {
        Torch t = new Torch("fire");
        assertEquals("fire", t.getRequirements());
    }

    @Test
    void testToString() {
        Torch t = new Torch("fire");
        assertEquals("Torch: fire", t.toString());
    }

    @Test
    void testEquals() {
        Torch t = new Torch("fire");
        Torch t2 = new Torch("fire");
        Torch t3 = new Torch("not fire");
        assertEquals(t, t);
        assertEquals(t, t2);
        assertNotEquals(t, t3);
        assertNotEquals(t, null);
        assertNotEquals(t, new Object());
    }
}