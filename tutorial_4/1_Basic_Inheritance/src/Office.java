public class Office extends Building {
    private int amountOfWorkers;

    public Office(int amountOfWorkers, String street, int value) {
        super(street, value);
        this.amountOfWorkers = amountOfWorkers;
    }

    public int getAmountOfWorkers() {
        return amountOfWorkers;
    }

    public void setAmountOfWorkers(int amountOfWorkers) {
        this.amountOfWorkers = amountOfWorkers;
    }
}
