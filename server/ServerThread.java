import message.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread implements Runnable {
    Socket s;
    Thread t;
    PrintWriter out;
    BufferedReader in;

    public ServerThread(Socket s) {
        this.s = s;
        connect();
    }

    public void AllUsers() {
        List<String> userNames = new ArrayList<>();
        for (User user : User.connectedUsers) {
            userNames.add(user.nickName);
        }
        sendMsgs(new GetUsersMessage(userNames).toMessageString());
    }

    public void sendMsgs(String msg) {
        out.println(msg);

        out.flush();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = Message.fromString(in.readLine());
                System.out.println(msg.toMessageString());

                if(msg instanceof LoginMessage) {
                    for (User user : User.connectedUsers) {
                        if (user.serverThread.equals(this)) {
                            user.nickName = ((LoginMessage)msg).username;
                            break;
                        }
                    }
                    for (User user : User.connectedUsers) {
                        user.serverThread.AllUsers();
                    }
                }

                if(msg instanceof PublicMessage) {
                    for (User user : User.connectedUsers) {
                        if(!user.nickName.equals(((PublicMessage)msg).from)) {
                            user.serverThread.sendMsgs(msg.toMessageString());
                        }
                    }
                }

                if(msg instanceof PrivateMessage) {
                    for (User user : User.connectedUsers) {
                        if(user.nickName.equals(((PrivateMessage)msg).to)) {
                            user.serverThread.sendMsgs(msg.toMessageString());
                        }
                    }
                }

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
