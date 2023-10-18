package login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import chat.ChatPage;

public class LoginPage {

    public static JFrame createLoginPage() {

        JFrame primeiraJanela = new JFrame("Primeira Janela");

        JLabel label = new JLabel("Por favor, informe seu nome:");
        label.setBounds(20, 20, 200, 30);

        JTextField textField = new JTextField();
        textField.setBounds(20, 50, 200, 30);

        JButton button = new JButton("Enviar");
        button.setBounds(20, 90, 200, 30);

        button.addActionListener(e -> {
            String nome = textField.getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(primeiraJanela, "Nome obrigatório!");
            } else {
                JOptionPane.showMessageDialog(primeiraJanela, "Bem-vindo, " + nome + "!");
                primeiraJanela.dispose();
                ChatPage.createChatPage();
            }
        });

        primeiraJanela.add(label);
        primeiraJanela.add(textField);
        primeiraJanela.add(button);

        primeiraJanela.setLayout(null);
        primeiraJanela.setSize(250, 170);
        primeiraJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        primeiraJanela.setLocationRelativeTo(null);
        primeiraJanela.setVisible(true);

        return primeiraJanela;
    }
}
