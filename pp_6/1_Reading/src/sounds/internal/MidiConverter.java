package sounds.internal;

import sounds.PlayNote;

import javax.sound.midi.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MidiConverter {

    private static final int NOTE_ON = 0x90;
    private static final int NOTE_OFF = 0x80;
    private static final String[] NOTE_NAMES =
        {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    public static void convertMidi(String midiFile, String outputFile)
            throws InvalidMidiDataException, IOException, MidiUnavailableException {
        Sequence sequence = MidiSystem.getSequence(new File(midiFile));
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(sequence);

        MidiInfo info = processSequence(sequence);

        sequencer.close();

        writeEvents(outputFile, info.channels(), info.events());
    }

    private static MidiInfo processSequence(Sequence sequence) {
        double bpm = 0;
        List<NoteEvent> events = new ArrayList<>();
        Set<Integer> channels = new HashSet<>();
        int channelCount = 0;

        for (Track track : sequence.getTracks()) {
            for (int i = 0; i < track.size(); i++) {

                MidiEvent event = track.get(i);
                MidiMessage message = event.getMessage();

                long tick = event.getTick();
                double time = (60.0 / bpm / sequence.getResolution()) * tick;

                if (message instanceof ShortMessage sm) {
                    processMessage(sm, events, channels, time);
                    channelCount = Math.max(channelCount, channels.size());
                } else if (message instanceof MetaMessage mm) {
                    if (mm.getType() == 0x51) {
                        int tempo =
                                ((mm.getData()[0] & 0xFF) << 16) |
                                ((mm.getData()[1] & 0xFF) << 8) |
                                (mm.getData()[2] & 0xFF);
                        bpm = 60.0 / (tempo / 1_000_000.0);
                    }
                }

            }
        }

        return new MidiInfo(channelCount, events);
    }

    private static void processMessage(ShortMessage sm, List<NoteEvent> events,
                                       Set<Integer> channels, double time) {
        if (sm.getCommand() == NOTE_ON) {
            channels.add(sm.getChannel());
            int key = sm.getData1();
            int octave = (key / 12) - 1;
            int note = key % 12;
            String noteName = NOTE_NAMES[note];
            int velocity = sm.getData2();
            events.add(new NoteEvent(noteName + octave, true, time, velocity / 128.0));
        } else if (sm.getCommand() == NOTE_OFF) {
            channels.remove(sm.getChannel());
            int key = sm.getData1();
            int octave = (key / 12) - 1;
            int note = key % 12;
            String noteName = NOTE_NAMES[note];
            int velocity = sm.getData2();
            events.add(new NoteEvent(noteName + octave, false, time, velocity / 128.0));
        }
    }

    private static void writeEvents(String outputFile, int channelCount, List<NoteEvent> events)
            throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        Map<String, NoteEvent> started = new HashMap<>();
        List<PlayNote> plays = new ArrayList<>();
        for (NoteEvent event : events) {
            if (event.on()) {
                started.put(event.note(), event);
            } else {
                NoteEvent start = started.get(event.note());
                plays.add(new PlayNote(start.note(),
                        start.velocity() * start.velocity(),
                        start.time(), event.time()));
            }
        }
        Collections.shuffle(plays);
        writer.println("CHANNELS " + channelCount);
        for (PlayNote play : plays) {
            writer.println(String.format("NOTE %s - loudness: %.3f",
                    play.getNote(), play.getLoudness()));
            writer.println(String.format("START %02d:%07.4f",
                    (int)(play.getStart()/60.0), play.getStart() % 60));
            writer.println(String.format("END %02d:%07.4f",
                    (int)(play.getEnd()/60.0), play.getEnd() % 60));
        }
        writer.close();
    }

    private record NoteEvent(String note, boolean on, double time, double velocity) {}
    private record MidiInfo(int channels, List<NoteEvent> events) {}

}
