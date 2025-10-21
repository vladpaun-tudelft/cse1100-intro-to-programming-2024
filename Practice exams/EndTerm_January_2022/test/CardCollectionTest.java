import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardCollectionTest {
    CardCollection collection;
    Card card1, card2, card3, card4, card5, card6;

    @BeforeEach
    void setUp() {
        collection = new CardCollection();

        card1 = new UnitCard(
                Rarity.NORMAL,
                "Knight of the Legion",
                4,4,5
        );
        card2 = new SpellCard(
                Rarity.RARE,
                "Frost Ray",
                3,
                "Frost",
                "Freeze all enemy units, rendering them unable to attack for 1 turn."
        );
        card3 = new WeaponCard(
                Rarity.RARE,
                "Warhammer",
                3,2
        );
        card4 = new LeaderCard(
                Rarity.LEGENDARY,
                "The Ice Queen",
                8,7,6,
                "Upon playing, deal 2 frost damage to all enemies and freeze them."
        );

        collection.addCard(card1);
        collection.addCard(card2);
        collection.addCard(card3);
        collection.addCard(card4);
    }

    @Test
    void read() {
        String filePath = "C:\\Users\\vladp\\IdeaProjects\\" +
                "Practice exams\\EndTerm_January_2022\\resources\\playingcards_Testing.txt";
        CardCollection collectionTest = CardCollection.read(filePath);

        assertEquals(List.of(card1,card2,card3,card4), collectionTest.getCards());

        assertEquals(collectionTest, collection);

        assertEquals(collectionTest.toString(), collection.toString());


    }
}