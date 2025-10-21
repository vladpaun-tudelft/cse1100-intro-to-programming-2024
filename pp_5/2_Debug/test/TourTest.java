import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TourTest {

    @Test
    void comingTo() {
        assertTrue(TestDB.eras.comingTo("Amsterdam"));
    }

    @Test
    void encore() {
        assertTrue(TestDB.eras.alreadyPlayedEncore(TestDB.corneliaStreet));
    }

}
