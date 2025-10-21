import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public abstract class Card implements Serializable {
    private Rarity rarity;
    private String name;
    private int energy;
    private Type type;

    /**
     * Instantiates a new instance of a card
     * @param rarity rarity of card
     * @param name name of card
     * @param energy energy of card
     * @param type type of card
     */
    public Card(Rarity rarity, String name, int energy, Type type) {
        this.rarity = rarity;
        this.name = name;
        this.energy = energy;
        this.type = type;
    }

    /**
     * Reads a card from a string
     * @param cardString cardstring
     * @return a new card
     */
    public static Card read(String cardString) {
        Scanner scanner = new Scanner(cardString);
        Type type = Type.valueOf(scanner.nextLine().split(" ")[0]);
        Rarity rarity = Rarity.valueOf(scanner.nextLine());
        scanner.useDelimiter("\n| - ");
        String name = scanner.next();
        int energy = Integer.parseInt(scanner.next().split(" ")[0]);
        return switch (type) {
            case Type.Unit -> UnitCard.readUnitCard(rarity, name, energy, scanner);
            case Type.Leader -> LeaderCard.readLeaderCard(rarity, name, energy, scanner);
            case Type.Weapon -> WeaponCard.readWeaponCard(rarity, name, energy, scanner);
            case Type.Spell -> SpellCard.readSpellCard(rarity, name, energy, scanner);
        };
    }

    /**
     * ToString method of the card class
     * @return rhe sttring of a card
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(": ").append(name)
                .append(" (").append(rarity).append("), costs ")
                .append(energy).append(" Energy.\n");
        return sb.toString();
    }

    /**
     * Empty constructor for the serializable to work
     */
    public Card() {
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
        Card card = (Card) o;
        return energy == card.energy && rarity == card.rarity
                && Objects.equals(name, card.name) && type == card.type;
    }

    /**
     * Hashcode method for this class
     * @return the hash of this class object
     */
    @Override
    public int hashCode() {
        return Objects.hash(rarity, name, energy, type);
    }

    /**
     * Returns the rarity of a card
     * @return the raraity of the card
     */
    public Rarity getRarity() {
        return rarity;
    }
}
