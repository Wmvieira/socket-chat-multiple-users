package api.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import api.message.*;
import client.Client;

public class ClientThread implements Runnable {
    private Socket s;
    private Thread t;
    private PrintWriter out;
    private BufferedReader inSock;
    private BufferedReader inKey;

    public ClientThread(Socket s) {
        this.s = s;
        connect();
    }

    public void sendMessage(Message message) {
        out.println(message.toMessageString());
        out.flush();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = Message.fromString(inSock.readLine());
                System.out.println(msg.toMessageString());

                if(msg instanceof GetUsersMessage ) {
                    Client.names = ((GetUsersMessage) msg).usernames;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        setup();
        start();
    }

    private void setup() {
        try {
            inKey = new BufferedReader(new InputStreamReader(System.in));
            inSock = new BufferedReader(new InputStreamReader(s.getInputStream()));
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
