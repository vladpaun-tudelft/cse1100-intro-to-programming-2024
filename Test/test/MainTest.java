import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Message msg1 = new Message("Thomas", "Hi Thomas", 123);
    private Message msg2 = new Message("Andy", "Hi Andy", 124);

    @Test
    public void testingTest() throws IOException {
        Message message = new Message("vlad", "vlad is cool", 45);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(10000);

        Main.encodeMessage(outputStream, message);
        Message message2 = Main.decodeMessage(new ByteArrayInputStream(outputStream.toByteArray()));

        assertEquals(message.getReceiver(), message2.getReceiver());
        assertEquals(message.getContent(), message2.getContent());
        assertEquals(message.getTimestamp(), message2.getTimestamp());
    }

    @Test
    public void fileTestingTest() throws IOException {
        Message message = new Message("vlad", "vlad is cool", 45);
        FileOutputStream outputStream = new FileOutputStream("resources/test.txt");

        Main.encodeMessage(outputStream, message);
        Message message2 = Main.decodeMessage(new FileInputStream("resources/test.txt"));

        assertEquals(message.getReceiver(), message2.getReceiver());
        assertEquals(message.getContent(), message2.getContent());
        assertEquals(message.getTimestamp(), message2.getTimestamp());
    }

    @Test
    public void encodeDecode() {
        ByteArrayOutputStream ostream1 = new ByteArrayOutputStream();
        Main.encodeMessage(ostream1, msg1);
        assertEquals(msg1, Main.decodeMessage(new ByteArrayInputStream(ostream1.toByteArray())));

        ByteArrayOutputStream ostream2 = new ByteArrayOutputStream();
        Main.encodeMessage(ostream2, msg2);
        assertEquals(msg2, Main.decodeMessage(new ByteArrayInputStream(ostream2.toByteArray())));
    }
}