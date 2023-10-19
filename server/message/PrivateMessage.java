package message;

public class PrivateMessage extends Message {
    public String from;
    public String to;
    public String content;

    public PrivateMessage(String from, String to, String content) {
        super(MessageType.PRIVATE_MESSAGE);
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getMessageDetails() {
        return "from=" + from + ";to=" + to + ";content=" + content;
    }
}