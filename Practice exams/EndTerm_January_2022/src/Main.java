import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner userInput;
    private static CardCollection cardCollection;
    private static int choice;
    private static UserCollection userCollection;

    /**
     * Main method of this app
     * @param args no cli args exp ected
     */
    public static void main(String[] args) {
        userInput = new Scanner(System.in);
        userInput.useDelimiter("\n");

        System.out.print("Please enter absolute file path: ");
        String filePath = userInput.next();

        cardCollection = CardCollection.read(filePath);
        userCollection = new UserCollection(cardCollection);

        do {
            printMenu();
            choice = userInput.nextInt();
            executeChoice(choice);
        } while (choice != 6);

    }

    /**
     * Execute the main functionality of the app
     * @param choice choice of user
     */
    private static void executeChoice(int choice) {
        switch (choice) {
            case 1 -> System.out.println(cardCollection);
            case 2 -> System.out.println(userCollection);
            case 3 -> System.out.println(userCollection.openPack());
            case 4 -> System.out.println(userCollection.out());
            case 5 -> System.out.println(userCollection.in());
        }
    }

    /**
     * Prints the menu of the app
     */
    private static void printMenu() {
        System.out.println("""
                1 – Show all known cards.
                2 – Show user’s card collection and gold.
                3 – Open a pack of cards.
                4 – Save collection to file.
                5 – Restore collection from file.
                6 – Quit the application.""");
    }
}