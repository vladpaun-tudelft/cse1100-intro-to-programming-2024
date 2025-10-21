import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConcertTest {

    @Test
    void duration() {
        assertEquals("3:02", TestDB.concertLA.getDuration());
    }

}
