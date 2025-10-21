import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Equipment.
 */
public abstract class Equipment implements Comparable<Equipment> {

    /**
     * Read equipment list.
     *
     * @param equipmentListString the equipment list string
     * @return the list
     */
    public static List<Equipment> readEquipmentList(String equipmentListString) {
        List<Equipment> equipmentList = new ArrayList<>();

        Scanner equipmentListScanner = new Scanner(equipmentListString);
        equipmentListScanner.useDelimiter("; |;");

        while (equipmentListScanner.hasNext()) {
            equipmentList.add(readEquipment(equipmentListScanner.next()));
        }
        return equipmentList;
    }

    private static Equipment readEquipment(String equipmentString) {
        Scanner equipmentScanner = new Scanner(equipmentString);
        equipmentScanner.useDelimiter(", ");
        String equipmentType = equipmentScanner.next();
        String requirements = equipmentScanner.next();

        return switch (equipmentType) {
            case "ConcreteMixer" -> new ConcreteMixer(requirements);
            case "JackHammer" -> new JackHammer(requirements);
            case "Scaffolding" -> new ScaffoldingTower(requirements);
            case "Torch" -> new Torch(requirements);
            default -> null;
        };
    }

    /**
     * Gets user equipment list.
     *
     * @param userInput the user input
     * @return the user equipment list
     */
    public static List<Equipment> getUserEquipmentList(Scanner userInput) {
        List<Equipment> equipmentList = new ArrayList<>();
        System.out.println("Required Equipment:");
        int choice;
        do{
            printEquipmentMenu();
            choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter equipment requirements: ");
                    String requirements = userInput.next();
                    Equipment e = new ConcreteMixer(requirements);
                    equipmentList.add(e);
                    System.out.print("Equipment added. ");
                    break;
                case 2:
                    System.out.print("Enter equipment requirements: ");
                    String requirements2 = userInput.next();
                    Equipment e2 = new JackHammer(requirements2);
                    equipmentList.add(e2);
                    System.out.print("Equipment added. ");
                    break;
                case 3:
                    System.out.print("Enter equipment requirements: ");
                    String requirements3 = userInput.next();
                    Equipment e3 = new ScaffoldingTower(requirements3);
                    equipmentList.add(e3);
                    System.out.print("Equipment added. ");
                    break;
                case 4:
                    System.out.print("Enter equipment requirements: ");
                    String requirements4 = userInput.next();
                    Equipment e4 = new Torch(requirements4);
                    equipmentList.add(e4);
                    System.out.print("Equipment added. ");
                    break;
            }

        } while(choice != 5);

        return equipmentList;
    }

    private static void printEquipmentMenu() {
        System.out.println("Choose equipment type: ");
        System.out.println("1 - ConcreteMixer");
        System.out.println("2 - JackHammer");
        System.out.println("3 - ScaffoldingTower");
        System.out.println("4 - Torch");
        System.out.println("5 - No more equipment needed. ");
    }

    /**
     * Write equipment list.
     *
     * @param requiredEquipment the required equipment
     * @param writer            the writer
     */
    public static void writeEquipmentList(List<Equipment> requiredEquipment, PrintWriter writer) {
        if (requiredEquipment.isEmpty()) {
            writer.println("");
        }
        else {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < requiredEquipment.size(); i++) {
                Equipment equipment = requiredEquipment.get(i);

                result.append(writeEquipment(equipment));

                if (i != requiredEquipment.size() - 1) {
                    result.append("; ");
                } else {
                    result.append(";").append(System.lineSeparator());
                }

            }
            writer.print(result);
        }
    }

    private static String writeEquipment(Equipment equipment) {
        String requirements = equipment.getRequirements();
        if (requirements.isEmpty()) requirements = "None";
        return switch (equipment) {
            case ConcreteMixer concreteMixer ->
                    ("ConcreteMixer, " + requirements);
            case JackHammer jackHammer ->
                    ("JackHammer, " + requirements);
            case ScaffoldingTower scaffoldingTower ->
                    ("Scaffolding, " + requirements);
            case Torch torch ->
                    ("Torch, " + requirements);
            default ->
                null;
        };
    }

    private final String requirements;

    /**
     * Instantiates a new Equipment.
     *
     * @param requirements the requirements
     */
    public Equipment(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Gets requirements.
     *
     * @return the requirements
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Returns a string of the requirements of the equipment
     * @return requirements string
     */
    public String toString() {
        return requirements;
    }

    /**
     * Equals method
     * @param other other equipment object
     * @return true if equal
     */
    public abstract boolean equals(Object other);
}
