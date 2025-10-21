public class EmptyBall extends Ball {
    public EmptyBall(String color, String description) {
        super(color,description);
    }

    public static Ball readBall(String ballColor, String ballDescription) {
        return new EmptyBall(ballColor, ballDescription);
    }

    @Override
    public String toString() {
        return "Empty ball "  +
                "(" + this.getColor() + ")" +
                ", it does not contain a prize.";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
