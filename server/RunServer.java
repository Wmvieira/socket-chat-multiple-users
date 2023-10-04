import java.net.ServerSocket;
import java.net.Socket;

public class RunServer {
    public static void main(String args[]){
        RunServer rs = new RunServer();
        rs.startServer();

        new User("A");
        new User("B");
        new User("C");
    }

    public void startServer(){
        try {
            ServerSocket ss = new ServerSocket(8084);
            while(true){
                Socket s = ss.accept();
                ServerThread st = new ServerThread(s);
                st.setup();
                st.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
