package client;

import api.client.ClientThread;
import api.message.LoginMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.Socket;

public class Client {
    ClientThread clientThread;
    String name;

    public Client(String name) {
        this.name = name;
        startClient();
    }

    public void Login() {
        clientThread.sendMessage(new LoginMessage(name));
    }

    public void startClient() {
        try {
            Socket s = new Socket("localhost", 8084);
            this.clientThread = new ClientThread(s);
            Login();

            JFrame chatWindow = createChatPage();
            chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JFrame createChatPage() {
        JFrame window = new JFrame("Second Screen");
        window.setSize(1200, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        window.add(panel);

        JTextField userList = new JTextField();
        JScrollPane userListScrollPane = new JScrollPane(userList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JTextField messageField = new JTextField();
        JTextArea messagesArea = new JTextArea();
        messagesArea.setEditable(false);
        JScrollPane messagesScrollPane = new JScrollPane(messagesArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        userListScrollPane.setBounds(10, 10, 200, 600);
        messageField.setBounds(10, 625, 985, 120);
        messagesScrollPane.setBounds(225, 10, 950, 600);

        JButton sendMessageButton = new JButton("Send Message");
        sendMessageButton.setBounds(1010, 625, 165, 120);
        // Add components to the panel
        panel.add(userListScrollPane);
        panel.add(messagesScrollPane);
        panel.add(messageField);
        panel.add(sendMessageButton);

        sendMessageButton.addActionListener((ActionEvent e) -> {
            String sentMessage = messageField.getText();
            if (!sentMessage.isEmpty()) {
                // Handle sending the message here
            }
        });

        window.setLocationRelativeTo(null);

        window.setVisible(true);

        return window;
    }
}
