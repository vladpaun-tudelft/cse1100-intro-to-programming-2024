package sounds;

import sounds.internal.Note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SongReader {

    public static Song readSong(Reader reader) {

        int channels;
        List<PlayNote> notes = new ArrayList<PlayNote>();

        try (BufferedReader br = new BufferedReader(reader)) {

            String line = br.readLine();
            channels = Integer.parseInt(line.split(" ")[1]);

            String note, start, end;
            do {
                note = br.readLine();
                start = br.readLine();
                end = br.readLine();

                notes.add(readNote(note, start, end));
            } while (note != null && start != null && end != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Song(channels, notes);
    }

    private static PlayNote readNote(String note, String start, String end) {
        String[] noteParts = note.split(" ");
        String noteName = noteParts[1];
        double loudness = Double.parseDouble(noteParts[4]);

        String [] startParts = start.split(":");
        double startMinutes = Double.parseDouble(startParts[0].split(" ")[1]);
        double startSeconds = Double.parseDouble(startParts[1]);

        double startTime = 60 * startMinutes + startSeconds;

        String[] endParts = end.split(":");
        double endMinutes = Double.parseDouble(endParts[0].split(" ")[1]);
        double endSeconds = Double.parseDouble(endParts[1]);

        double endTime = 60 * endMinutes + endSeconds;

        return new PlayNote(noteName, loudness, startTime, endTime);
    }

}
