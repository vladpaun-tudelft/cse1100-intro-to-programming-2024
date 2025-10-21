
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    
    private static Scanner userInput = new Scanner(System.in);
    private static int choice;
    private static String filePath;
    private static PlantCollection plants;
    private static PlantCollection plantsCopy;
    
    /**
     * Main meythod of our application
     * @param args no cli args expected
     */
    public static void main(String[] args) {
        userInput.useDelimiter("\n");
        filePath = getFile();
        
        plants = PlantCollection.read(filePath);
        plantsCopy = plants.copy();
        
        do {
            printMenu();
            choice = userInput.nextInt();
            executeChoice(choice);
        } while (choice != 7);
        
    }

    /**
     * Executes the functionality of the app
     * @param choice the choice of the action
     */
    private static void executeChoice(int choice) {
        switch (choice) {
            case 1 -> System.out.println(plants);
            case 2 -> System.out.println(filterBySize());
            case 3 -> System.out.println(filterByColor());
            case 4 -> System.out.println(filterbyEdibility());
            case 5 -> System.out.println(resetFilters());
            case 6 -> System.out.println(simulateGlobalWarming());
        }
    }

    private static String filterbyEdibility() {
        System.out.println("Would you like to filter by herbs that" +
                " are edible or not edible? (edible / not edible)");
        String option = userInput.next();
        boolean getEdible;
        if (option.equals("edible")) {
            getEdible = true;
        } else if (option.equals("not edible")) {
            getEdible = false;
        }
        else {
            return "Incorrect input.";
        }
        return plants.filterByEdibility(getEdible);
    }

    private static String filterByColor() {
        System.out.println(plants.showColors());

        System.out.print("Please pick one color: ");
        return plants.filterByColor(userInput.next());
    }

    private static String filterBySize() {
        System.out.print("Please enter a size to filter by: ");
        return plants.filterBySize(userInput.nextInt());
    }

    private static String simulateGlobalWarming() {

        resetFilters();
        plants.simulateGlobalWarming();
        plantsCopy = plants.copy();

        return "All plants have grown by 10%.";
    }

    /**
     * Resets all filters
     * @return a success string
     */
    private static String resetFilters() {

        plants = plantsCopy.copy();

        return "Filters have been reset.";
    }

    /**
     * Prints the menu of the app
     */
    private static void printMenu() {
        System.out.println("""
                1 –    Show plants that meet all criteria.
                2 –    Filter plants by size.
                3 –    Filter plants by flower colour.
                4 -    Filter plants by edibility.
                5 –    Reset all criteria.
                6 –    Simulate global warming.
                7 –    Quit the application.""");
    }

    /**
     * Gets the filepath from thje user
     * @return the filepath
     */
    private static String getFile() {
        System.out.print("please enter absolute filepath for the file to be read from: ");
        return userInput.next();
    }
}