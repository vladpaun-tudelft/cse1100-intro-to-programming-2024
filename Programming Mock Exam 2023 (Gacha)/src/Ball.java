import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Ball {
    private final String color;
    private final String description;

    public Ball(String color, String description) {
        this.color = color;
        this.description = description;
    }

    public static List<Ball> readBalls(String ballTypeNumber, String ballColor,
                                       String ballDescription, String prizeRangeString) {
        List<Ball> ballList = new ArrayList<>();

        Scanner sc = new Scanner(ballTypeNumber);
        sc.useDelimiter("\\[");

        String ballType = sc.next().split(" ")[0];

        int number = Integer.parseInt(sc.next().split("]")[0]);

        PrizeRange prizeRange = PrizeRange.readPrizeRange(prizeRangeString, ballDescription);

        for (int i = 0; i < number; i++) {
            switch (ballType) {
                case "NORMAL":
                    ballList.add(NormalBall.readBall(ballColor,ballDescription,prizeRange));
                    break;
                case "RARE":
                    ballList.add(RareBall.readBall(ballColor,ballDescription,prizeRange));
                    break;
                case "EPIC":
                    ballList.add(EpicBall.readBall(ballColor,ballDescription,prizeRange));
                    break;
                case "LEGENDARY":
                    ballList.add(LegendaryBall.readBall(ballColor,ballDescription,prizeRange));
                    break;
            }
        }
        return ballList;

    }

    public static List<Ball> readEmptyBall(String ballTypeNumber,
                                           String ballColor, String ballDescription) {
        List<Ball> ballList = new ArrayList<>();
        Scanner sc = new Scanner(ballTypeNumber);
        sc.useDelimiter("\\[");

        String ballType = sc.next().split(" ")[0];

        int number = Integer.parseInt(sc.next().split("]")[0]);
        for (int i = 0; i < number; i++) {
            ballList.add(EmptyBall.readBall(ballColor,ballDescription));
        }
        return ballList;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Ball{" +
                "color='" + color + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(color, ball.color) && Objects.equals(description, ball.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, description);
    }


}
