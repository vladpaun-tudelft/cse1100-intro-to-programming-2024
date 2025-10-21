import java.io.File;
import java.io.FileNotFoundException;
import java.lang.foreign.AddressLayout;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * Runs the Spoitfy application
     * @param args no CLI args expected
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Spotify spotify = readFile(userInput);

        int option;
        do {
            printMenu();
            option = userInput.nextInt();
            executeOption(option, userInput, spotify);
        } while (option != 5);
    }

    /**
     * Method to read in a new Spotify from file
     * @param userInput scanner to select inFile
     * @return a  new Spotify object
     */
    private static Spotify readFile(Scanner userInput) {

        System.out.println("Select a file to read from: ");

        String filePath = userInput.nextLine();
        try {
            Scanner inFile = new Scanner(new File(filePath));
            inFile.useDelimiter("CDS|\nADDS");
            return Spotify.readSpotify(inFile.next(), inFile.next());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void executeOption(int option, Scanner userInput, Spotify spotify) {
        switch (option) {
            case 1 -> printSpotify(spotify);
            case 2 -> addNewCD(userInput, spotify);
            case 3 -> play();
            case 4 -> shuffle();
        }

    }

    private static void shuffle() {
    }

    private static void play() {
        
    }

    private static void addNewCD(Scanner userInput, Spotify spotify) {
        System.out.println("Let's start adding a new CD");
        spotify.addAlbum(Album.readUserAlbum(userInput));
        
    }

    private static void printSpotify(Spotify spotify) {
        for (Album album : spotify.getAlbums().getAlbums()) {
            for (int i = 0; i < album.size(); i++) {
                System.out.println(album.getSongString(i));
                System.out.print("Next add: ");
                System.out.println(spotify.getAds().getAdString(i % spotify.getAds().size()));
            }

        }
        
    }


    private static void printMenu() {
        System.out.println(
                """
                        1 - Show the current playlist
                        2 – Add a new CD including songs
                        3 – Play
                        4 – Shuffle
                        5 – Stop the program\s""");
    }
}