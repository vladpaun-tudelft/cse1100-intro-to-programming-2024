public interface Togglable {

    /**
     * Turns the togglable off.
     */
    void turnOff();

    /**
     * Turns the togglable on.
     */
    void turnOn();

    /**
     * Gets whether the togglable is on.
     *
     * @return True iff this togglable is on
     */
    boolean isOn();

    /**
     * Toggles the on state of the togglable.
     *
     * @return The new on state
     */
    default boolean toggle() {
        if (isOn()) {
            turnOff();
            return false;
        } else {
            turnOn();
            return true;
        }
    }

}
