import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player implements Serializable {
    private Stats stats;
    private Equipment offensiveEquipment;
    private Equipment defensiveEquipment;

    /**
     * Gets the offensive equipment of the player
     * @return offensive equipment of the player, or null if not set
     */
    public Equipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    /**
     * Gets the defensive equipment of the player
     * @return defensive equipment of the player, or null if not set
     */
    public Equipment getDefensiveEquipment() {
        return defensiveEquipment;
    }

    /**
     * Gets the stats
     * @return the stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * Instantiates a new player object.
     * Always starts with base stats
     */
    public Player() {
        this.stats = new Stats(3, 1, 30, 3);
        this.offensiveEquipment = null; // No equipment by default
        this.defensiveEquipment = null;
    }

    /**
     * Equals method for objects of this class
     * @param o object to be compared with
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(stats, player.stats) &&
                Objects.equals(offensiveEquipment, player.offensiveEquipment) &&
                Objects.equals(defensiveEquipment, player.defensiveEquipment);
    }

    /**
     * Tostring of a player
     * @return the string of a player
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The current player stats are: \n\t");
        sb.append(stats);

        if (offensiveEquipment != null) {
            sb.append("\n\tOffensive equipment: ").append(offensiveEquipment);
        } else {
            sb.append("\n\tNo offensive equipment.");
        }

        if (defensiveEquipment != null) {
            sb.append("\n\tDefensive equipment: ").append(defensiveEquipment);
        } else {
            sb.append("\n\tNo defensive equipment.");
        }

        return sb.toString();
    }

    /**
     * Hashcode method for objects of this class
     * @return the hashcode of such object
     */
    @Override
    public int hashCode() {
        return Objects.hash(stats, offensiveEquipment, defensiveEquipment);
    }

    /**
     * Method to get the strengths of the player
     * @return the strengths of the player
     */
    public List<String> getStrengths() {
        List<String> strengths = new ArrayList<>();
        if (offensiveEquipment != null) {
            strengths.addAll(offensiveEquipment.getStrengths());
        }
        if (defensiveEquipment != null) {
            strengths.addAll(defensiveEquipment.getStrengths());
        }
        return strengths;
    }

    /**
     * Method to get the weaknesses of the player
     * @return the weaknesses of the player
     */
    public List<String> getWeaknesses() {
        List<String> weaknesses = new ArrayList<>();
        if (offensiveEquipment != null) {
            weaknesses.addAll(offensiveEquipment.getWeaknesses());
        }
        if (defensiveEquipment != null) {
            weaknesses.addAll(defensiveEquipment.getWeaknesses());
        }
        return weaknesses;
    }

    /**
     * Sets the new offensive equipment
     * @param offensiveEquipment new equipment, or null to remove it
     */
    public void setOffensiveEquipment(Equipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    /**
     * Sets the new defensive equipment
     * @param defensiveEquipment new equipment, or null to remove it
     */
    public void setDefensiveEquipment(Equipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    /**
     * Sets the HP of the player
     * @param hp new HP value
     */
    public void setHP(int hp) {
        stats.setHp(hp);
    }
}
