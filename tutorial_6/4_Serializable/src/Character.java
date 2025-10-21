import java.io.Serializable;
import java.util.Objects;

public class Character implements Serializable {

    private final String name;
    private int level;
    private double xpPoints;

    private transient String playerSecret = null;

    /**
     * Constructs a new character.
     *
     * @param name The name of the character
     */
    public Character(String name) {
        this.name = name;
        this.level = 0;
        this.xpPoints = .0;
    }

    /**
     * Checks if the character is equal to the given object.
     *
     * @param other The object to check for equality
     * @return True iff other is a character with identical name, level, xpPoints and playerSecret
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        Character that = (Character) other;
        return Objects.equals(this.name, that.name) && this.level == that.level && this.xpPoints == that.xpPoints;
    }

    /**
     * Converts the character to a human readable string.
     *
     * @return The string representation of this character
     */
    @Override
    public String toString() {
        return "Character(name=" + name + ", level=" + level + ", xp=" + xpPoints + ", playerSecret=" + playerSecret + ")";
    }

    /**
     * Gets the name.
     *
     * @return This character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the level.
     *
     * @return This character's level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the xp points.
     *
     * @return The amount of xp this character has
     */
    public double getXpPoints() {
        return xpPoints;
    }

    /**
     * Gets the player secret, or generates one if none exists already.
     *
     * @return The player secret
     */
    public String getPlayerSecret() {
        if (playerSecret == null) {
            playerSecret = generateSecret();
        }
        return playerSecret;
    }

    /**
     * Increases this character's level by 1
     */
    public void levelUp() {
        level++;
    }

    /**
     * Adds a certain amount of experience to this character.
     *
     * @param amount The amount of experience to add
     */
    public void addExperience(double amount) {
        xpPoints += amount;
    }

    private String generateSecret() {
        return Integer.toString((int) (Math.random() * 1000000));
    }

}
