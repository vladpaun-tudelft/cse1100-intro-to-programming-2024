import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class LeaderCard extends Card implements Serializable {
    private int atk;
    private int def;
    private String specialEffect;

    /**
     * Empty constructor for the serializable to work
     */
    public LeaderCard() {
    }

    /**
     * Instantiates a new LeaderCard
     * @param rarity rarity of card
     * @param name name of card
     * @param energy energy of card
     * @param atk attack of card
     * @param def defense
     * @param specialEffect special effect
     */
    public LeaderCard(Rarity rarity, String name, int energy,
                      int atk, int def, String specialEffect) {
        super(rarity, name, energy, Type.Leader);
        this.atk = atk;
        this.def = def;
        this.specialEffect = specialEffect;
    }

    /**
     * Reads a new unitcard
     * @param rarity rarity
     * @param name nanr
     * @param energy energy
     * @param scanner scanner containing rest of info
     * @return the card object
     */
    public static Card readLeaderCard(Rarity rarity, String name, int energy, Scanner scanner) {
        int atk = Integer.parseInt(scanner.next().split(" ")[0]);
        int def = Integer.parseInt(scanner.next().split(" ")[0]);
        scanner.nextLine();
        String specialEffect = scanner.nextLine();
        return new LeaderCard(rarity, name, energy, atk, def, specialEffect);
    }

    /**
     * To String of the leaderCard
     * @return the string of a leaderCard
     */
    @Override
    public String toString() {
        return super.toString() +"\t\t"+ atk + " Attack - " + def + " Defence\n\t\t"
                + specialEffect;
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
        LeaderCard that = (LeaderCard) o;
        return atk == that.atk && def == that.def
                && Objects.equals(specialEffect, that.specialEffect);
    }

    /**
     * Hashcode method for this class
     * @return the hash of this class object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), atk, def, specialEffect);
    }
}
