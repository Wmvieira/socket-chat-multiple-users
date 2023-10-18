import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {
    Socket s;
    Thread t;
    PrintWriter out;
    BufferedReader in;

    public ServerThread(Socket s) {
        this.s = s;
        connect();
    }

    public void sendMsgs(String msg) {
        out.println(msg);
        out.flush();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = in.readLine();
                System.out.println(msg);
                sendMsgs(msg);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void connect() {
        setup();
        start();
    }

    private void setup() {
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() {
        t = new Thread(this);
        t.start();
    }
}
