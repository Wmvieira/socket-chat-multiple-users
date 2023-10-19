import client.Client;
import login.LoginPage;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        showLoginPage();
    }

    private static void showLoginPage() {
        LoginPage loginPage = new LoginPage();
        JFrame loginWindow = loginPage.createLoginPage();

        loginWindow.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                new Client(loginPage.enteredName);
            }
        });
    }
}
