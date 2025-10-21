import java.io.*;
import java.util.*;

public class MechGame implements Serializable {
    private List<Mech> mechs;
    private List<Equipment> equipments;
    private int fightsWon;
    private Player player;

    /**
     * Gets the state of the game from a file
     * @return the saved game state
     */
    public static MechGame in() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(
                    new File(
                            "C:\\Users\\vladp\\IdeaProjects\\Practice exams" +
                                    "\\EndTerm_2022\\resources\\log.data"));
            ObjectInputStream ois = new ObjectInputStream(fis);

            return (MechGame) ois.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Gets the player of the game
     * @return the [player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Instantiates a new mech game object
     */
    public MechGame() {
        mechs = new ArrayList<>();
        equipments = new ArrayList<>();
        fightsWon = 0;
        player = new Player();
    }

    /**
     * Method to read a new game from a given file
     * @param filePath the filepath
     * @return a new game object
     */
    public static MechGame readGame(String filePath) {
        MechGame game = new MechGame();
        try (Scanner inFile = new Scanner(new File(filePath))){
            int mechs = Integer.parseInt(inFile.nextLine());

            inFile.useDelimiter("MECH|(?=\n\\d+\n)");
            for (int i = 0; i < mechs; i++) {
                game.addMech(Mech.readMech(inFile.next()));
            }

            inFile.nextLine();
            int equipments = Integer.parseInt(inFile.nextLine());

            inFile.useDelimiter("EQUIPMENT");
            for (int i = 0; i < equipments; i++) {
                game.addEquipment(Equipment.readEquipment(inFile.next()));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return game;
    }

    /**
     * adds a mech to the game
     * @param mech mech object
     */
    public void addMech(Mech mech) {
        mechs.add(mech);
    }

    /**
     * adds an equipment to the game
     * @param equipment equipment object
     */
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    /**
     * Gives a string representation of all mechs in the game
     * @return the string of echs
     */
    public String mechsString() {
        StringBuilder sb = new StringBuilder("There are ")
                .append(mechs.size()).append(" mech(s) in the game.\n");
        for (Mech mech : mechs) {
            sb.append(mech.toString());
            sb.append("\n");
        }
        return sb.toString();
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
        MechGame mechGame = (MechGame) o;
        return fightsWon == mechGame.fightsWon
                && Objects.equals(mechs, mechGame.mechs)
                && Objects.equals(equipments, mechGame.equipments)
                && Objects.equals(player, mechGame.player);
    }

    /**
     * Hashcode method for objects of this class
     * @return the hashcode of such object
     */
    @Override
    public int hashCode() {
        return Objects.hash(mechs, equipments, fightsWon, player);
    }

    /**
     * ets a new player - method used for testing only
     * @param player a new player object
     */
    public void setPlayer(Player player) {
        this.player = player;
    }


    /**
     * Sets the fights won
     * Method used only for testing
     * @param fightsWon the no of fights won
     */
    public void setFightsWon(int fightsWon) {
        this.fightsWon = fightsWon;
    }

    /**
     * Method to simulate a fight.
     */
    public void fight() {
        int playerHealth = player.getStats().getHp();
        Mech mech = getCurrentMech();
        int mechHealth = mech.getStats().getHp();

        if (playerStarts(mech)) {
            playerAttack(mech);
        }
        do {
            mechAttack(mech);
            playerAttack(mech);
        } while ((mech.getStats().getHp() > 0) && (player.getStats().getHp() > 0));

        mech.setHP(mechHealth);

        if (player.getStats().getHp() > 0) {
            player.setHP(playerHealth);
            Equipment equipment = getLosersEquipment(mech);

            fightsWon++;

            System.out.println("You fight against a "
                    + mech.getName()
                    +" and win! You get a "
                    + equipment
                    + ".\n" +
                    "You have won "
                    + fightsWon
                    +" battles. ");
        }
        else {
            fightsWon = 0;
            player = new Player();


            System.out.println("You fight against a "
                    + mech.getName()
                    +" and lose!");
            System.out.println("Game over. You lost. Start over.");
        }
    }


    /**
     * Puts the losers ewuipment into the players appropriate slot
     * @param mech the mech that was defeated
     * @return the equipment
     */
    private Equipment getLosersEquipment(Mech mech) {
        int id = mech.getLootdropID();
        Equipment wonEquipment = null;
        for (Equipment equipment : equipments) {
            if (equipment.getId() == id) {
                wonEquipment = equipment;
                break;
            }
        }
        assert wonEquipment != null;
        if (wonEquipment.getType().equals(EquipmentType.Offensive)) {
            player.setOffensiveEquipment(wonEquipment);
        }
        else {
            player.setDefensiveEquipment(wonEquipment);
        }
        return wonEquipment;
    }

    /**
     * Method to simulate a mech attack
     * @param mech the m,ech to fight
     */
    private void mechAttack(Mech mech) {
        int baseAttack = getBaseAttack(mech);
        List<String> mechStrengths = mech.getStrengths();
        List<String> playerWeaknesses = player.getWeaknesses();
        for(String mechStrength : mechStrengths) {
            if (playerWeaknesses.contains(mechStrength)) {
                baseAttack *= 2;
                break;
            }
        }

        int defenseBonus = player.getDefensiveEquipment()!=null?
                player.getDefensiveEquipment().getDefBonus():
                0;
        int finalAttack = baseAttack - player.getStats().getDef() - defenseBonus;
        if (finalAttack > 0) {
            player.setHP(player.getStats().getHp() - finalAttack);
        }
    }

    /**
     * Method to simulate a player attack
     * @param mech the mech to fight
     */
    private void playerAttack(Mech mech) {
        int baseAttack = getBaseAttack(player);
        List<String> playerStrengths = player.getStrengths();
        List<String> mechWeaknesses = mech.getWeaknesses();
        for(String playerStrength : playerStrengths) {
            if (mechWeaknesses.contains(playerStrength)) {
                baseAttack *= 2;
                break;
            }
        }

        int finalAttack = baseAttack - mech.getStats().getDef();
        if (finalAttack > 0) {
            mech.setHP(mech.getStats().getHp() - finalAttack);
        }
    }

    /**
     * Method to get the attack strength if the player attacks
     * @param player the player
     * @return the attack int
     */
    private int getBaseAttack(Player player) {
        int atkBase = player.getStats().getAtk();
        Equipment offensiveEquipment = player.getOffensiveEquipment();
        if (offensiveEquipment != null) {
            atkBase += offensiveEquipment.getAtkBonus();
        }
        return atkBase;
    }

    /**
     * Method to get the attack strength if the mech attacks
     * @param mech the mech
     * @return the attack int
     */
    private int getBaseAttack(Mech mech) {
        return mech.getStats().getAtk();
    }

    /**
     * Determines who starts the fight
     * @param mech or the mech
     * @return true if the player starts
     */
    private boolean playerStarts(Mech mech) {
        return (player.getStats().getSpd() >= mech.getStats().getSpd());
    }

    /**
     * gets the current mech that we are fighting based on the number of games played
     * @return
     */
    private Mech getCurrentMech() {
        return mechs.get(fightsWon % (mechs.size()));
    }

    /**
     * Method to log the current state of the game
     */
    public void log() {
        try {
            FileOutputStream fos = new FileOutputStream(
                    new File(
                    "C:\\Users\\vladp\\IdeaProjects\\Practice exams" +
                            "\\EndTerm_2022\\resources\\log.data"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
