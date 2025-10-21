import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class UnitCard extends Card implements Serializable {
    private int atk;
    private int def;

    /**
     * Instantiates a new unitcard object
     * @param rarity rarity of card
     * @param name name of card
     * @param energy energy
     * @param atk attack
     * @param def defense
     */
    public UnitCard(Rarity rarity, String name, int energy, int atk, int def) {
        super(rarity, name, energy, Type.Unit);
        this.atk = atk;
        this.def = def;
    }

    /**
     * Empty constructor for the serializable to work
     */
    public UnitCard() {
        super();
    }


    /**
     * Reads a new unitcard
     * @param rarity rarity
     * @param name nanr
     * @param energy energy
     * @param scanner scanner containing rest of info
     * @return the card object
     */
    public static Card readUnitCard(Rarity rarity, String name, int energy, Scanner scanner) {
        int atk = Integer.parseInt(scanner.next().split(" ")[0]);
        int def = Integer.parseInt(scanner.next().split(" ")[0]);
        return new UnitCard(rarity, name, energy, atk, def);
    }

    /**
     * To String of the unitcard
     * @return the string of a unit card
     */
    @Override
    public String toString() {
        return super.toString() +"\t\t"+ atk + " Attack - " + def + " Defence";
    }

    /**
     * Equals method for this class
     * @param o object to be compared with
     * @return true if objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UnitCard unitCard = (UnitCard) o;
        return atk == unitCard.atk && def == unitCard.def;
    }

    /**
     * Hashcode method for this class
     * @return the hash of this class object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), atk, def);
    }
}
