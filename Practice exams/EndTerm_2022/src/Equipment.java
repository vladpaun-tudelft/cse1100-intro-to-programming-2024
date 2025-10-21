import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Equipment implements Serializable {
    private String name;
    private EquipmentType type;
    private int id;
    private int atkBonus;
    private int defBonus;
    private List<String> strengths;
    private List<String> weaknesses;

    /**
     * Returns the name of the equipment
     * @return the bname of the equippment
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets the equipment type
     * @return the equ[iment type
     */
    public EquipmentType getType() {
        return type;
    }

    /**
     * Gets the id of the equipmenbt
     * @return the id of the equi[ment
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the strengths of the equipment
     * @return the strengths of the equipment
     */
    public List<String> getStrengths() {
        return strengths;
    }

    /**
     * Gets the weaknesses of the equipment
     * @return the weaknesses of the equipment
     */
    public List<String> getWeaknesses() {
        return weaknesses;
    }

    /**
     * Gets the attack bonus of the equipment
     * @return the attack bonus of the equipment
     */
    public int getAtkBonus() {
        return atkBonus;
    }

    /**
     * Gets the defense bonus of the equipment
     * @return the defense bonus of the equipment
     */
    public int getDefBonus() {
        return defBonus;
    }

    /**
     * Constructor to instantiate a new equipment object
     * @param name name of equipment
     * @param type type of equpiment
     * @param id id of equipment
     * @param bonus bonus stat
     * @param strengths list of strengths it gives
     * @param weaknesses list of weaknesses it gives
     */
    public Equipment(String name, EquipmentType type, int id,
                     int bonus, List<String> strengths, List<String> weaknesses) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.strengths = strengths;
        this.weaknesses = weaknesses;

        if (type.equals(EquipmentType.Offensive)) {
            atkBonus = bonus;
            defBonus = 0;
        } else {
            atkBonus = 0;
            defBonus = bonus;
        }
    }

    /**
     * Method to rwad an equipment froma  string
     * @param equipmentString an equipment string
     * @return an equipment object
     */
    public static Equipment readEquipment(String equipmentString) {
        Scanner scanner = new Scanner(equipmentString);
        Scanner line1Scanner = new Scanner(scanner.nextLine());
        line1Scanner.useDelimiter(" - ");
        String name = line1Scanner.next();
        EquipmentType type1 = EquipmentType.valueOf(line1Scanner.next());
        int id = Integer.parseInt(line1Scanner.next());

        Scanner line2Scanner = new Scanner(scanner.nextLine());
        line2Scanner.useDelimiter("\\D");
        int bonus = Integer.parseInt(line2Scanner.next());

        Scanner line3Scanner = new Scanner(scanner.nextLine());
        line3Scanner.useDelimiter(" - ");

        List<String> strengths = new ArrayList<>();
        List<String> weaknesses = new ArrayList<>();

        while (line3Scanner.hasNext()) {
            String[] attributeParts = line3Scanner.next().split(" ");
            if (attributeParts[0].equals("strength:")) { strengths.add(attributeParts[1]); }
            else if (attributeParts[0].equals("weakness:")) { weaknesses.add(attributeParts[1]); }
        }

        return new Equipment(name, type1, id, bonus, strengths, weaknesses);
    }

    /**
     * Equals method for objects of this class
     * @param o object tp be compared with
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return id == equipment.id
                && atkBonus == equipment.atkBonus
                && defBonus == equipment.defBonus
                && Objects.equals(name, equipment.name)
                && type == equipment.type
                && Objects.equals(strengths, equipment.strengths)
                && Objects.equals(weaknesses, equipment.weaknesses);
    }

    /**
     * Hashcode method for objects of this class
     * @return the hashcode of such object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, type, id, atkBonus, defBonus, strengths, weaknesses);
    }
}
