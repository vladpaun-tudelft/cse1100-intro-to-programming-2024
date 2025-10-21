import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {

    @Test
    void testEquals() {
        Player p1 = new Player();
        Player p2 = new Player();
        assertEquals(p1, p2);
    }

    @Test
    void testToString() {
        Player p1 = new Player();
        assertEquals(p1.toString(), "The current player stats are: \n" +
                "\tIt has 3 attack, 1 defence, 30 health, and 3 speed.\n" +
                "\tNo offensive equipment.\n" +
                "\tNo defensive equipment.");
    }

    @Test
    void testHashCode() {
        Player p1 = new Player();
        Player p2 = new Player();
        assertEquals(p1.hashCode(), p2.hashCode());
    }
}