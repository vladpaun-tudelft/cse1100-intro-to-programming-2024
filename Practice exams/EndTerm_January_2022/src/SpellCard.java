import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class SpellCard extends Card implements Serializable {
    private String spellType;
    private String description;

    /**
     * Empty constructor for the serializable to work
     */
    public SpellCard() {
    }


    /**
     * Makes a new Object of Spellcard
     * @param rarity rarity
     * @param name name
     * @param energy energy
     * @param spellType spellType
     * @param description description of spell
     */
    public SpellCard(Rarity rarity, String name, int energy, String spellType, String description) {
        super(rarity, name, energy, Type.Spell);
        this.spellType = spellType;
        this.description = description;
    }

    /**
     * Reads a new unitcard
     * @param rarity rarity
     * @param name nanr
     * @param energy energy
     * @param scanner scanner containing rest of info
     * @return the card object
     */
    public static Card readSpellCard(Rarity rarity, String name, int energy, Scanner scanner) {
        String spellType = scanner.next().strip();
        String description = scanner.next().strip();
        return new SpellCard(rarity, name, energy, spellType, description);
    }

    /**
     * ToString of a spellcard
     * @return the string of a spell card
     */
    @Override
    public String toString() {
        return super.toString()  +"\t\t"+ spellType + " - " + description + "";
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
        SpellCard spellCard = (SpellCard) o;
        return Objects.equals(spellType, spellCard.spellType)
                && Objects.equals(description, spellCard.description);
    }

    /**
     * Hashcode method for this class
     * @return the hash of this class object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), spellType, description);
    }
}
