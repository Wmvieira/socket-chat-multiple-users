package api.message;

public class LoginMessage extends Message {
    private String username;

    public LoginMessage(String username) {
        super(MessageType.LOGIN);
        this.username = username;
    }

    @Override
    public String getMessageDetails() {
        return "username=" + username;
    }
}