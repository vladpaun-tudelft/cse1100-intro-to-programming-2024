import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JackHammerTest {

    @Test
    void getRequirements() {
        JackHammer j = new JackHammer("jack");
        assertEquals("jack", j.getRequirements());
    }

    @Test
    void testToString() {
        JackHammer j = new JackHammer("jack");
        assertEquals("Jack hammer: jack", j.toString());
    }

    @Test
    void testEquals() {
        JackHammer j = new JackHammer("jack");
        JackHammer j2 = new JackHammer("jack");
        JackHammer j3 = new JackHammer("not jack");
        assertEquals(j, j);
        assertEquals(j, j2);
        assertNotEquals(j, j3);
        assertNotEquals(j, null);
        assertNotEquals(j, new Object());

    }
}