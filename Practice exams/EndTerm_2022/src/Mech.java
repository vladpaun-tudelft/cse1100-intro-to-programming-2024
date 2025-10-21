import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Mech implements Serializable {
    private String name;
    private String category;
    private int lootdropID;
    private Stats stats;
    private List<String> strengths;
    private List<String> weaknesses;

    /**
     * Constructor to instantiate a new mech
     * @param name name
     * @param category category string
     * @param lootdropID id of loot
     * @param stats stats object
     * @param strengths list of strengths
     * @param weaknesses list pf weaknesses
     */
    public Mech(String name, String category, int lootdropID,
                Stats stats, List<String> strengths, List<String> weaknesses) {
        this.name = name;
        this.category = category;
        this.lootdropID = lootdropID;
        this.stats = stats;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    /**
     * Method to read a mech from a given string
     * @param mechString the mech string
     * @return a mech object
     */
    public static Mech readMech(String mechString) {
        Scanner mechScanner = new Scanner(mechString);
        mechScanner.useDelimiter(" - |\n");

        String name = mechScanner.next();
        String category = mechScanner.next();
        int lootdropID = mechScanner.nextInt();

        Stats stats = Stats.readStats(mechScanner.next(),mechScanner.next()
                ,mechScanner.next(),mechScanner.next());

        List<String> strengths = new ArrayList<>();
        List<String> weaknesses = new ArrayList<>();

        while (mechScanner.hasNext()) {
            String[] attributeParts = mechScanner.next().split(" ");
            if (attributeParts[0].equals("strength:")) { strengths.add(attributeParts[1]); }
            else if (attributeParts[0].equals("weakness:")) { weaknesses.add(attributeParts[1]); }
        }

        return new Mech(name, category, lootdropID, stats, strengths, weaknesses);
    }

    /**
     * ToString method of the mech class
     * @return the string of a mech
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(name).append(" (Category ").append(category).append(")\n");
        sb.append("\t").append(stats).append("\n");
        sb.append("\t").append("strength(s): ");
        if (strengths.size() == 0) sb.append("none, ");
        else for (String strength : strengths) {
                sb.append(strength).append(", ");
            }
        sb.append("weakness(es): ");
        if (weaknesses.isEmpty()) sb.append("none");
        else for (int i = 0; i < weaknesses.size(); i++) {
                sb.append(weaknesses.get(i));
                if (i < weaknesses.size() - 1) sb.append(", ");
            }
        sb.append(".\n");

        return sb.toString();
    }

    /**
     * Gets the stats
     * @return the stats
     */
    public Stats getStats() {
        return stats;
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
        Mech mech = (Mech) o;
        return lootdropID == mech.lootdropID
                && Objects.equals(name, mech.name)
                && Objects.equals(category, mech.category)
                && Objects.equals(stats, mech.stats)
                && Objects.equals(strengths, mech.strengths)
                && Objects.equals(weaknesses, mech.weaknesses);
    }

    /**
     * Hashcode method for objects of this class
     * @return the hashcode of such object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, category, lootdropID, stats, strengths, weaknesses);
    }

    /**
     * Gets the name of the mech
     * @return the name of the mech
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the id of the lootdrop
     * @return the id of the lootdrop
     */
    public int getLootdropID() {
        return lootdropID;
    }

    /**
     * Method to get the weaknesses of the mech
     * @return the weaknesses of the mech
     */
    public List<String> getWeaknesses() {
        return weaknesses;
    }

    /**
     * Sets the hp of the mech
     * @param hp new hp for the mech
     */
    public void setHP(int hp) {
        this.stats.setHp(hp);
    }

    /**
     * Method to get the strengths of the mech
     * @return the strengths of the mech
     */
    public List<String> getStrengths() {
        return strengths;
    }
}
