import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataProcessingApplication implements Runnable {

    private static String filePath = "C:\\Users\\vladp\\IdeaProjects\\tutorial_8\\tutorial_8\\resources\\numbers.txt";
    private static int numbersRead = 0;
    private static final int TOTAL_NUMBERS = 10_000_000;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(filePath))) {
            Thread.ofPlatform().start(new DataProcessingApplication());
            while (numbersRead < TOTAL_NUMBERS) {
                numbers.add(sc.nextInt());
                numbersRead++;
                //updateProgressBar();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long total = 0;
        for (int n : numbers) total += n;
        System.out.println("Total: " + total);
    }

    private static void updateProgressBar() {
        int progress = (int) Math.round(((50.0 * numbersRead) / TOTAL_NUMBERS));
        for (int i = 0; i < progress; i++) System.out.print("\uD83E\uDEA8");
        for (int i = progress; i < 50; i++) System.out.print("✂\uFE0F");
        System.out.print("\r");
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (numbersRead < TOTAL_NUMBERS) {
            updateProgressBar();
        }
    }
}
