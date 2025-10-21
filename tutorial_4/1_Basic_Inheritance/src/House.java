public class House extends Building {
    private int number;

    public House(int number, String street, int value) {
        super(street, value);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
