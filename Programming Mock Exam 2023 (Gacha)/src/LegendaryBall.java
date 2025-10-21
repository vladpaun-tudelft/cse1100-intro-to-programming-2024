import java.util.Random;

public class LegendaryBall extends PrizeBall{
    public LegendaryBall(String color, String description, Prize prize) {
        super(color, description, prize);
    }

    public static Ball readBall(String ballColor, String ballDescription, PrizeRange prizeRange) {
        Prize prize = prizeRange.getPossiblePrizes().get(new Random().nextInt(prizeRange.getPossiblePrizes().size()));
        return new LegendaryBall(ballColor,ballDescription, prize);
    }

    @Override
    public String toString() {
        return "Legendary ball "  +
                "(" + this.getColor() + ")" +
                ", it contains " + this.getPrize().getName();
    }
}
