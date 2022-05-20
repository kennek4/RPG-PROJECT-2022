package CombatFiles;

import java.util.HashMap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * Class responsible for the GUI during combat.
 */
public class CombatUI {

    // COLOURS
    final Color WHITE = new Color(240, 246, 240);
    final Color BLACK = new Color(34, 35, 35);

    // IMAGEs
    final ImageIcon ATK_ICON = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\attack_icon.png");
    final ImageIcon ENEMY = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\enemy_test.png");

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

    JButton abilityButton1;
    JButton abilityButton2;
    JButton abilityButton3;
    JButton abilityButton4;
    JButton abilityButton5;
    JButton abilityButton6;

    // Mapping buttons to a HashMap for easier access
    HashMap<Integer, JButton> abilityButtonID;
    HashMap<Integer, JLabel> abilityLimits;
    HashMap<Integer, JButton> targetButtons;

    JButton targetButton1;
    JButton targetButton2;
    JButton targetButton3;
    boolean toggle;

    JPanel abilityBox1;
    JPanel abilityBox2;
    JPanel abilityBox3;
    JPanel abilityBox4;
    JPanel abilityBox5;
    JPanel abilityBox6;

    JLabel abilityLimit1;
    JLabel abilityLimit2;
    JLabel abilityLimit3;
    JLabel abilityLimit4;
    JLabel abilityLimit5;
    JLabel abilityLimit6;

    // RIGHT SIDE
    JPanel environmentInfoBox;
    JPanel envInfoBoxImg;
    JPanel envTopHalf;
    JPanel actionPointBox;
    JLabel actionPointText;
    JButton endTurnButton;

    // Enemy objects and info text
    JPanel enemyBox;
    JPanel enemy1;
    JPanel enemy2;
    JPanel enemy3;
    JLabel enemyLabel1;
    JLabel enemyLabel2;
    JLabel enemyLabel3;
    JProgressBar enemy1HealthBar;
    JProgressBar enemy2HealthBar;
    JProgressBar enemy3HealthBar;
    JLabel enemy1Intention;
    JLabel enemy2Intention;
    JLabel enemy3Intention;
    JLabel enemy1Image;
    JLabel enemy2Image;
    JLabel enemy3Image;

    JPanel botHalfPanel;
    JLabel label;
    GridLayout grid;
    CombatEncounter combatEncounter;
    Enemy target;

    CombatUI main;

    int playerAbilityNumber;

    /**
     * Combat GUI constructor
     * 
     * @param combatEncounter the CombatEncounter object that is to be used.
     */
    public CombatUI(CombatEncounter combatEncounter) {

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
        abilityButton1 = new JButton(combatEncounter.player.gun.a1.getAbilityName());
        abilityButton1.addActionListener(a -> {
            if (combatEncounter.abilityID.get(1).getCurrentPP() > 0) {
                if (combatEncounter.player.gun.a1.needsTarget() == true) {
                    playerAbilityNumber = 1;
                    targetToggle();
                } else {
                    combatEncounter.usePlayerGunAbility(1);
                }
            }
        });
        abilityButton1.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox1.add(abilityButton1, c);
        abilityLimit1 = new JLabel();
        abilityLimit1.setText(String.format("%d", combatEncounter.abilityID.get(1).getLimit()));
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox1.add(abilityLimit1, c);
        pBotHalfPanel.add(abilityBox1);

        abilityBox2 = new JPanel();
        abilityBox2.setBackground(Color.CYAN);
        abilityBox2.setLayout(new GridBagLayout());
        abilityButton2 = new JButton(combatEncounter.player.gun.a2.getAbilityName());
        abilityButton2.addActionListener(a -> {
            if (combatEncounter.abilityID.get(2).getCurrentPP() > 0) {
                if (combatEncounter.player.gun.a2.needsTarget() == true) {
                    playerAbilityNumber = 2;
                    targetToggle();
                } else {
                    combatEncounter.usePlayerGunAbility(2);
                }
            }
        });
        abilityButton2.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox2.add(abilityButton2, c);
        abilityLimit2 = new JLabel();
        abilityLimit2.setText(String.format("%d", combatEncounter.abilityID.get(2).getLimit()));
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox2.add(abilityLimit2, c);
        pBotHalfPanel.add(abilityBox2);

        abilityBox3 = new JPanel();
        abilityBox3.setBackground(Color.CYAN);
        abilityBox3.setLayout(new GridBagLayout());
        abilityButton3 = new JButton(combatEncounter.player.gun.a3.getAbilityName());
        abilityButton3.addActionListener(a -> {
            if (combatEncounter.abilityID.get(3).getCurrentPP() > 0) {
                if (combatEncounter.player.gun.a3.needsTarget() == true) {
                    playerAbilityNumber = 3;
                    targetToggle();
                } else {
                    combatEncounter.usePlayerGunAbility(3);
                }
            }
        });
        abilityButton3.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox3.add(abilityButton3, c);
        abilityLimit3 = new JLabel();
        abilityLimit3.setText(String.format("%d", combatEncounter.abilityID.get(3).getLimit()));
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox3.add(abilityLimit3, c);
        pBotHalfPanel.add(abilityBox3);

        abilityBox4 = new JPanel();
        abilityBox4.setLayout(new GridBagLayout());
        abilityBox4.setBackground(Color.CYAN);
        abilityButton4 = new JButton(combatEncounter.player.gun.a4.getAbilityName());
        abilityButton4.addActionListener(a -> {
            if (combatEncounter.abilityID.get(4).getCurrentPP() > 0) {
                if (combatEncounter.player.gun.a4.needsTarget() == true) {
                    playerAbilityNumber = 4;
                    targetToggle();
                } else {
                    combatEncounter.usePlayerGunAbility(4);
                }
            }
        });
        abilityButton4.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox4.add(abilityButton4, c);
        abilityLimit4 = new JLabel();
        abilityLimit4.setText(String.format("%d", combatEncounter.abilityID.get(4).getLimit()));
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox4.add(abilityLimit4, c);
        pBotHalfPanel.add(abilityBox4);

        abilityBox5 = new JPanel();
        abilityBox5.setLayout(new GridBagLayout());
        abilityBox5.setBackground(Color.CYAN);
        abilityButton5 = new JButton(combatEncounter.abilityID.get(5).getAbilityName());
        abilityButton5.addActionListener(a -> {
            combatEncounter.useSupportAbility(5);
        });

        abilityButton5.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox5.add(abilityButton5, c);
        abilityLimit5 = new JLabel();
        abilityLimit5.setText(String.format("%d", combatEncounter.abilityID.get(5).getLimit()));
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox5.add(abilityLimit5, c);
        pBotHalfPanel.add(abilityBox5);

        abilityBox6 = new JPanel();
        abilityBox6.setLayout(new GridBagLayout());
        abilityBox6.setBackground(Color.CYAN);
        abilityButton6 = new JButton(combatEncounter.abilityID.get(6).getAbilityName());
        abilityButton6.addActionListener(a -> {
            combatEncounter.useSupportAbility(6);
        });
        abilityButton6.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox6.add(abilityButton6, c);
        abilityLimit6 = new JLabel();
        abilityLimit6.setText(String.format("%d", combatEncounter.abilityID.get(6).getLimit()));
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox6.add(abilityLimit6, c);
        pBotHalfPanel.add(abilityBox6);

        abilityButtonID = new HashMap<>() {
            {
                put(1, abilityButton1);
                put(2, abilityButton2);
                put(3, abilityButton3);
                put(4, abilityButton4);
                put(5, abilityButton5);
                put(6, abilityButton6);
            }
        };

        abilityLimits = new HashMap<>() {
            {
                put(1, abilityLimit1);
                put(2, abilityLimit2);
                put(3, abilityLimit3);
                put(4, abilityLimit4);
                put(5, abilityLimit5);
                put(6, abilityLimit6);
            }
        };

        /**
         * Panel for the Right Side of the GUI
         */
        environmentInfoBox = new JPanel();
        environmentInfoBox.setBackground(BLACK);
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
        envInfoBoxImg.setPreferredSize(new Dimension(975, 775));
        envInfoBoxImg.setBackground(BLACK);
        // c.gridx = 1;
        // c.gridy = 1;
        // c.gridheight = 3;
        // c.gridwidth = 3;
        environmentInfoBox.add(envInfoBoxImg);

        c.insets = new Insets(5, 10, 5, 10);

        actionPointBox = new JPanel();
        actionPointBox.setPreferredSize(new Dimension(250, 150));
        actionPointBox.setBackground(Color.RED);
        actionPointBox.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        envInfoBoxImg.add(actionPointBox, c);

        actionPointText = new JLabel(String.format("%d", combatEncounter.actionPoints));
        actionPointText.setPreferredSize(new Dimension(250, 150));
        actionPointText.setBackground(Color.CYAN);
        c.gridx = 0;
        actionPointBox.add(actionPointText, c);

        endTurnButton = new JButton("END TURN");
        endTurnButton.setPreferredSize(new Dimension(300, 50));
        endTurnButton.addActionListener(a -> {
            combatEncounter.endTurn();
        });
        c.gridx = 2;
        envInfoBoxImg.add(endTurnButton, c);

        enemyBox = new JPanel();
        enemyBox.setLayout(new GridBagLayout());
        enemyBox.setPreferredSize(new Dimension(900, 475));
        enemyBox.setBackground(BLACK);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        envInfoBoxImg.add(enemyBox, c);

        botHalfPanel = new JPanel();
        botHalfPanel.setLayout(new GridBagLayout());
        botHalfPanel.setBackground(BLACK);
        botHalfPanel.setPreferredSize(new Dimension(800, 100));
        c.gridx = 0;
        c.gridy = 2;
        envInfoBoxImg.add(botHalfPanel, c);

        c.fill = GridBagConstraints.HORIZONTAL;

        if (combatEncounter.enemy2 != null) {
            enemy2 = new JPanel();
            enemy2.setPreferredSize(new Dimension(250, 400));
            enemy2.setBackground(BLACK);
            enemy2.setLayout(new GridBagLayout());
            c.gridx = 2;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            enemyBox.add(enemy2, c);

            enemy2Intention = new JLabel(ATK_ICON);
            enemy2Intention.setPreferredSize(new Dimension(32, 32));
            c.insets = new Insets(5, 5, 5, 5);
            c.gridx = 1;
            c.gridy = 0;
            enemy2.add(enemy2Intention, c);

            enemy2Image = new JLabel(ENEMY);
            enemy2Image.setSize(new Dimension(100, 175));
            c.insets = new Insets(5, 5, 5, 5);
            c.gridx = 1;
            c.gridy = 1;
            enemy2.add(enemy2Image, c);

            enemy2HealthBar = new JProgressBar();
            enemy2HealthBar.setPreferredSize(new Dimension(200, 25));
            enemy2HealthBar.setMaximum(combatEncounter.enemy2.hp);
            enemy2HealthBar.setValue(combatEncounter.enemy2.hp);
            enemy2HealthBar.setStringPainted(true);
            c.insets = new Insets(5, 5, 5, 5);
            c.gridx = 1;
            c.gridy = 2;
            enemy2.add(enemy2HealthBar, c);

        }

        if (combatEncounter.enemy3 != null) {
            enemy3 = new JPanel();
            enemy3.setPreferredSize(new Dimension(250, 400));
            enemy3.setLayout(new GridBagLayout());
            enemy3.setBackground(BLACK);
            c.gridx = 0;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            enemyBox.add(enemy3, c);

            enemy3Intention = new JLabel();
            enemy3Intention.setIcon(ATK_ICON);
            enemy3Intention.setPreferredSize(new Dimension(32, 32));
            c.insets = new Insets(5, 5, 10, 5);
            c.gridx = 1;
            c.gridy = 0;
            enemy3.add(enemy3Intention, c);

            enemy3Image = new JLabel(ENEMY);
            enemy3Image.setSize(new Dimension(100, 175));
            c.insets = new Insets(5, 5, 5, 5);
            c.gridx = 1;
            c.gridy = 1;
            enemy3.add(enemy3Image, c);

            enemy3HealthBar = new JProgressBar();
            enemy3HealthBar.setPreferredSize(new Dimension(200, 25));
            enemy3HealthBar.setMaximum(combatEncounter.enemy3.hp);
            enemy3HealthBar.setValue(combatEncounter.enemy3.hp);
            enemy3HealthBar.setStringPainted(true);
            c.insets = new Insets(5, 5, 5, 5);
            c.gridx = 1;
            c.gridy = 2;
            enemy3.add(enemy3HealthBar, c);

        }

        enemy1 = new JPanel();
        enemy1.setPreferredSize(new Dimension(250, 400));
        enemy1.setLayout(new GridBagLayout());
        enemy1.setBackground(BLACK);
        c.insets = new Insets(15, 50, 15, 50);
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        enemyBox.add(enemy1, c);

        enemy1Intention = new JLabel(ATK_ICON);
        enemy1Intention.setText("3x3");
        enemy1Intention.setPreferredSize(new Dimension(32, 32));
        enemy1Intention.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        enemy1Intention.setVisible(true);
        c.insets = new Insets(5, 5, 10, 5);
        c.gridx = 1;
        c.gridy = 0;
        enemy1.add(enemy1Intention, c);

        enemy1Image = new JLabel(ENEMY);
        enemy1Image.setPreferredSize(new Dimension(100, 175));
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 1;
        c.gridy = 1;
        enemy1.add(enemy1Image, c);

        enemy1HealthBar = new JProgressBar();
        enemy1HealthBar.setPreferredSize(new Dimension(200, 25));
        enemy1HealthBar.setMaximum(combatEncounter.enemy1.hp);
        enemy1HealthBar.setValue(combatEncounter.enemy1.hp);
        enemy1HealthBar.setStringPainted(true);
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 1;
        c.gridy = 2;
        enemy1.add(enemy1HealthBar, c);

        c.insets = new Insets(5, 10, 5, 10);

        /**
         * TARGET BUTTONS
         */
        if (combatEncounter.enemy3 != null) {
            targetButton1 = new JButton("LOCK IN TARGET");
            targetButton1.setPreferredSize(new Dimension(200, 40));
            c.gridx = 0;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.insets = new Insets(10, 10, 10, 55);
            targetButton1.addActionListener(a -> {
                target = combatEncounter.targetID.get(3);
                combatEncounter.targetedAbility(playerAbilityNumber, target);
                targetToggle();
            });
            botHalfPanel.add(targetButton1, c);
            targetButton1.setVisible(false);
        }

        if (combatEncounter.enemy1 != null) {
            targetButton2 = new JButton("LOCK IN TARGET");
            targetButton2.setPreferredSize(new Dimension(200, 40));
            c.gridx = 1;
            c.insets = new Insets(10, 55, 10, 55);
            targetButton2.addActionListener(a -> {
                target = combatEncounter.targetID.get(1);
                combatEncounter.targetedAbility(playerAbilityNumber, target);
                targetToggle();
            });
            botHalfPanel.add(targetButton2, c);
            targetButton2.setVisible(false);

        }

        if (combatEncounter.enemy2 != null) {
            targetButton3 = new JButton("LOCK IN TARGET");
            targetButton3.setPreferredSize(new Dimension(200, 40));
            c.gridx = 2;
            c.insets = new Insets(10, 55, 10, 10);
            targetButton3.addActionListener(a -> {
                target = combatEncounter.targetID.get(2);
                combatEncounter.targetedAbility(playerAbilityNumber, target);
                targetToggle();
            });
            botHalfPanel.add(targetButton3, c);
            targetButton3.setVisible(false);

        }

        targetButtons = new HashMap<>() {
            {
                put(1, targetButton1);
                put(2, targetButton2);
                put(3, targetButton3);
            }
        };

        window.pack();
        window.setVisible(true);
    }

    /**
     * A helper method to change the values of the health bar (progress bar).
     * 
     * @param val the amount to change the health bar by. (can be positive or
     *            negative)
     */
    public void modifyHealthBar(int val) {
        healthBar.setValue(healthBar.getValue() - val);
    }

    /**
     * A method to turn targetting on and off.
     */
    public void targetToggle() {
        toggle = !toggle;
        for (int i = 1; i < 4; i++) {
            if (targetButtons.get(i) != null) {
                targetButtons.get(i).setVisible(toggle);
            }
        }
    }

    /**
     * Refreshes / Updates the UI elements on the screen with their proper values.
     */
    public void refreshGUI() {

        healthBar.setValue(combatEncounter.player.hp);

        // Refreshes the actions points to its updated values.
        actionPointText.setText(String.format("%d", combatEncounter.actionPoints));

        /**
         * Button and Ability PP refreshing
         */

        for (int i = 1; i < 7; i++) {
            if (combatEncounter.abilityID.get(i).getAbilityCost() < combatEncounter.actionPoints) {
                abilityButtonID.get(i).setEnabled(true);
            } else if (combatEncounter.abilityID.get(i).getAbilityCost() > combatEncounter.actionPoints) {
                abilityButtonID.get(i).setEnabled(false);
            }

            if (combatEncounter.abilityID.get(i).getCurrentPP() == 0) {
                abilityButtonID.get(i).setEnabled(false);
            }
            abilityLimits.get(i).setText(String.format("%d", combatEncounter.abilityID.get(i).currentTurnPP));
        }

        // If enemy1 exists
        if (combatEncounter.enemy1 != null) {
            // If enemy1's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy1.hp <= 0) {
                combatEncounter.enemy1.isActive = false;
            } else {
                enemy1HealthBar.setValue(combatEncounter.enemy1.hp);
            }
        }

        // If enemy2 exists
        if (combatEncounter.enemy2 != null) {
            // If enemy2's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy2.hp <= 0) {
                combatEncounter.enemy2.isActive = false;
            } else {
                enemy2HealthBar.setValue(combatEncounter.enemy2.hp);
            }
        }

        // If enemy3 exists
        if (combatEncounter.enemy3 != null) {

            // If enemy3's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy3.hp <= 0) {
                combatEncounter.enemy3.isActive = false;
            } else {
                enemy3HealthBar.setValue(combatEncounter.enemy3.hp);
            }
        }

    }
}
