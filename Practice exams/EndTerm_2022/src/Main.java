import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static MechGame game;
    private static Scanner userInput;
    private static int choice;
    private  static Player player;

    /**
     * Main method of this application
     * @param args nocli args expected
     */
    public static void main(String[] args) {
        userInput = new Scanner(System.in);
        userInput.useDelimiter("\n");

        System.out.print("Please enter filepath: ");
        String filePath = userInput.nextLine();

        game = MechGame.readGame(filePath);

        player = game.getPlayer();

        do {
            printMenu();
            choice = userInput.nextInt();
            executeChoice(choice);
        } while (choice != 6);

    }

    private static void executeChoice(int choice) {
        switch (choice) {
            case 1 -> System.out.println(game.mechsString());
            case 2 -> System.out.println(player);
            case 3 -> game.fight();
            case 4 -> game.log();
            case 5 -> game = MechGame.in();
        }
    }

    private static void printMenu() {
        System.out.println("""
                Please make your choice:\s
                1 – Show all mechs in the system. 
                2 – Show player stats & equipment. 
                3 – Fight a mech.
                4 – Write current state to file. 
                5 – Restore state from file.
                6 – Quit the application.""");
    }
}