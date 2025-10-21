import java.util.List;
import java.util.Objects;
import java.util.Random;

public class BallMachine {
    private final List<Ball> balls;

    public BallMachine(List<Ball> ballList) {
        balls = ballList;
    }

    public List<Ball> getBalls() {
        return balls;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("This ball machine has " + balls.size() + "ball(s).");
        for (int i = 0; i < balls.size(); i++) {
            sb.append("\n\t").append(i + 1).append(". ").append(balls.get(i).toString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallMachine that = (BallMachine) o;
        return Objects.equals(balls, that.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(balls);
    }

    public Ball drawBall() {
        int rand = new Random().nextInt(balls.size());
        return this.balls.remove(rand);
    }
}
