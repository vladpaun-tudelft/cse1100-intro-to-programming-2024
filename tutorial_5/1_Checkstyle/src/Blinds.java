public class Blinds extends Appliance {

    private boolean closed;

    /**
     * Creates a blinds.
     *
     * @param name The name
     * @param closed Whether the blinds are closed
     */
    public Blinds(String name, boolean closed) {
        super(name);
        this.closed = closed;
    }

    /**
     * Opens the blinds.
     */
    public void open() {
        closed = false;
    }

    /**
     * Closes the blinds.
     */
    public void close() {
        closed = true;
    }

    /**
     * Gets whether the blinds are closed.
     *
     * @return True iff the blinds are closed
     */
    public boolean isclosed() {
        return closed;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getDescription() {
        return "Blinds " + getName() + (closed ? " are closed" : " are open");
    }
}
