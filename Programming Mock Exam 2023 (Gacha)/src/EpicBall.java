import java.util.Random;

public class EpicBall extends PrizeBall{
    public EpicBall(String color, String description, Prize prize) {
        super(color, description, prize);
    }

    public static Ball readBall(String ballColor, String ballDescription, PrizeRange prizeRange) {
        Prize prize = prizeRange.getPossiblePrizes()
                .get(new Random().nextInt(prizeRange.getPossiblePrizes().size()));
        return new EpicBall(ballColor,ballDescription, prize);
    }

    @Override
    public String toString() {
        return "Epic ball "  +
                "(" + this.getColor() + ")" +
                ", it contains " + this.getPrize().getName();
    }
}
