import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CardCollection implements Serializable {
    private List<Card> cards;

    /**
     * Gets the list of cards
     * @return rthe cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Makes a new non-empty card collection
     * @param cards the list of cards
     */
    public CardCollection(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Makes a new empty collection
     */
    public CardCollection() {
        cards = new ArrayList<Card>();
    }

    /**
     * Method to give a cardcollection from filepath
     * @param filePath file[ppath of the file
     * @return a new cardcollection
     */
    public static CardCollection read(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter("\n(?=.+Card)");

            CardCollection cardCollection = new CardCollection();
            while (scanner.hasNext()) {
                cardCollection.addCard(Card.read(scanner.next()));
            }
            return cardCollection;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ToString of the card collection
     * @return the string of teh card collection
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("There are ")
                .append(cards.size())
                .append(" card(s) in the collection");

        for (int i = 0; i < cards.size(); i++) {
            sb.append("\n\t")
                    .append(i+1).append(". ")
                    .append(cards.get(i));
        }

        return sb.toString();
    }

    /**
     * Adds a card to rthe collection
     * @param card card to be added
     */
    public void addCard (Card card) {
        cards.add(card);
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
        CardCollection that = (CardCollection) o;
        return Objects.equals(cards, that.cards);
    }

    /**
     * Hashcode method for this class
     * @return the hash of this class object
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(cards);
    }
}
