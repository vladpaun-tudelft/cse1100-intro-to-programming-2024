import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class WeaponCard extends Card  implements Serializable {
    private int durabilty;

    /**
     * Empty constructor for serializable
     */
    public WeaponCard() {
    }


    /**
     * Instantiates a new weapom card object
     * @param rarity rarity
     * @param name name
     * @param energy energy
     * @param durabilty durability
     */
    public WeaponCard(Rarity rarity, String name, int energy, int durabilty) {
        super(rarity, name, energy, Type.Weapon);
        this.durabilty = durabilty;
    }

    /**
     * Reads a new unitcard
     * @param rarity rarity
     * @param name nanr
     * @param energy energy
     * @param scanner scanner containing rest of info
     * @return the card object
     */
    public static Card readWeaponCard(Rarity rarity, String name, int energy, Scanner scanner) {
        int durability = Integer.parseInt(scanner.next().split(" ")[0]);
        return new WeaponCard(rarity, name, energy, durability);
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
        WeaponCard that = (WeaponCard) o;
        return durabilty == that.durabilty;
    }

    /**
     * ToString of a weaponcard
     * @return the string of a weapon card
     */
    @Override
    public String toString() {
        return super.toString()  +"\t\t"+ durabilty + " Durability.";
    }

    /**
     * Hashcode method for this class
     * @return the hash of this class object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), durabilty);
    }
}
