package sounds;

import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongReaderTest {

    @Test
    void readSong() {
        String songText = """
                CHANNELS 4
                NOTE C4 - loudness 0.9
                START 00:00.0000
                END 00:01.0000
                NOTE D4 - loudness 0.8
                START 00:01.0000
                END 00:02.0000
                NOTE E4 - loudness 0.7
                START 00:02.0000
                END 00:03.0000
                NOTE C#4 - loudness 0.2
                START 01:01.0000
                END 01:02.0000
                """.stripIndent();

        Song expectedSong = new Song(4, List.of(
                new PlayNote("C4", 0.9, 0.0, 1.0),
                new PlayNote("D4", 0.8, 1.0, 2.0),
                new PlayNote("E4", 0.7, 2.0, 3.0),
                new PlayNote("C#4", 0.2, 61.0, 62.0)
        ));

        Song readSong = SongReader.readSong(new StringReader(songText));
        assertEquals(expectedSong, readSong);
    }

}
