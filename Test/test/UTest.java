import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;

class UTest {

    @Test
    public void testingTest() throws IOException{
        Message message = new Message("vlad", "vlad is cool", 45);

        Main.encodeMessage(new ByteArrayOutputStream(10000), message);
        Message message2 = Main.decodeMessage(new ByteArrayInputStream(new byte[10000]));

        assertEquals(message.getReceiver(), message2.getReceiver());
        assertEquals(message.getContent(), message2.getContent());
        assertEquals(message.getTimestamp(), message2.getTimestamp());
    }

}