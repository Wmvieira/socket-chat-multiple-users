package message;

import java.util.Arrays;
import java.util.List;

public class Message {
    private MessageType messageType;

    public Message(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String toMessageString() {
        return messageType + ";" + getMessageDetails();
    }

    public String getMessageDetails() {
        return "";
    }

    public static Message fromString(String messageString) {
        String[] parts = messageString.split(";");
        MessageType messageType = MessageType.valueOf(parts[0]);

        switch (messageType) {
            case PUBLIC_MESSAGE:
                String from = getValue(parts[1]);
                String content = getValue(parts[2]);
                return new PublicMessage(from, content);
            case PRIVATE_MESSAGE:
                String fromPrivate = getValue(parts[1]);
                String to = getValue(parts[2]);
                String privateContent = getValue(parts[3]);
                return new PrivateMessage(fromPrivate, to, privateContent);
            case LOGIN:
                String username = getValue(parts[1]);
                return new LoginMessage(username);
            case GET_USERS:
                String usersString = getValue(parts[1]);
                List<String> usernames = Arrays.asList(usersString.split(","));
                return new GetUsersMessage(usernames);
            default:
                throw new IllegalArgumentException("Tipo de mensagem inválido: " + messageType);
        }
    }

    private static String getValue(String input) {
        String[] keyValue = input.split("=");
        if (keyValue.length == 2) {
            return keyValue[1];
        } else {
            throw new IllegalArgumentException("Formato de mensagem inválido: " + input);
        }
    }
}