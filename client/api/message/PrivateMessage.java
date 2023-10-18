package api.message;

public class PrivateMessage extends Message {
    private String from;
    private String to;
    private String content;

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