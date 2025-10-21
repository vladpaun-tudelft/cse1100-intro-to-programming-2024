import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HomeApplication {

    private static Scanner userInput;
    private static List<ApplianceGroup> groups;

    public static void main(String[] args) {
        userInput = new Scanner(System.in);
        groups = new ArrayList<>();

        int option;
        do {
        showMenu();
        option = userInput.nextInt();
        executeOption(option);
        } while (option != 7);
    }

    private static void showMenu() {
        System.out.println("Please select an option:");
        System.out.println("  1 - Toggle the lights in a group");
        System.out.println("  2 - Play a song in a group");
        System.out.println("  3 - Set the light colour in a group");
        System.out.println("  4 - Add a group");
        System.out.println("  5 - Add an appliance to a group");
        System.out.println("  6 - Show the status of all groups");
        System.out.println("  7 - Quit the application");
    }

    private static void executeOption(int option) {
        String name;
        ApplianceGroup found = null;
        switch (option) {
            case 1:
                System.out.print("Group name: ");
                name = userInput.next();
                for (ApplianceGroup group : groups) {
                    if (group.getName().equals(name)) {
                        found = group;
                        break;
                    }
                }
                found.toggleLights();
                break;
            case 2:
                System.out.print("Group name: ");
                name = userInput.next();
                for (ApplianceGroup group : groups) {
                    if (group.getName().equals(name)) {
                        found = group;
                        break;
                    }
                }
                System.out.print("Song name: ");
                String song = userInput.next();
                found.playSong(song);
                break;
            case 3:
                System.out.print("Group name: ");
                name = userInput.next();
                for (ApplianceGroup group : groups) {
                    if (group.getName().equals(name)) {
                        found = group;
                        break;
                    }
                }
                System.out.print("Red: ");
                int red = userInput.nextInt();
                System.out.print("Green: ");
                int green = userInput.nextInt();
                System.out.print("Blue: ");
                int blue = userInput.nextInt();
                found.setLightColour(red, green, blue);
                break;
            case 4:
                System.out.print("Group name: ");
                groups.add(new ApplianceGroup(userInput.next()));
                break;
            case 5:
                System.out.print("Group name: ");
                name = userInput.next();
                for (ApplianceGroup group : groups) {
                    if (group.getName().equals(name)) {
                        found = group;
                        break;
                    }
                }
                System.out.print("Appliance type (Lamp, Speaker, Blinds): ");
                String type = userInput.next();
                System.out.print("Appliance name: ");
                String applianceName = userInput.next();
                switch (type) {
                    case "Lamp":
                        found.addAppliance(new Lamp(applianceName, false, 255, 255, 255, 1.0, false));
                        break;
                    case "Speaker":
                        found.addAppliance(new Speaker(applianceName, false, 1.0, null));
                        break;
                    case "Blinds":
                        found.addAppliance(new Blinds(applianceName, false));
                        break;
                }
                break;
            case 6:
                for (ApplianceGroup group : groups) {
                    System.out.println(group.getStatus());
                }
                break;
        }
    }

}
