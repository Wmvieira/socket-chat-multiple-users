import java.net.Socket;

import login.LoginPage;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class RunClient {
    BufferedReader inSock;
    BufferedReader inKey;
    PrintWriter out;
    Socket s;

    public static void main(String args[]) {
        LoginPage.createLoginPage();

        // RunClient rs = new RunClient();
        // rs.startClient();
    }

    public void startClient() {
        try {
            s = new Socket("localhost", 8084);
            new ClientThread(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
