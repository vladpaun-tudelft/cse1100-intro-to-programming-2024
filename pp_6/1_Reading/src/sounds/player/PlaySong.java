package sounds.player;

import sounds.Song;
import sounds.SongReader;
import sounds.internal.SongPlayer;

import java.io.*;

public class PlaySong {

    public static void main(String[] args) {

        try {
            Song song = SongReader.readSong(new FileReader("resources/song.txt"));
            SongPlayer.playSong(song);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
