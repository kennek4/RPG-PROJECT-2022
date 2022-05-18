package CombatFiles;

import java.util.HashMap;

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

/**
 * Class responsible for the GUI during combat.
 */
public class CombatGUI {

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

    JPanel botHalfPanel;
    JLabel label;
    GridLayout grid;
    CombatEncounter combatEncounter;
    Enemy target;

    CombatGUI main;

    int playerAbilityNumber;

    /**
     * Combat GUI constructor
     * 
     * @param combatEncounter the CombatEncounter object that is to be used.
     */
    public CombatGUI(CombatEncounter combatEncounter) {

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
            // if ((combatEncounter.actionPoints > 0)
            // && !(combatEncounter.actionPoints -
            // combatEncounter.player.gun.a1.getAbilityCost() < 0)) {
            // if (combatEncounter.player.gun.a1.needsTarget() == true) {
            // playerAbilityNumber = 1;
            // targetToggle();
            // } else {
            // combatEncounter.usePlayerAbility(1);
            // }
            // } else {
            // abilityButton1.setEnabled(false);
            // }
            if (combatEncounter.player.gun.a1.needsTarget() == true) {
                playerAbilityNumber = 1;
                targetToggle();
            } else {
                combatEncounter.usePlayerGunAbility(1);
            }
        });
        abilityButton1.setPreferredSize(new Dimension(200, 100));
        abilityBox1.add(abilityButton1);
        pBotHalfPanel.add(abilityBox1);

        abilityBox2 = new JPanel();
        abilityBox2.setBackground(Color.CYAN);
        abilityBox2.setLayout(new GridBagLayout());
        abilityButton2 = new JButton(combatEncounter.player.gun.a2.getAbilityName());
        abilityButton2.addActionListener(a -> {
            // if ((combatEncounter.actionPoints > 0)
            // && !(combatEncounter.actionPoints -
            // combatEncounter.player.gun.a2.getAbilityCost() < 0)) {
            // if (combatEncounter.player.gun.a2.needsTarget() == true) {
            // playerAbilityNumber = 2;
            // targetToggle();
            // } else {
            // combatEncounter.usePlayerAbility(2);
            // }
            // } else {
            // abilityButton2.setEnabled(false);
            // }
            if (combatEncounter.player.gun.a2.needsTarget() == true) {
                playerAbilityNumber = 2;
                targetToggle();
            } else {
                combatEncounter.usePlayerGunAbility(2);
            }
        });
        abilityButton2.setPreferredSize(new Dimension(200, 100));
        abilityBox2.add(abilityButton2);
        pBotHalfPanel.add(abilityBox2);

        abilityBox3 = new JPanel();
        abilityBox3.setBackground(Color.CYAN);
        abilityButton3 = new JButton(combatEncounter.player.gun.a3.getAbilityName());
        abilityButton3.addActionListener(a -> {
            // if ((combatEncounter.actionPoints > 0)
            // && !(combatEncounter.actionPoints -
            // combatEncounter.player.gun.a3.getAbilityCost() < 0)) {
            // if (combatEncounter.player.gun.a3.needsTarget() == true) {
            // playerAbilityNumber = 3;
            // targetToggle();
            // } else {
            // combatEncounter.usePlayerAbility(3);
            // }
            // } else {
            // abilityButton3.setEnabled(false);
            // }
            if (combatEncounter.player.gun.a3.needsTarget() == true) {
                playerAbilityNumber = 3;
                targetToggle();
            } else {
                combatEncounter.usePlayerGunAbility(3);
            }
        });
        abilityButton3.setPreferredSize(new Dimension(200, 100));
        abilityBox3.add(abilityButton3);
        pBotHalfPanel.add(abilityBox3);

        abilityBox4 = new JPanel();
        abilityBox4.setBackground(Color.CYAN);
        abilityButton4 = new JButton(combatEncounter.player.gun.a4.getAbilityName());
        abilityButton4.addActionListener(a -> {
            // if ((combatEncounter.actionPoints > 0)
            // && (combatEncounter.actionPoints -
            // combatEncounter.player.gun.a4.getAbilityCost() < 0)) {
            // if (combatEncounter.player.gun.a4.needsTarget() == true) {
            // playerAbilityNumber = 4;
            // targetToggle();
            // } else {
            // combatEncounter.usePlayerAbility(4);
            // }
            // }

            if (combatEncounter.player.gun.a4.needsTarget() == true) {
                playerAbilityNumber = 4;
                targetToggle();
            } else {
                combatEncounter.usePlayerGunAbility(4);
            }
        });
        abilityButton4.setPreferredSize(new Dimension(200, 100));
        abilityBox4.add(abilityButton4);
        pBotHalfPanel.add(abilityBox4);

        abilityBox5 = new JPanel();
        abilityBox5.setBackground(Color.CYAN);
        abilityButton5 = new JButton(combatEncounter.abilityID.get(5).getAbilityName());
        abilityButton5.addActionListener(a -> {
            combatEncounter.useSupportAbility(5);
        });

        abilityButton5.setPreferredSize(new Dimension(200, 100));
        abilityBox5.add(abilityButton5);
        pBotHalfPanel.add(abilityBox5);

        abilityBox6 = new JPanel();
        abilityBox6.setBackground(Color.CYAN);
        abilityButton6 = new JButton(combatEncounter.abilityID.get(6).getAbilityName());
        abilityButton6.addActionListener(a -> {
            combatEncounter.useSupportAbility(6);
        });
        abilityButton6.setPreferredSize(new Dimension(200, 100));
        abilityBox6.add(abilityButton6);
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
        actionPointBox.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        envInfoBoxImg.add(actionPointBox, c);

        actionPointText = new JLabel(String.format("%d", combatEncounter.actionPoints));
        actionPointText.setPreferredSize(new Dimension(150, 150));
        actionPointText.setBackground(Color.CYAN);
        c.gridx = 0;
        actionPointBox.add(actionPointText, c);

        endTurnButton = new JButton("END TURN");
        endTurnButton.setPreferredSize(new Dimension(200, 50));
        endTurnButton.addActionListener(a -> {

        });
        c.gridx = 2;
        envInfoBoxImg.add(endTurnButton, c);

        // Shows the name of the place that the combat is taking place in.
        label = new JLabel("PLACE NAME");
        c.gridx = 1;
        envInfoBoxImg.add(label, c);

        enemyBox = new JPanel();
        enemyBox.setLayout(new GridBagLayout());
        enemyBox.setPreferredSize(new Dimension(800, 300));
        enemyBox.setBackground(Color.GREEN);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        envInfoBoxImg.add(enemyBox, c);

        botHalfPanel = new JPanel();
        botHalfPanel.setLayout(new GridBagLayout());
        botHalfPanel.setBackground(Color.RED);
        botHalfPanel.setPreferredSize(new Dimension(800, 100));
        c.gridx = 0;
        c.gridy = 2;
        envInfoBoxImg.add(botHalfPanel, c);

        enemy2 = new JPanel();
        enemy2.setPreferredSize(new Dimension(200, 200));
        enemy2.setBackground(Color.ORANGE);
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        enemyBox.add(enemy2, c);

        if (combatEncounter.enemy2 != null) {
            enemyLabel2 = new JLabel(String.format("%d", combatEncounter.enemy2.hp));
            enemy2.add(enemyLabel2);
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
            enemyLabel3 = new JLabel(String.format("%d", combatEncounter.enemy3.hp));
            enemy3.add(enemyLabel3);
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

        enemyLabel1 = new JLabel(String.format("%d", combatEncounter.enemy1.hp));
        enemy1.add(enemyLabel1);

        /**
         * TARGET BUTTONS
         */
        targetButton1 = new JButton("Target 1st Position");
        targetButton1.setPreferredSize(new Dimension(200, 50));
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = new Insets(15, 15, 15, 15);
        targetButton1.addActionListener(a -> {
            target = combatEncounter.targetID.get(3);
            combatEncounter.targetedAbility(playerAbilityNumber, target);
            targetToggle();
        });
        botHalfPanel.add(targetButton1, c);
        targetButton1.setVisible(false);

        targetButton2 = new JButton("Target 2nd Position");
        targetButton2.setPreferredSize(new Dimension(200, 50));
        c.gridx = 1;
        c.insets = new Insets(15, 50, 15, 50);
        targetButton2.addActionListener(a -> {
            target = combatEncounter.targetID.get(1);
            combatEncounter.targetedAbility(playerAbilityNumber, target);
            targetToggle();
        });
        botHalfPanel.add(targetButton2, c);
        targetButton2.setVisible(false);

        targetButton3 = new JButton("Target 3rd Position");
        targetButton3.setPreferredSize(new Dimension(200, 50));
        c.gridx = 2;
        c.insets = new Insets(15, 15, 15, 15);
        targetButton3.addActionListener(a -> {
            target = combatEncounter.targetID.get(2);
            combatEncounter.targetedAbility(playerAbilityNumber, target);
            targetToggle();
        });
        botHalfPanel.add(targetButton3, c);
        targetButton3.setVisible(false);

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
        targetButton1.setVisible(toggle);
        targetButton2.setVisible(toggle);
        targetButton3.setVisible(toggle);
    }

    /**
     * Refreshes / Updates the UI elements on the screen with their proper values.
     */
    public void refreshGUI() {

        healthBar.setValue(combatEncounter.player.hp);

        // Refreshes the actions points to its updated values.
        actionPointText.setText(String.format("%d", combatEncounter.actionPoints));

        /**
         * Disables buttons if the ability cost is more than available actions points
         */

        for (int i = 1; i < 6; i++) {
            if (combatEncounter.abilityID.get(i).getAbilityCost() > combatEncounter.actionPoints) {
                abilityButtonID.get(i).setEnabled(false);
            }
        }

        // If enemy1 exists
        if (combatEncounter.enemy1 != null) {
            // If enemy1's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy1.hp <= 0) {
                combatEncounter.enemy1.isActive = false;
                enemyLabel1.setText("ELIMINATED");
            } else {
                enemyLabel1.setText(String.format("HP: %d", combatEncounter.enemy1.hp));
            }
        }

        // If enemy2 exists
        if (combatEncounter.enemy2 != null) {
            // If enemy2's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy2.hp <= 0) {
                combatEncounter.enemy2.isActive = false;
                enemyLabel2.setText("ELIMINATED");
            } else {
                enemyLabel2.setText(String.format("HP: %d", combatEncounter.enemy2.hp));
            }
        }

        // If enemy3 exists
        if (combatEncounter.enemy3 != null) {

            // If enemy3's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy3.hp <= 0) {
                combatEncounter.enemy3.isActive = false;
                enemyLabel3.setText("ELIMINATED");
            } else {
                enemyLabel3.setText(String.format("HP: %d", combatEncounter.enemy3.hp));
            }
        }

    }
}
