package chat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;

public class ChatPage {

    public static JFrame createChatPage() {
        JFrame segundaJanela = new JFrame("Segunda Tela");
        segundaJanela.setSize(1200, 800);
        segundaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        segundaJanela.add(panel);

        JTextField listaUsuarios = new JTextField();
        JScrollPane spListaUsuarios = new JScrollPane(listaUsuarios, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JTextField mensagem = new JTextField();
        JTextArea mensagens = new JTextArea();
        mensagens.setEditable(false);
        JScrollPane spMensagens = new JScrollPane(mensagens, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        spListaUsuarios.setBounds(10, 10, 200, 600);
        mensagem.setBounds(10, 625, 985, 120);
        spMensagens.setBounds(225, 10, 950, 600);

        JButton enviarMensagem = new JButton("Enviar Mensagem");
        enviarMensagem.setBounds(1010, 625, 165, 120);
        // Adiciona os componentes ao painel
        panel.add(spListaUsuarios);
        panel.add(spMensagens);
        panel.add(mensagem);
        panel.add(enviarMensagem);

        enviarMensagem.addActionListener((ActionEvent e) -> {
            String mensagemEnviada = mensagem.getText();
            if (!mensagemEnviada.isEmpty()) {

            }
        });

        segundaJanela.setLocationRelativeTo(null);

        segundaJanela.setVisible(true);

        return segundaJanela;
    }
}
