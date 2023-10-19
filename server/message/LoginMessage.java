package message;

public class LoginMessage extends Message {
    public String username;

    public LoginMessage(String username) {
        super(MessageType.LOGIN);
        this.username = username;
    }

    @Override
    public String getMessageDetails() {
        return "username=" + username;
    }
}