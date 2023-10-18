package api.message;

import java.util.List;

public class GetUsersMessage extends Message {
    private List<String> usernames;

    public GetUsersMessage(List<String> usernames) {
        super(MessageType.GET_USERS);
        this.usernames = usernames;
    }

    @Override
    public String getMessageDetails() {
        return "usernames=" + String.join(",", usernames);
    }
}