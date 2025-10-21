public class Message {
    private String receiver;
    private String content;
    private int timestamp;
    public Message(String receiver, String content, int timestamp) {
        this.receiver = receiver;
        this.content = content;
        this.timestamp = timestamp;
    }
    public String getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
