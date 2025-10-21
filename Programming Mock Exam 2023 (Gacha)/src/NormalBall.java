import java.util.Random;

public class NormalBall extends PrizeBall{
    public NormalBall(String color, String description, Prize prize) {
        super(color, description, prize);
    }

    public static Ball readBall(String ballColor, String ballDescription, PrizeRange prizeRange) {
        Prize prize = prizeRange.getPossiblePrizes().get(new Random().nextInt(prizeRange.getPossiblePrizes().size()));
        return new NormalBall(ballColor,ballDescription, prize);

    }

    @Override
    public String toString() {
        return "Normal ball " +
                "(" + this.getColor() + ")" +
                ", it contains " + this.getPrize().getName();
    }
}
