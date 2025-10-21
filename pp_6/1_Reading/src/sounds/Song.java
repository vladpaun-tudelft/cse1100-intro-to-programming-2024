package sounds;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Song {

    private final int channels;
    private final List<PlayNote> notes;

    public Song(int channels, List<PlayNote> notes) {
        this.channels = channels;
        this.notes = notes;
    }

    public int getChannels() {
        return channels;
    }

    public List<PlayNote> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return channels == song.channels && Objects.equals(notes, song.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channels, notes);
    }
}
