package transport.lines;


public class TrainLine extends PublicTransportLine {

    private final String trainType;
    private final boolean isBroken;
    private final int delay;

    /**
     * Creates a train line.
     *
     * @param name The name of the train line
     * @param route Class that contains: The station where the train starts from,
     *              The station the train stops at, distance The distance between the stops
     * @param trainType The type of train, either 'Sprinter' or 'Intercity'
     * @param isBroken Whether the train line is broken
     * @param delay The amount of delay in minutes
     */
    public TrainLine(String name, Route route,
                     String trainType, boolean isBroken, int delay) {
        super(name, route.getFrom(), route.getTo(), 130.0, route.getDistance());
        this.trainType = trainType;
        this.isBroken = isBroken;
        this.delay = delay;
    }

    /**
     * @inheritDoc
     */
    @Override
    public double getTime() {
        if (isBroken) return 60 * 24;
        return delay + ((trainType.equals("Sprinter")) ? super.getTime() * 1.1 : super.getTime());
    }
}
