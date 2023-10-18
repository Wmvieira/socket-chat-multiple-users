import java.net.ServerSocket;
import java.net.Socket;

public class RunServer {
    public static void main(String args[]) {
        RunServer rs = new RunServer();
        rs.startServer();
    }

    public void startServer() {
        try {
            ServerSocket ss = new ServerSocket(8084);
            while (true) {
                Socket s = ss.accept();
                new User(new ServerThread(s));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
