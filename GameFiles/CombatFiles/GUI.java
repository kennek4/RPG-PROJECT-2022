package CombatFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

public class GUI {

    // LEFT SIDE TOP HALF VARIABLES
    JFrame window;
    JPanel playerInfoBox;
    JPanel pTopHalfPanel;
    JPanel playerPortrait;
    JLabel gunName;
    JPanel gunIMG;
    JProgressBar healthBar;

    // LEFT SIDE BOTTOM HALF VARIABLES
    JPanel pBotHalfPanel;
    JButton abilityButton;
    JPanel abilityBox1;
    JPanel abilityBox2;
    JPanel abilityBox3;
    JPanel abilityBox4;
    JPanel abilityBox5;
    JPanel abilityBox6;

    // RIGHT SIDE
    JPanel environmentInfoBox;
    JPanel envInfoBoxImg;
    JPanel envTopHalf;
    JPanel actionPointBox;
    JLabel actionPointText;

    JPanel enemyBox;
    JPanel enemy1;
    JPanel enemy2;
    JPanel enemy3;

    JLabel label;

    TitledBorder tBorder;
    GridLayout grid;
    CombatEncounter combatEncounter;

    public GUI(CombatEncounter combatEncounter) {

        // The combat system logic
        this.combatEncounter = combatEncounter;

        window = new JFrame("Test");
        window.setPreferredSize(new Dimension(1600, 900));
        window.setSize(1600, 900);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        GridBagConstraints c = new GridBagConstraints();
        window.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;

        /**
         * Panel for the Left Side of the GUI
         */
        playerInfoBox = new JPanel();
        playerInfoBox.setLayout(new GridBagLayout());
        playerInfoBox.setBackground(Color.BLUE);
        playerInfoBox.setPreferredSize(new Dimension(500, 800));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 15, 10, 15);
        window.add(playerInfoBox, c);

        // Left side top half
        pTopHalfPanel = new JPanel();
        pTopHalfPanel.setLayout(new GridBagLayout());
        pTopHalfPanel.setPreferredSize(new Dimension(475, 300));
        c.insets = new Insets(0, 5, 0, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 2;
        playerInfoBox.add(pTopHalfPanel, c);

        // Player portrait - left side top half
        playerPortrait = new JPanel();
        playerPortrait.setPreferredSize(new Dimension(200, 200));
        playerPortrait.setBackground(Color.LIGHT_GRAY);
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.insets = new Insets(5, 0, 10, 20);
        pTopHalfPanel.add(playerPortrait, c);

        gunName = new JLabel("AK-47");
        gunName.setVerticalAlignment(JLabel.BOTTOM);
        gunName.setHorizontalAlignment(JLabel.CENTER);
        gunName.setPreferredSize(new Dimension(150, 20));
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 0);

        pTopHalfPanel.add(gunName, c);

        gunIMG = new JPanel();
        gunIMG.setBackground(Color.DARK_GRAY);
        gunIMG.setPreferredSize(new Dimension(125, 150));
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        pTopHalfPanel.add(gunIMG, c);

        healthBar = new JProgressBar();
        healthBar.setMaximum(100);
        healthBar.setValue(combatEncounter.player.hp);
        healthBar.setForeground(Color.GREEN);
        healthBar.setBackground(Color.RED);
        healthBar.setPreferredSize(new Dimension(healthBar.getWidth() + 15, 25));
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 3;
        pTopHalfPanel.add(healthBar, c);

        // Left side bottom half
        pBotHalfPanel = new JPanel();
        pBotHalfPanel.setBackground(Color.WHITE);
        pBotHalfPanel.setLayout(new GridLayout(0, 2, 10, 10));
        pBotHalfPanel.setPreferredSize(new Dimension(475, 450));
        c.insets = new Insets(10, 5, 0, 5);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        playerInfoBox.add(pBotHalfPanel, c);

        /**
         * INITIALIZING ALL THE ABILITY BOXES
         */
        abilityBox1 = new JPanel();
        abilityBox1.setBackground(Color.CYAN);
        abilityBox1.setLayout(new GridBagLayout());
        abilityButton = new JButton("1");
        abilityButton.addActionListener(a -> {
            combatEncounter.usePlayerAbility(1);
        });
        abilityButton.setPreferredSize(new Dimension(200, 100));
        abilityBox1.add(abilityButton);
        pBotHalfPanel.add(abilityBox1);

        abilityBox2 = new JPanel();
        abilityBox2.setBackground(Color.CYAN);
        abilityBox2.setLayout(new GridBagLayout());
        abilityButton = new JButton("2");
        abilityButton.addActionListener(a -> {
            combatEncounter.usePlayerAbility(2);
        });
        abilityButton.setPreferredSize(new Dimension(200, 100));
        abilityBox2.add(abilityButton);
        pBotHalfPanel.add(abilityBox2);

        abilityBox3 = new JPanel();
        abilityBox3.setBackground(Color.CYAN);
        abilityButton = new JButton("3");
        abilityButton.addActionListener(a -> {
            combatEncounter.usePlayerAbility(3);
        });
        abilityButton.setPreferredSize(new Dimension(200, 100));
        abilityBox3.add(abilityButton);
        pBotHalfPanel.add(abilityBox3);

        abilityBox4 = new JPanel();
        abilityBox4.setBackground(Color.CYAN);
        abilityButton = new JButton("4");
        abilityButton.addActionListener(a -> {
            combatEncounter.usePlayerAbility(4);
        });
        abilityButton.setPreferredSize(new Dimension(200, 100));
        abilityBox4.add(abilityButton);
        pBotHalfPanel.add(abilityBox4);

        abilityBox5 = new JPanel();
        abilityBox5.setBackground(Color.CYAN);
        abilityButton = new JButton("5");
        abilityButton.addActionListener(a -> {
            combatEncounter.usePlayerAbility(5);
        });

        abilityButton.setPreferredSize(new Dimension(200, 100));
        abilityBox5.add(abilityButton);
        pBotHalfPanel.add(abilityBox5);

        abilityBox6 = new JPanel();
        abilityBox6.setBackground(Color.CYAN);
        abilityButton = new JButton("6");
        abilityButton.addActionListener(a -> {
            combatEncounter.usePlayerAbility(6);
        });
        abilityButton.setPreferredSize(new Dimension(200, 100));
        abilityBox6.add(abilityButton);
        pBotHalfPanel.add(abilityBox6);

        /**
         * Panel for the Right Side of the GUI
         */
        environmentInfoBox = new JPanel();
        environmentInfoBox.setBackground(Color.BLACK);
        environmentInfoBox.setLayout(new GridBagLayout());
        environmentInfoBox.setPreferredSize(new Dimension(1000, 800));
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.insets = new Insets(10, 15, 10, 15);
        window.add(environmentInfoBox, c);

        // BACKGROUND IMG
        envInfoBoxImg = new JPanel();
        envInfoBoxImg.setLayout(new GridBagLayout());
        envInfoBoxImg.setPreferredSize(new Dimension(900, 700));
        envInfoBoxImg.setBackground(Color.PINK);
        // c.gridx = 1;
        // c.gridy = 1;
        // c.gridheight = 3;
        // c.gridwidth = 3;
        c.insets = new Insets(10, 10, 10, 10);
        environmentInfoBox.add(envInfoBoxImg);

        c.insets = new Insets(15, 15, 15, 15);

        actionPointBox = new JPanel();
        actionPointBox.setPreferredSize(new Dimension(150, 150));
        actionPointBox.setBackground(Color.RED);
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        envInfoBoxImg.add(actionPointBox, c);

        actionPointText = new JLabel("3");
        actionPointText.setPreferredSize(new Dimension(150, 150));
        actionPointText.setBackground(Color.CYAN);
        c.gridx = 1;
        envInfoBoxImg.add(actionPointText, c);

        enemyBox = new JPanel();
        enemyBox.setLayout(new GridBagLayout());
        enemyBox.setPreferredSize(new Dimension(800, 300));
        enemyBox.setBackground(Color.GREEN);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 3;
        envInfoBoxImg.add(enemyBox, c);

        enemy2 = new JPanel();
        enemy2.setPreferredSize(new Dimension(200, 200));
        enemy2.setBackground(Color.ORANGE);
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        enemyBox.add(enemy2, c);

        if (combatEncounter.enemy2 != null) {
            label = new JLabel("2");
            enemy2.add(label);
        }

        enemy3 = new JPanel();
        enemy3.setPreferredSize(new Dimension(200, 200));
        enemy3.setBackground(Color.ORANGE);
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        enemyBox.add(enemy3, c);

        if (combatEncounter.enemy3 != null) {
            label = new JLabel("3");
            enemy3.add(label);
        }

        enemy1 = new JPanel();
        enemy1.setPreferredSize(new Dimension(200, 200));
        enemy1.setBackground(Color.ORANGE);
        c.insets = new Insets(15, 50, 15, 50);
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        enemyBox.add(enemy1, c);

        label = new JLabel("1");
        enemy1.add(label);

        window.pack();
        window.setVisible(true);
    }

    public void modifyHealthBar(int val) {
        healthBar.setValue(healthBar.getValue() - val);
    }

}
