
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class UserCollection implements Serializable {
    private CardCollection collection;
    private int gold;
    private List<Card> ownedCards;
    private int packsOpened;

    /**
     * ToString of the user collection
     * @return the string of a user collection
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("You Have ").append(gold).append(" gold and own ")
                .append(ownedCards.size()).append(" cards.\n\n");
        for (Card card : ownedCards) {
            sb.append(card).append("\n");
        }
        return sb.toString();
    }

    /**
     * Makes a new user collection of cards
     * @param collection the set of cards
     */
    public UserCollection(CardCollection collection) {
        this.collection = collection;
        ownedCards = new ArrayList<Card>();
        gold = 0;
        packsOpened = 0;
    }

    /**
     * Adds a card to the given collection
     * @param card card to be added
     * @return the string confirming the card addition
     */
    public String addcard(Card card) {
        if (ownedCards.contains(card)) {
            int addedGold = switch (card.getRarity()) {
                case Rarity.NORMAL -> 1;
                case Rarity.RARE -> 2;
                case Rarity.EPIC -> 4;
                case Rarity.LEGENDARY -> 10;
            };
            gold += addedGold;
            return "\tCard:\n\t" +card+ "\n\tAlready owned. Received "
                    + addedGold + " gold instead.\n";
        } else {
            ownedCards.add(card);
            return "\tCard added:\n\t" + card + "\n";
        }
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
        UserCollection that = (UserCollection) o;
        return gold == that.gold && Objects.equals(collection, that.collection)
                && Objects.equals(ownedCards, that.ownedCards);
    }

    /**
     * Hashcode method for this class
     * @return the hash of this class object
     */
    @Override
    public int hashCode() {
        return Objects.hash(collection, gold, ownedCards);
    }

    /**
     * Method to write the data of the game to a file
     * @return a string saying if it was succesfull
     */
    public String out() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(
                            "C:\\Users\\vladp\\IdeaProjects\\" +
                                    "Practice exams\\EndTerm_January_2022\\resources\\log.data")
            );
            oos.writeObject(this);
            return ("Succesfull save.");
        } catch (IOException e) {
            return ("Could not save.");
        }
    }

    /**
     * reads in the state from the file
     * @return the string saying if it ws succesfull or not
     */
    public String in() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("C:\\Users\\vladp\\IdeaProjects\\" +
                            "Practice exams\\EndTerm_January_2022\\resources\\log.data")
            );
            UserCollection temp = (UserCollection) ois.readObject();
            this.collection = temp.collection;
            this.gold = temp.gold;
            this.ownedCards = temp.ownedCards;
            return ("Succesfully loaded save.");
        } catch (IOException | ClassNotFoundException e) {
            return ("Could not retrieve save.");
        }
    }

    /**
     * Method to open a new pack
     * @return the string showing the opeenned pack
     */
    public String openPack() {
        packsOpened++;
        List<Card> pack = getNewPack();
        StringBuilder sb = new StringBuilder("Opening new pack:\n");

        for (Card card : pack) {
            sb.append(addcard(card));
        }

        return sb.toString();
    }

    /**
     * Method to generate a pack to be opened
     * @return the pack of cards
     */
    private List<Card> getNewPack() {
        List<Card> pack = new ArrayList<>();
        Random rand  = new Random();

        int packSize = 5;

        Map.Entry<List<Card>, Integer> packAndSize = makeUsersNotAnnoyed(pack, packSize);
        pack = packAndSize.getKey();
        packSize = packAndSize.getValue();

        for (int i = 0; i < packSize; i++) {
            double chance = rand.nextDouble() * 100;

            Rarity rarity;
            if (chance <= 2) {
                rarity = Rarity.LEGENDARY;
            } else if (chance <= 10) {
                rarity = Rarity.EPIC;
            } else if (chance <= 26) {
                rarity = Rarity.RARE;
            } else {
                rarity = Rarity.NORMAL;
            }

            List<Card> cardsByRarity = collection.getCards()
                    .stream().filter(card -> card.getRarity().equals(rarity))
                    .collect(Collectors.toList());

            if (!cardsByRarity.isEmpty()) {
                pack.add(
                        cardsByRarity.get(rand.nextInt(cardsByRarity.size()))
                );
            }
        }

        return pack;
    }

    private Map.Entry<List<Card>, Integer> makeUsersNotAnnoyed(List<Card> pack, int packSize) {
        Random rand = new Random();
        if (packsOpened % 50 == 0) {
            packSize--;
            List<Card> legendaryCards = collection.getCards()
                    .stream()
                    .filter(card -> card.getRarity().equals(Rarity.LEGENDARY))
                    .collect(Collectors.toList());
            if (!legendaryCards.isEmpty()) {
                pack.add(legendaryCards.get(rand.nextInt(legendaryCards.size())));
            }
        }
        return Map.entry(pack, packSize);
    }
}
