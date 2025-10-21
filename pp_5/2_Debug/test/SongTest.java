import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {

    @Test
    void equals() {
        assertEquals(new Song("Red", 3*60+43), new Song("Red", 3*60+43));
    }

}
