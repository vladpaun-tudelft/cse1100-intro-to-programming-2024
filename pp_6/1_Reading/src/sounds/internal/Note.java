package sounds.internal;

public enum Note {

    C4(261.63), CSharp4(277.18),
    D4(293.66), DSharp4(311.13),
    E4(329.23),
    F4(349.23), FSharp4(369.99),
    G4(392.00), GSharp4(415.30),
    A4(440.00), ASharp4(466.16),
    B4(493.88);

    public static double frequency(String noteName) {
        String note = noteName.substring(0, 1);
        if (noteName.contains("#")) note += "Sharp";
        int octave = noteName.charAt(noteName.length() - 1) - '0';
        Note middleNote = Note.valueOf(note + "4");
        if (octave == 4) return middleNote.getFrequency();
        else if (octave < 4) return middleNote.getFrequency() / (1 << (4 - octave));
        else return middleNote.getFrequency() * (1 << (octave - 4));
    }

    private final double frequency;

    Note(double frequency) {
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }

}
