import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserCollectionTest {

    @Test
    void testEquals() {
        String filePath = "C:\\Users\\vladp\\IdeaProjects\\" +
                "Practice exams\\EndTerm_January_2022\\resources\\playingcards.txt";
        CardCollection cardCollection = CardCollection.read(filePath);
        UserCollection userCollection = new UserCollection(cardCollection);

        CardCollection cardCollection2 = CardCollection.read(filePath);
        UserCollection userCollection2 = new UserCollection(cardCollection2);

        assertEquals(userCollection, userCollection2);
    }

    @Test
    void testHashCode() {
        String filePath = "C:\\Users\\vladp\\IdeaProjects\\" +
                "Practice exams\\EndTerm_January_2022\\resources\\playingcards.txt";
        CardCollection cardCollection = CardCollection.read(filePath);
        UserCollection userCollection = new UserCollection(cardCollection);

        CardCollection cardCollection2 = CardCollection.read(filePath);
        UserCollection userCollection2 = new UserCollection(cardCollection2);

        assertEquals(userCollection.hashCode(), userCollection2.hashCode());
    }

    @Test
    void outIn() {
        String filePath = "C:\\Users\\vladp\\IdeaProjects\\" +
                "Practice exams\\EndTerm_January_2022\\resources\\playingcards.txt";
        CardCollection cardCollection = CardCollection.read(filePath);
        UserCollection userCollection = new UserCollection(cardCollection);

        userCollection.out();
        userCollection.in();
        assertEquals(userCollection, userCollection);
    }

    @Test
    void openPack() {
        String filePath = "C:\\Users\\vladp\\IdeaProjects\\" +
                "Practice exams\\EndTerm_January_2022\\resources\\playingcards.txt";
        CardCollection cardCollection = CardCollection.read(filePath);
        UserCollection userCollection = new UserCollection(cardCollection);

        userCollection.openPack();
        assertEquals(userCollection, userCollection);
    }
}