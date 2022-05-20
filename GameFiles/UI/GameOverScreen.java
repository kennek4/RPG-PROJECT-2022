package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

public class GameOverScreen {

    JFrame window;
    JLabel label;
    JTextPane textPane;
    JPanel panel;
    JButton mainMenuButton;
    JButton quitButton;

    public GameOverScreen() {
        window = new JFrame("GAME OVER");
        window.setLayout(new GridBagLayout());
        window.setPreferredSize(new Dimension(1600, 900));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();
        // panel = new JPanel();
        // c.gridx = 1;
        // c.gridy = 0;
        // window.add(panel, c);

        textPane = new JTextPane();
        textPane.setText("MISSION FAILED \n COURIER K.I.A \n PACKAGE LOST");
        c.gridx = 1;
        c.gridy = 0;
        window.add(textPane, c);

        mainMenuButton = new JButton("MAIN MENU");
        mainMenuButton.addActionListener(a -> {
            // Insert function call to go to main menu here
        });
        c.gridx = 1;
        c.gridy = 1;
        window.add(mainMenuButton, c);

        quitButton = new JButton("QUIT TO DESKTOP");
        quitButton.addActionListener(a -> {
            window.dispose();
        });
        c.gridx = 1;
        c.gridy = 2;
        window.add(quitButton, c);

        window.pack();
        window.setVisible(true);
    }

    public static void main(String[] args) {
        GameOverScreen gos = new GameOverScreen();
    }
}
