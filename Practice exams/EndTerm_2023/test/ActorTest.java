import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    @Test
    void readActor() {
        String actorString = "CAST Kristen Bell; Anna";
        Actor actor = Actor.readActor(actorString);
        assertNotNull(actor);
        assertEquals("Kristen Bell (Anna)", actor.toString());
    }

    @Test
    void testEquals() {
        Actor actor1 = new Actor("Kristen Bell", "Anna");
        Actor actor2 = new Actor("Kristen Bell", "Anna");
        assertEquals(actor1, actor2);
        Actor actor3 = new Actor("Kristen Bell", "Aadifb");
        assertNotEquals(actor1, actor3);
    }

    @Test
    void testToString() {
        Actor actor1 = new Actor("Kristen Bell", "Anna");
        assertEquals("Kristen Bell (Anna)", actor1.toString());
    }

    @Test
    void testHashCode() {
        Actor actor1 = new Actor("Kristen Bell", "Anna");
        Actor actor2 = new Actor("Kristen Bell", "Anna");
        assertEquals(actor1.hashCode(), actor2.hashCode());
    }
}