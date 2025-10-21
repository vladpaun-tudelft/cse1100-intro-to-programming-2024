public class Herb extends Plant {
    private boolean isSafe;
    private String taste;

    public Herb(String name, String latinName, SizeRange size, Flower flower, boolean isSafe, String taste) {
        super(name, latinName, size, flower);
        this.isSafe = isSafe;
        this.taste = taste;
    }
}
