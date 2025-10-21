import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    CardCollection collection;

    @BeforeEach
    void setUp() {
        collection = new CardCollection();

        UnitCard card1 = new UnitCard(
                Rarity.NORMAL,
                "Knight of the Legion",
                4,4,5
        );
        SpellCard card2 = new SpellCard(
                Rarity.RARE,
                "Frost Ray",
                3,
                "Frost",
                "Freeze all enemy units, rendering them unable to attack for 1 turn."
        );
        WeaponCard card3 = new WeaponCard(
                Rarity.RARE,
                "Warhammer",
                3,2
        );
        LeaderCard card4 = new LeaderCard(
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
    void testEquals() {
        assertEquals(collection.getCards().get(3),
                new LeaderCard(
                        Rarity.LEGENDARY,
                        "The Ice Queen",
                        8,7,6,
                        "Upon playing, deal 2 frost damage to all enemies and freeze them."
                )
        );

        assertEquals(collection.getCards().get(0),
                new UnitCard(
                        Rarity.NORMAL,
                        "Knight of the Legion",
                        4,4,5
                )
        );
        assertEquals(collection.getCards().get(1),
                new SpellCard(
                        Rarity.RARE,
                        "Frost Ray",
                        3,
                        "Frost",
                        "Freeze all enemy units, rendering them unable to attack for 1 turn."
                )
        );

        assertEquals(collection.getCards().get(2),
                new WeaponCard(
                        Rarity.RARE,
                        "Warhammer",
                        3,2
                )
        );
    }

}