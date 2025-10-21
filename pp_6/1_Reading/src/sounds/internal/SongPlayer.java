package sounds.internal;

import sounds.PlayNote;
import sounds.Song;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

public class SongPlayer {

    public static void playSong(Song song)
            throws LineUnavailableException, IOException {
        byte[] bytes = generate(song.getChannels(), song.getNotes());
        play(bytes);
    }

    private static byte[] generate(int channels, List<PlayNote> plays) {
        int length = (int) (plays.stream()
                .max(Comparator.comparing(PlayNote::getEnd))
                .orElseThrow()
                .getEnd()) + 1;

        Queue<PlayNote> starts = new ArrayDeque<>(plays.stream()
                .sorted(Comparator.comparing(PlayNote::getStart)).toList());
        Queue<PlayNote> ends = new ArrayDeque<>(plays.stream()
                .sorted(Comparator.comparing(PlayNote::getEnd)).toList());
        Set<PlayNote> playing = new HashSet<>();

        byte[] bytes = new byte[length * 44100 * 2];
        for (int i = 0; i < bytes.length / 2; i++) {

            if (i % (44100 * 5) == 0) {
                System.out.println("Generating song... [" +
                        (int) (i / (double)bytes.length * 2.0 * 100.0) + "%]");
            }

            double t = i / 44100.0;
            updatePlaying(playing, starts, ends, t);

            short value = wave(playing, t, channels);
            bytes[i*2] = (byte) (value & 0xff);
            bytes[i*2+1] = (byte) ((value >> 8) & 0xff);

        }

        return bytes;
    }

    private static void updatePlaying(Set<PlayNote> playing,
                                      Queue<PlayNote> starts, Queue<PlayNote> ends,
                                      double t) {
        while (!starts.isEmpty()) {
            PlayNote play = starts.peek();
            if (play.getStart() > t) break;
            playing.add(starts.remove());
        }
        while (!ends.isEmpty()) {
            PlayNote play = ends.peek();
            if (play.getEnd() > t) break;
            playing.remove(ends.remove());
        }
    }

    private static short wave(Set<PlayNote> playing, double t, int channels) {
        short value = 0;
        for (PlayNote play : playing) {
            double theta = t * Note.frequency(play.getNote()) * 2.0 * Math.PI;
            value += (short) (Math.sin(theta) *
                    Short.MAX_VALUE * 0.66 / channels * play.getLoudness());
            value += (short) (Math.sin(theta * 2.0) *
                    Short.MAX_VALUE * 0.2 / channels * play.getLoudness());
            value += (short) (Math.sin(theta * 3.0) *
                    Short.MAX_VALUE * 0.1 / channels * play.getLoudness());
            value += (short) (Math.sin(theta * 4.0) *
                    Short.MAX_VALUE * 0.03 / channels * play.getLoudness());
        }
        return value;
    }

    private static void play(byte[] bytes) throws LineUnavailableException, IOException {
        System.out.println("Playing...");

        AudioInputStream audioStream = new AudioInputStream(new ByteArrayInputStream(bytes),
                new AudioFormat((float) 44100, 16, 1, true, false),
                bytes.length / 2);
        Clip audioClip = AudioSystem.getClip();
        audioClip.open(audioStream);
        audioClip.start();
        while (audioClip.getFramePosition() < audioClip.getFrameLength()) {
            Thread.yield();
        }
        audioClip.close();
        audioStream.close();
    }

}
