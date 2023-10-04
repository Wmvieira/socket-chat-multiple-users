import java.util.ArrayList;
import java.util.List;

public class User {
    public String nickName;
    public int id;
    
    private static int curUser = 0; 
    private static List<User> users = new ArrayList<User>();

    public User(String nickName) {
        this.nickName = nickName;
        this.id = newUserId();
        addToList(this);
    }

    private static int newUserId() {
        return curUser +=1;
    }

    private static void addToList(User u) {
        users.add(u);
    }
}
