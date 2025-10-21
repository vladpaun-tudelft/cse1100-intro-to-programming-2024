import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int choice;
    private static Scanner userInput;
    private static EntertainmentCollection videos;
    private static EntertainmentCollection videosCopy;

    /**
     * Main method of our application
     * @param args no cli args expected
     */
    public static void main(String[] args) {
        userInput = new Scanner(System.in);

        System.out.println("Please enter filepath: ");
        String filePath = userInput.nextLine();

        videos = EntertainmentCollection.readFile(filePath);

        videosCopy = EntertainmentCollection.copy(videos);

        int choice;
        do {
            printMenu();
            choice = userInput.nextInt();
            executeChoice(choice);
        } while (choice != 7);
    }


    /**
     * Executes the choice of the app
     * @param choice choice for cuntionality
     */
    private static void executeChoice(int choice) {
        userInput.useDelimiter("\n");
        switch (choice) {
            case 1 -> System.out.println(videos);
            case 2 -> {
                System.out.println("Enter a genre (Capitalized):");
                String genre = userInput.next();
                videos.filterOnGenre(genre);
            }
            case 3 -> {
                System.out.println("Enter a maximum playtime (in minutes)");
                int playtime = userInput.nextInt();
                videos.filterOnMaxPlaytime(playtime);
            }

            case 4 -> {
                System.out.println("Enter a minimum playtime (in minutes)");
                int playtime = userInput.nextInt();
                videos.filterOnMinPlaytime(playtime);
            }

            case 5 -> {
                System.out.println("Enter a rating from the following list:");
                System.out.println("""
                G: General Audiences
                    All ages admitted.
                PG: Parental Guidance Suggested
                    Some material may not be suitable for children.\s
                PG_13: Parents Strongly Cautioned
                    Some material may be inappropriate for children under 13.\s
                R: Restricted
                    Under 17 requires accompanying parent or adult guardian.
                NC_17: Adults Only
                    No one 17 and under admitted. Clearly adult. Children are not admitted.""");
                Rating rating = Rating.valueOf(userInput.nextLine());
                videos.filterOnRating(rating);
            }

            case 6 -> videos = EntertainmentCollection.copy(videosCopy);
            default -> System.out.println("implementing");
        }
    }

    /**
     * Prints menu of the app
     */
    private static void printMenu() {
        System.out.println(
                """
                Please make your choice:\s
                1 –    Show all items that meet all criteria.
                2 –    Filter items by genre.
                3 –    Filter items by maximum playtime.
                4 –    Filter items by minimum playtime.
                5 -    Filter items by content rating.
                6 –    Reset all criteria.
                7 –    Quit the application."""
        );
    }
}