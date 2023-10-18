package api.message;

public class PublicMessage extends Message {
    private String from;
    private String content;

    public PublicMessage(String from, String content) {
        super(MessageType.PUBLIC_MESSAGE);
        this.from = from;
        this.content = content;
    }

    @Override
    public String getMessageDetails() {
        return "from=" + from + ";content=" + content;
    }
}