import com.sun.tools.javac.Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataProcessingApplication  implements Runnable {

    private static int numbersRead = 0;
    private static final int TOTAL_NUMBERS = 10_000_000;

    public static void main(String[] args) {
        DataProcessingApplication data = new DataProcessingApplication();
        ProgressBar progressBar = new ProgressBar();

        Thread thread1 = new Thread(data);
        Thread thread2 = new Thread(progressBar);

        thread1.start();
        thread2.start();
    }


    public static int getNumbersRead() {
        return numbersRead;
    }

    public static int getTOTAL_NUMBERS() {
        return TOTAL_NUMBERS;
    }

    @Override
    public void run() {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("resources/numbers.txt"))) {



            while (numbersRead < TOTAL_NUMBERS) {
                numbers.add(sc.nextInt());
                numbersRead++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long total = 0;
        for (int n : numbers) total += n;
        System.out.println("Total: " + total);
    }
}