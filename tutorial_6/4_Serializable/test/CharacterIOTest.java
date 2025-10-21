import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterIOTest {

    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character("Test Character");
        character.levelUp();
        character.levelUp();
        character.addExperience(20.5);
        character.getPlayerSecret(); // Make sure this character has a player secret
    }

    @Test
    void testCharacterReadAndWrite() {
        /*
         * We use a ByteArrayOutputStream and ByteArrayInputStream to store the Object data in a byte[].
         * This way we do not have to use files.
         */

        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(byteArrayStream)) {
            output.writeObject(character);
        } catch (IOException e) {
            fail("Something went wrong when writing");
        }

        Character result = null;
        try (ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(byteArrayStream.toByteArray()))) {
            result = (Character) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            fail("Something went wrong when reading");
        }

        assertEquals(character, result);
    }

    @Test
    void testCharacterDoesNotSaveSecret() {
        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(byteArrayStream)) {
            output.writeObject(character);
        } catch (IOException e) {
            fail("Something went wrong when writing");
        }

        Character result = null;
        try (ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(byteArrayStream.toByteArray()))) {
            result = (Character) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            fail("Something went wrong when reading");
        }

        assertNotEquals(character.getPlayerSecret(), result.getPlayerSecret());
    }

}
