public class Speaker extends Appliance implements Togglable {

    private boolean on;
    private double volume;
    private String playing;

    /**
     * Creates a speaker.
     *
     * @param name The name of the speaker
     * @param on Whether the speaker is on
     * @param volume The volume of the speaker (between 0 and 1)
     * @param playing The song the speaker is playing
     */
    public Speaker(String name, boolean on, double volume, String playing) {
        super(name);
        this.on = on;
        this.volume = volume;
        this.playing = playing;
    }

    /**
     * Gets the volume.
     *
     * @return The volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Sets the volume.
     *
     * @param volume The new volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Gets the song playing.
     *
     * @return The song playing
     */
    public String getPlaying() {
        return playing;
    }

    /**
     * Sets the song playing and turns the speaker on.
     *
     * @param playing The new song to play
     */
    public void setPlaying(String playing) {
        this.playing = playing;
        turnOn();
        System.out.println(getName() + " is now playing " + playing);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void turnOff() {
        on = false;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void turnOn() {
        on = true;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean isOn() {
        return on;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getDescription() {
        return "Speaker " + getName() + (on ? " is playing " + playing + " at "
                + volume + " volume" : "is not playing");
    }
}
