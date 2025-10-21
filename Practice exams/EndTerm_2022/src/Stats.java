import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Stats implements Serializable {
    private int atk;
    private int def;
    private int hp;
    private int spd;

    /**
     * Instantiates a new stat object
     * @param atk attack points
     * @param def defense points
     * @param hp healtp points
     * @param spd speed points
     */
    public Stats(int atk, int def, int hp, int spd) {
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.spd = spd;
    }

    /**
     * Method to set hp of stats
     * @param hp new hp of stats
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Method to read stats from a string
     * @param atkString atkString
     * @param defString defString
     * @param hpString hpString
     * @param spdString spdString
     * @return a Stats object
     */
    public static Stats readStats(String atkString, String defString,
                                  String hpString, String spdString) {
        Scanner scanner = new Scanner(atkString);
        scanner.useDelimiter("\\D");
        int atk = scanner.nextInt();

        scanner = new Scanner(defString);
        scanner.useDelimiter("\\D");
        int def = scanner.nextInt();

        scanner = new Scanner(hpString);
        scanner.useDelimiter("\\D");
        int hp = scanner.nextInt();

        scanner = new Scanner(spdString);
        scanner.useDelimiter("\\D");
        int spd = scanner.nextInt();

        return new Stats(atk, def, hp, spd);
    }

    /**
     * Gets the attack points
     * @return attack points
     */
    public int getAtk() {return atk;}

    /**
     * Gets the defense points
     * @return defense points
     */
    public int getDef() {return def;}

    /**
     * Gets the hp points
     * @return hp points
     */
    public int getHp() {return hp;}

    /**
     * Gets the speed points
     * @return speed points
     */
    public int getSpd() {return spd;}

    /**
     * To string of the stats object
     * @return the string o stats
     */
    @Override
    public String toString() {
        return "It has "
            + atk + " attack, "
            + def + " defence, "
            + hp + " health, and "
            + spd + " speed.";
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
        Stats stats = (Stats) o;
        return atk == stats.atk && def == stats.def && hp == stats.hp && spd == stats.spd;
    }

    /**
     * Hashcode method for objects of this class
     * @return the hashcode of such object
     */
    @Override
    public int hashCode() {
        return Objects.hash(atk, def, hp, spd);
    }
}
