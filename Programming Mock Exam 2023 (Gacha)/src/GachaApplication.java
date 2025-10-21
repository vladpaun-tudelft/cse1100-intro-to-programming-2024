import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class GachaApplication {
    private static BallMachine ballMachine;
    private static List<Ball> drawnBalls = new ArrayList<>();

    public static void main(String[] args) {

        ballMachine = new BallMachine(readInFile());

        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("\n");
        int choice;
        System.out.println("Welcome to the Ball Machine.");
        do {
            printMenu();
            choice = userInput.nextInt();

            executeChoice(choice);

        } while (choice != 5);

            
    }

    private static void executeChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println(ballMachine);
                break;
            case 2:
                printLegendaryChance();
                break;
            case 3:
                drawBall();
                break;
            case 4:
                logDrawnBalls();
                break;
        }
    }

    private static void logDrawnBalls() {
        try {
            PrintWriter writer = new PrintWriter("resources/logs.txt");
            for (int i = 0; i < drawnBalls.size(); i++) {
                writer.println((i+1) + ". A " + drawnBalls.get(i) + " was drawn.");
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void drawBall() {
        Ball ball = ballMachine.drawBall();
        drawnBalls.add(ball);
        System.out.println("You are drawing a random ball.\n...");
        System.out.println(ball.getDescription());
        System.out.println("You get a " + ball.toString() + "\n");
    }

    private static void printLegendaryChance() {
        int numberLegBalls = 0;
        for (Ball ball : ballMachine.getBalls()) {
            if (ball instanceof LegendaryBall) {
                numberLegBalls++;
            }
        }
        double chance = Math.floor((double)(numberLegBalls) / ballMachine.getBalls().size() * 100 * 100) / 100;
        System.out.println("The current chance to win a legendary ball is " +
                chance + "%.\n");
    }

    private static List<Ball> readInFile() {
        List<Ball> ballList = new ArrayList<Ball>();
        try {
            Scanner inFile = new Scanner(new File("resources/gacha.txt"));
            while (inFile.hasNextLine()) {
                String ballTypeNumber = inFile.nextLine();

                Scanner sc = new Scanner(ballTypeNumber);
                sc.useDelimiter("\\[");

                String ballType = sc.next().split(" ")[0];

                int number = Integer.parseInt(sc.next().split("]")[0]);

                if (!ballType.equals("EMPTY")) {
                    for (Ball ball : Ball.readBalls(
                            ballTypeNumber,
                            inFile.nextLine(),
                            inFile.nextLine(),
                            inFile.nextLine())
                    ) {
                        ballList.add(ball);
                    }
                }
                else {
                    for (Ball ball : Ball.readEmptyBall(
                            ballTypeNumber,
                            inFile.nextLine(),
                            inFile.nextLine())
                    ) {
                        ballList.add(ball);
                    }
                }
            }
            inFile.close();
            return ballList;
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printMenu() {
        System.out.println(
                "1 – Show all balls currently in the machine.\n" +
                "2 - Show current chance to win the legendary prize.\n" +
                "3 - Draw a ball.\n" +
                "4 - Write debug output to file.\n" +
                "5 - Quit the application."
        );
    }


}
