import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements Runnable {
    public static void main(String[] args) {
        threadPractice();
    }

    public static void timeCalculations() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Departure time: ");
        double departureTime = scanner.nextDouble();
        System.out.print("Arrival time: ");
        double arrivalTime = scanner.nextDouble();

        int departureHour = (int) departureTime;

        int arrivalHour = (int) arrivalTime;

        long departureMinutes = Math.round ((departureTime - departureHour) * 100);

        long arrivalMinutes = Math.round((arrivalTime - arrivalHour) * 100);

        int totalHours = arrivalHour - departureHour;
        totalHours += totalHours < 0 ? 12 : 0;

        long totalMinutes = arrivalMinutes - departureMinutes;
        if (totalMinutes < 0) {
            totalMinutes += 60;
            totalHours--;
        }

        String totalMinutesString = String.format("%02d", totalMinutes);
        String totalHoursString = String.format("%02d", totalHours);

        System.out.println("Total travel time: " + totalHoursString + ":" + totalMinutesString + ".");
    }

    public static void threadPractice() {
        Thread.ofPlatform().start(new Main());
        Thread.ofPlatform().start(new Main());

    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}