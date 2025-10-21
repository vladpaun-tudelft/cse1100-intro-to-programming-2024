
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static String subscriptionFilePath;
    private static String prepaidFilePath;
    private static Scanner userInput = new Scanner(System.in);
    private static PhonePlanCollection phonePlanCollection;
    private static int choice;

    /**
     * Main method for the applicatio
     * @param args no cli args ex[ecte
     */
    public static void main(String[] args) {

        userInput.useDelimiter("\n");
        System.out.println("Please provide Subscription ABSOLUTE file path");
        subscriptionFilePath = userInput.next();
        System.out.println("Please provide Prepaid ABSOLUTE file path");
        prepaidFilePath = userInput.next();

        phonePlanCollection = PhonePlanCollection.read(subscriptionFilePath,prepaidFilePath);

        do {
            printMenu();
            choice = userInput.nextInt();
            executeChoice(choice);
        } while (choice != 4);

    }

    /**
     * Executes the choice made by the user
     * @param choice the choice
     */
    private static void executeChoice(int choice) {
        switch (choice) {
            case 1 -> System.out.println(phonePlanCollection);
            case 2 -> System.out.println(filterOptions());
            case 3 -> writeToFile();
        }
    }

    /**
     * Writes to a file
     */
    private static void writeToFile() {
        System.out.println("Please enter filename: ");
        try {
            PrintWriter pw = new PrintWriter(new File(userInput.next()));
            PhonePlanCollection toWrite = new PhonePlanCollection(
                    phonePlanCollection.getPhonePlans().stream()
                            .sorted().collect(Collectors.toList())
            );
            for (PhonePlan p : toWrite.getPhonePlans()) {
                pw.println(p.toFile());
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * filters th options base on userinput
     */
    private static PhonePlanCollection filterOptions() {
        PhonePlanCollection filteredCollection =
                PhonePlanCollection.read(subscriptionFilePath,prepaidFilePath);
        filteredCollection = firstFilter(filteredCollection);
        filteredCollection = secondFilter(filteredCollection);
        filteredCollection = thirdFilter(filteredCollection);
        return filteredCollection;
    }

    /**
     * filters by price and stuff
     * @param filteredCollection the full object
     * @return the filtered collection
     */
    private static PhonePlanCollection thirdFilter(PhonePlanCollection filteredCollection) {
        System.out.println("""
                Please make your choice:\s
                1 –    Filter by maximum price
                2 –    Filter by mimimum plan details""");
        int choice2 = userInput.nextInt();
        return switch (choice2) {
            case 1 -> filterByMaxPrice(filteredCollection);
            case 2 -> filterByMinDetails(filteredCollection);
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    private static PhonePlanCollection filterByMinDetails(PhonePlanCollection filteredCollection) {
        System.out.println("Please enter your min calling minutes: ");
        int callingMinutes = userInput.nextInt();
        System.out.println("Please enter your min texts: ");
        int texts = userInput.nextInt();
        System.out.println("Please enter your min gigabytes: ");
        int gigabytes = userInput.nextInt();


        return new PhonePlanCollection(
                filteredCollection.getPhonePlans().stream()
                        .filter(value ->
                                value.getDetails().callMins() >= callingMinutes &&
                                value.getDetails().texts() >= texts
                                && value.getDetails().data() >= gigabytes)
                        .collect(Collectors.toList())
        );
    }

    /**
     * filters by max price
     * @param filteredCollection the full object
     * @return the filtered collection
     */
    private static PhonePlanCollection filterByMaxPrice(PhonePlanCollection filteredCollection) {
        System.out.println("Please enter your max price: ");
        int maxPrice = userInput.nextInt();
        return new PhonePlanCollection(
                filteredCollection.getPhonePlans().stream()
                        .filter(value -> value.getDetails().price() <= maxPrice)
                        .collect(Collectors.toList())
        );
    }

    /**
     * filters by student or not
     * @param filteredCollection the full object
     * @return the filtered collection
     */
    private static PhonePlanCollection secondFilter(PhonePlanCollection filteredCollection) {
        System.out.println("""
                Please make your choice:\s
                1 –    Show only student offers
                2 –    Show only non-student offers""");
        int choice2 = userInput.nextInt();
        return switch (choice2) {
            case 1 -> new PhonePlanCollection(
                    filteredCollection.getPhonePlans().stream()
                            .filter(PhonePlan::isStudentOnly)
                            .collect(Collectors.toList())
            );
            case 2 -> new PhonePlanCollection(
                    filteredCollection.getPhonePlans().stream()
                            .filter(value -> !value.isStudentOnly())
                            .collect(Collectors.toList())
            );
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    /**
     * filters by use type
     * @param filteredCollection the full object
     * @return the filtered collection
     */
    private static PhonePlanCollection firstFilter(PhonePlanCollection filteredCollection) {
        System.out.println("""
                Please make your choice:\s
                1 –    Show all subscriptions and prepaid formulas
                2 –    Show only subscription plans
                3 –    Show only prepaid plans""");
        int choice2 = userInput.nextInt();
        return switch (choice2) {
            case 1 -> filteredCollection;
            case 2 -> new PhonePlanCollection(
                    filteredCollection.getPhonePlans().stream()
                            .filter(x -> x instanceof SubscriptionPlan)
                            .collect(Collectors.toList())
            );
            case 3 -> new PhonePlanCollection(
                    filteredCollection.getPhonePlans().stream()
                            .filter(x -> x instanceof PrePaidPlan)
                            .collect(Collectors.toList())
            );
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    /**
     * Prints the main menu of the app
     */
    private static void printMenu() {
        System.out.println("""
                Please make your choice:\s
                1 –    Show all subscriptions and prepaid formulas
                2 –    Filter subscriptions and prepaid formulas
                3 –    Write to file
                4 –    Stop the program""");
    }
}