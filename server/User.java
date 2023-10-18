import java.util.ArrayList;
import java.util.List;

public class User {
    public String nickName;
    public ServerThread serverThread;

    private static List<User> connectedUsers = new ArrayList<User>();

    public User(ServerThread serverThread) {
        this.serverThread = serverThread;
        connectedUsers.add(this);
        System.out.println("Conexões: " + connectedUsers.size());
    }

}
