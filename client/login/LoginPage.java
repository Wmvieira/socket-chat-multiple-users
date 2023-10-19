package login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class LoginPage {
    public String enteredName;

    public JFrame createLoginPage() {

        JFrame window = new JFrame("Login");

        JLabel label = new JLabel("Nickname:");
        label.setBounds(20, 20, 200, 30);

        JTextField textField = new JTextField();
        textField.setBounds(20, 50, 200, 30);

        JButton button = new JButton("Send");
        button.setBounds(20, 90, 200, 30);

        button.addActionListener(e -> {
            enteredName = textField.getText();
            if (enteredName.isEmpty()) {
                JOptionPane.showMessageDialog(window, "Nickname is required");
                return;
            }
            JOptionPane.showMessageDialog(window, "Welcome, " + enteredName + "!");
            window.dispose();
        });

        window.add(label);
        window.add(textField);
        window.add(button);

        window.setLayout(null);
        window.setSize(250, 170);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        return window;
    }
}
