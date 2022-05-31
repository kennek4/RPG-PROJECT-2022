package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Color;

/**
 * The class for the Game Over Screen
 */
public class GameOverScreen {

    // Colours
    final Color WHITE = new Color(240, 246, 240);
    final Color BLACK = new Color(34, 35, 35);

    JFrame window;
    JLabel label;
    JPanel gameOverPanel;
    JButton quitButton;

    Scanner reader;
    BufferedImage myPicture;

    /**
     * Creates the Game Over Screen
     */
    public GameOverScreen() {

        window = new JFrame("GAME OVER");
        window.setSize(new Dimension(1600, 900));
        window.setPreferredSize(new Dimension(1600, 900));
        window.setBackground(BLACK);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();

        gameOverPanel = new JPanel();
        gameOverPanel.setLayout(new GridBagLayout());
        gameOverPanel.setBackground(BLACK);
        window.add(gameOverPanel);

        try {
            myPicture = ImageIO.read(new File("GameFiles\\UI\\gameover_screen_image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        c.gridx = 1;
        c.gridy = 0;
        gameOverPanel.add(picLabel, c);

        quitButton = new JButton("QUIT TO DESKTOP");
        quitButton.addActionListener(a -> {
            window.dispose();
        });
        c.gridx = 1;
        c.gridy = 2;
        gameOverPanel.add(quitButton, c);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
