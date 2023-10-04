import java.net.Socket;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class RunClient {
    BufferedReader inSock;
    BufferedReader inKey;
    PrintWriter out;
    Socket s;

    public static void main(String args[]) {
        RunClient rs = new RunClient();
        rs.startClient(args[0], Integer.parseInt(args[1]));
    }

    public void startClient(String host, int port) {
        try {
            s = new Socket(host, port);
            ClientThread ct = new ClientThread(s);
            ct.setup();
            ct.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
