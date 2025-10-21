import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaffoldingTowerTest {

    @Test
    void getRequirements() {
        ScaffoldingTower s = new ScaffoldingTower("metal");
        assertEquals("metal", s.getRequirements());
    }

    @Test
    void testToString() {
        ScaffoldingTower s = new ScaffoldingTower("metal");
        assertEquals("Scaffolding tower: metal", s.toString());
    }

    @Test
    void testEquals() {
        ScaffoldingTower s = new ScaffoldingTower("metal");
        ScaffoldingTower s2 = new ScaffoldingTower("metal");
        ScaffoldingTower s3 = new ScaffoldingTower("not metal");
        assertEquals(s, s);
        assertEquals(s, s2);
        assertNotEquals(s, s3);
        assertNotEquals(s, null);
        assertNotEquals(s, new Object());
    }
}