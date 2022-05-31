package CombatFiles;

import java.util.HashMap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import CombatFiles.Enemy.actionState;
import UI.GameOverScreen;

/**
 * Class responsible for the GUI during combat.
 */
public class CombatUI {

    // COLOURS
    final Color WHITE = new Color(240, 246, 240);
    final Color BLACK = new Color(34, 35, 35);

    // IMAGEs
    final ImageIcon ATK_ICON = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\attack_icon.png");
    final ImageIcon HEAL_ICON = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\heal_icon.png");
    final ImageIcon SHIELD_ICON = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\shield_icon.png");
    final ImageIcon ENEMY = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\enemy_test.png");
    final ImageIcon DMG_ICON = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\abilitydmg_icon.png");
    final ImageIcon ENERGY_ICON = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\energy_icon.png");
    final ImageIcon ENEMYDEAD_IMAGE = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\enemydead_image.png");
    final ImageIcon PLAYER_PORTRAIT = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\player.png");
    final ImageIcon GUN_IMG = new ImageIcon("GameFiles\\CombatFiles\\CombatImages\\gunImg.png");

    // LEFT SIDE TOP HALF VARIABLES
    JFrame window;
    JPanel playerInfoBox;
    JPanel pTopHalfPanel;
    JPanel playerPortrait;
    JLabel gunName;
    JPanel gunIMG;
    JProgressBar healthBar;
    JLabel shieldBar;

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
    HashMap<Integer, JLabel> abilityCosts;
    HashMap<Integer, JButton> targetButtons;
    HashMap<Integer, JLabel> intentions;

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

    JLabel abilityCost1;
    JLabel abilityCost2;
    JLabel abilityCost3;
    JLabel abilityCost4;
    JLabel abilityCost5;
    JLabel abilityCost6;

    JLabel abilityCritChance1 = new JLabel();
    JLabel abilityCritChance2 = new JLabel();
    JLabel abilityCritChance3 = new JLabel();
    JLabel abilityCritChance4 = new JLabel();

    JLabel abilityDamage1 = new JLabel();
    JLabel abilityDamage2 = new JLabel();
    JLabel abilityDamage3 = new JLabel();
    JLabel abilityDamage4 = new JLabel();
    JLabel abilityHealJLabel = new JLabel();
    JLabel abilityShiedJLabel = new JLabel();

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
    JLabel enemy1Shield;
    JLabel enemy2Shield;
    JLabel enemy3Shield;

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

        window = new JFrame("Combat Encounter");
        window.setPreferredSize(new Dimension(1600, 900));
        window.setSize(1600, 900);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setBackground(BLACK);

        GridBagConstraints c = new GridBagConstraints();
        window.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;

        /**
         * Panel for the Left Side of the GUI
         */
        playerInfoBox = new JPanel();
        playerInfoBox.setLayout(new GridBagLayout());
        playerInfoBox.setBackground(BLACK);
        playerInfoBox.setPreferredSize(new Dimension(500, 800));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(30, 15, 10, 15);
        window.add(playerInfoBox, c);

        // Left side top half
        pTopHalfPanel = new JPanel();
        pTopHalfPanel.setLayout(new GridBagLayout());
        pTopHalfPanel.setPreferredSize(new Dimension(475, 300));
        pTopHalfPanel.setBackground(BLACK);
        c.insets = new Insets(0, 5, 0, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 2;
        playerInfoBox.add(pTopHalfPanel, c);

        // Player portrait - left side top half
        playerPortrait = new JPanel();
        label = new JLabel(PLAYER_PORTRAIT);
        playerPortrait.add(label);
        playerPortrait.setPreferredSize(new Dimension(200, 200));
        playerPortrait.setBackground(BLACK);
        c.gridy = 0;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.insets = new Insets(5, 0, 10, 20);
        pTopHalfPanel.add(playerPortrait, c);

        gunName = new JLabel(String.format("%s", combatEncounter.player.gun.gunName));
        gunName.setForeground(WHITE);
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
        gunIMG.setBackground(BLACK);
        label = new JLabel(GUN_IMG);
        gunIMG.add(label);
        gunIMG.setPreferredSize(new Dimension(125, 150));
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        pTopHalfPanel.add(gunIMG, c);

        healthBar = new JProgressBar();
        healthBar.setStringPainted(true);
        healthBar.setMaximum(100);
        healthBar.setValue(combatEncounter.player.hp);
        healthBar.setForeground(Color.GRAY);
        healthBar.setBackground(Color.RED);
        healthBar.setPreferredSize(new Dimension(healthBar.getWidth() + 15, 25));
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 2;

        pTopHalfPanel.add(healthBar, c);

        shieldBar = new JLabel();
        shieldBar.setText(String.format("%d", combatEncounter.player.shield));
        shieldBar.setForeground(WHITE);
        shieldBar.setIcon(SHIELD_ICON);
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        pTopHalfPanel.add(shieldBar, c);

        // Left side bottom half
        pBotHalfPanel = new JPanel();
        pBotHalfPanel.setBackground(Color.WHITE);
        pBotHalfPanel.setLayout(new GridLayout(0, 2, 2, 2));
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
        abilityBox1.setBackground(BLACK);
        abilityBox1.setLayout(new GridBagLayout());
        abilityButton1 = new JButton(combatEncounter.player.gun.a1.getAbilityName());
        abilityButton1.addActionListener(a -> {
            if (combatEncounter.player.gun.a1.needsTarget() == true) {
                playerAbilityNumber = 1;
                targetToggle();
            } else {
                combatEncounter.usePlayerGunAbility(1);
            }
        });
        abilityButton1.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox1.add(abilityButton1, c);
        abilityCost1 = new JLabel();
        abilityCost1.setText(String.format("%d ", combatEncounter.abilityID.get(1).getAbilityCost()));
        abilityCost1.setIcon(ENERGY_ICON);
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox1.add(abilityCost1, c);
        abilityDamage1.setText(String.format("%dx%d", combatEncounter.abilityID.get(1).getBaseDMG(),
                combatEncounter.abilityID.get(1).getNumberOfActions()));
        abilityDamage1.setPreferredSize(new Dimension(abilityDamage1.getWidth() + 15,
                abilityDamage1.getHeight()));
        abilityDamage1.setIcon(DMG_ICON);
        abilityDamage1.setForeground(WHITE);
        abilityCost1.setForeground(WHITE);
        c.gridx = 1;
        c.gridy = 0;
        abilityBox1.add(abilityDamage1, c);
        abilityCritChance1.setText(String.format("%d%%", combatEncounter.abilityID.get(1).getCritChance()));
        abilityCritChance1.setForeground(WHITE);
        c.gridx = 0;
        c.gridy = 0;
        abilityBox1.add(abilityCritChance1, c);
        pBotHalfPanel.add(abilityBox1);

        abilityBox2 = new JPanel();
        abilityBox2.setBackground(BLACK);
        abilityBox2.setLayout(new GridBagLayout());
        abilityButton2 = new JButton(combatEncounter.player.gun.a2.getAbilityName());
        abilityButton2.addActionListener(a -> {
            if (combatEncounter.player.gun.a2.needsTarget() == true) {
                playerAbilityNumber = 2;
                targetToggle();
            } else {
                combatEncounter.usePlayerGunAbility(2);
            }
        });
        abilityButton2.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox2.add(abilityButton2, c);
        abilityCost2 = new JLabel();
        abilityCost2.setText(String.format("%d ", combatEncounter.abilityID.get(2).getAbilityCost()));
        abilityCost2.setIcon(ENERGY_ICON);
        abilityDamage2.setForeground(WHITE);
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox2.add(abilityCost2, c);
        abilityDamage2.setText(String.format("%dx%d", combatEncounter.abilityID.get(2).getBaseDMG(),
                combatEncounter.abilityID.get(2).getNumberOfActions()));
        abilityDamage2.setIcon(DMG_ICON);
        abilityDamage2.setPreferredSize(new Dimension(abilityDamage2.getWidth() + 15,
                abilityDamage1.getHeight()));
        abilityCost2.setForeground(WHITE);
        c.gridx = 1;
        c.gridy = 0;
        abilityBox2.add(abilityDamage2, c);
        abilityCritChance2.setText(String.format("%d%%", combatEncounter.abilityID.get(2).getCritChance()));
        abilityCritChance2.setForeground(WHITE);
        c.gridx = 0;
        c.gridy = 0;
        abilityBox2.add(abilityCritChance2, c);
        pBotHalfPanel.add(abilityBox2);

        abilityBox3 = new JPanel();
        abilityBox3.setBackground(BLACK);
        abilityBox3.setLayout(new GridBagLayout());
        abilityButton3 = new JButton(combatEncounter.player.gun.a3.getAbilityName());
        abilityButton3.addActionListener(a -> {
            if (combatEncounter.player.gun.a3.needsTarget() == true) {
                playerAbilityNumber = 3;
                targetToggle();
            } else {
                combatEncounter.usePlayerGunAbility(3);
            }
        });
        abilityButton3.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox3.add(abilityButton3, c);
        abilityCost3 = new JLabel();
        abilityCost3.setText(String.format("%d ", combatEncounter.abilityID.get(3).getAbilityCost()));
        abilityCost3.setIcon(ENERGY_ICON);
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox3.add(abilityCost3, c);
        abilityDamage3.setText(String.format("%dx%d", combatEncounter.abilityID.get(3).getBaseDMG(),
                combatEncounter.abilityID.get(3).getNumberOfActions()));
        abilityDamage3.setIcon(DMG_ICON);
        abilityDamage3.setForeground(WHITE);
        abilityDamage3.setPreferredSize(new Dimension(abilityDamage3.getWidth() + 15,
                abilityDamage3.getHeight()));
        abilityCost3.setForeground(WHITE);
        c.gridx = 1;
        c.gridy = 0;
        abilityBox3.add(abilityDamage3, c);
        abilityCritChance3.setText(String.format("%d%%", combatEncounter.abilityID.get(3).getCritChance()));
        abilityCritChance3.setForeground(WHITE);
        c.gridx = 0;
        c.gridy = 0;
        abilityBox3.add(abilityCritChance3, c);
        pBotHalfPanel.add(abilityBox3);

        abilityBox4 = new JPanel();
        abilityBox4.setLayout(new GridBagLayout());
        abilityBox4.setBackground(BLACK);
        abilityButton4 = new JButton(combatEncounter.player.gun.a4.getAbilityName());
        abilityButton4.addActionListener(a -> {
            if (combatEncounter.player.gun.a4.needsTarget() == true) {
                playerAbilityNumber = 4;
                targetToggle();
            } else {
                combatEncounter.usePlayerGunAbility(4);
            }
        });
        abilityButton4.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox4.add(abilityButton4, c);
        abilityCost4 = new JLabel();
        abilityCost4.setText(String.format("%d ", combatEncounter.abilityID.get(4).getAbilityCost()));
        abilityCost4.setIcon(ENERGY_ICON);
        abilityCost4.setForeground(WHITE);
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox4.add(abilityCost4, c);
        abilityDamage4.setText(String.format("%dx%d", combatEncounter.abilityID.get(4).getBaseDMG(),
                combatEncounter.abilityID.get(4).getNumberOfActions()));
        abilityDamage4.setIcon(DMG_ICON);
        abilityDamage4.setForeground(WHITE);
        abilityDamage4.setPreferredSize(new Dimension(abilityDamage4.getWidth() + 15,
                abilityDamage4.getHeight()));
        c.gridx = 1;
        c.gridy = 0;
        abilityBox4.add(abilityDamage4, c);
        abilityCritChance4.setText(String.format("%d%%", combatEncounter.abilityID.get(4).getCritChance()));
        abilityCritChance4.setForeground(WHITE);
        c.gridx = 0;
        c.gridy = 0;
        abilityBox4.add(abilityCritChance4, c);
        pBotHalfPanel.add(abilityBox4);
        c.weighty = 1;

        abilityBox5 = new JPanel();
        abilityBox5.setLayout(new GridBagLayout());
        abilityBox5.setBackground(BLACK);
        abilityButton5 = new JButton(combatEncounter.abilityID.get(5).getAbilityName());
        abilityButton5.addActionListener(a -> {
            combatEncounter.useSupportAbility(5);
            System.out.println(combatEncounter.player.hp);
            if (toggle) {
                targetToggle();
            }
        });

        abilityButton5.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox5.add(abilityButton5, c);
        abilityCost5 = new JLabel();
        abilityCost5.setText(String.format("%d ", combatEncounter.abilityID.get(5).getAbilityCost()));
        abilityCost5.setIcon(ENERGY_ICON);
        abilityCost5.setForeground(WHITE);
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox5.add(abilityCost5, c);
        abilityHealJLabel.setText(String.format("%d-%d", combatEncounter.abilityID.get(5).getHealRange()[0],
                combatEncounter.abilityID.get(5).getHealRange()[1]));
        abilityHealJLabel.setForeground(WHITE);
        abilityHealJLabel.setIcon(HEAL_ICON);
        c.gridx = 0;
        c.gridy = 2;
        abilityBox5.add(abilityHealJLabel, c);
        pBotHalfPanel.add(abilityBox5);

        abilityBox6 = new JPanel();
        abilityBox6.setLayout(new GridBagLayout());
        abilityBox6.setBackground(BLACK);
        abilityButton6 = new JButton(combatEncounter.abilityID.get(6).getAbilityName());
        abilityButton6.addActionListener(a -> {
            combatEncounter.useSupportAbility(6);
            if (toggle) {
                targetToggle();
            }
        });
        abilityButton6.setPreferredSize(new Dimension(200, 100));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox6.add(abilityButton6, c);
        abilityCost6 = new JLabel();
        abilityCost6.setText(String.format("%d ", combatEncounter.abilityID.get(6).getAbilityCost()));
        abilityCost6.setIcon(ENERGY_ICON);
        abilityCost6.setForeground(WHITE);
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        abilityBox6.add(abilityCost6, c);
        abilityShiedJLabel.setText(String.format("%d", combatEncounter.player.armour.armourAmount));
        abilityShiedJLabel.setForeground(WHITE);
        abilityShiedJLabel.setIcon(SHIELD_ICON);
        c.gridx = 0;
        c.gridy = 2;
        abilityBox6.add(abilityShiedJLabel, c);
        pBotHalfPanel.add(abilityBox6);

        abilityButtonID = new HashMap<Integer, JButton>() {
            {
                put(1, abilityButton1);
                put(2, abilityButton2);
                put(3, abilityButton3);
                put(4, abilityButton4);
                put(5, abilityButton5);
                put(6, abilityButton6);
            }
        };

        abilityCosts = new HashMap<Integer, JLabel>() {
            {
                put(1, abilityCost1);
                put(2, abilityCost2);
                put(3, abilityCost3);
                put(4, abilityCost4);
                put(5, abilityCost5);
                put(6, abilityCost6);
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
        actionPointBox.setBackground(BLACK);
        actionPointBox.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        envInfoBoxImg.add(actionPointBox, c);

        actionPointText = new JLabel(String.format("Action Points: %d", combatEncounter.actionPoints));
        actionPointText.setPreferredSize(new Dimension(250, 150));
        actionPointText.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        actionPointText.setForeground(WHITE);
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
            enemy2Intention.setForeground(WHITE);
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

            enemy2Shield = new JLabel();
            enemy2Shield.setText(String.format("%d", combatEncounter.targetID.get(2).shield));
            enemy2Shield.setIcon(SHIELD_ICON);
            enemy2Shield.setForeground(WHITE);
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 2;
            enemy2.add(enemy2Shield, c);

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
            enemy3Intention.setForeground(WHITE);
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

            enemy3Shield = new JLabel();
            enemy3Shield.setText(String.format("%d", combatEncounter.targetID.get(3).shield));
            enemy3Shield.setIcon(SHIELD_ICON);
            enemy3Shield.setForeground(WHITE);
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 2;
            enemy3.add(enemy3Shield, c);

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
        enemy1Intention.setForeground(WHITE);
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
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        enemy1.add(enemy1HealthBar, c);

        enemy1Shield = new JLabel();
        enemy1Shield.setText(String.format("%d", combatEncounter.targetID.get(1).shield));
        enemy1Shield.setIcon(SHIELD_ICON);
        enemy1Shield.setForeground(WHITE);
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 2;
        enemy1.add(enemy1Shield, c);

        intentions = new HashMap<Integer, JLabel>() {
            {
                put(1, enemy1Intention);
                put(2, enemy2Intention);
                put(3, enemy3Intention);
            }
        };

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
                combatEncounter.targetedAbility(playerAbilityNumber, 3);
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
                combatEncounter.targetedAbility(playerAbilityNumber, 1);
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
                combatEncounter.targetedAbility(playerAbilityNumber, 2);
                targetToggle();
            });
            botHalfPanel.add(targetButton3, c);
            targetButton3.setVisible(false);

        }

        targetButtons = new HashMap<Integer, JButton>() {
            {
                put(1, targetButton1);
                put(2, targetButton2);
                put(3, targetButton3);
            }
        };

        window.pack();
        window.setVisible(true);

        refreshGUI();
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

    public void damageOverView(int enemyID, int critBullets, int normalBullets, int damageAmount, int critDamageDealt,
            int playerExtraDamage, int playerShooting) {
        if (critDamageDealt > 0) {
            JOptionPane.showMessageDialog(window,
                    String.format(
                            "You hit Enemy #%d with %d bullet(s) that crit for a total of %d crit. damage.\nYour crit. damage alongside the other %d bullet(s) dealt a total of %d to the target.\n\nTOTAL DAMAGE DEALT: %d + %d (Shooting stat, %d / 2)",
                            enemyID + 1,
                            critBullets,
                            critDamageDealt, normalBullets, damageAmount, damageAmount, playerExtraDamage,
                            playerShooting),
                    "DAMAGE REPORT",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(window,
                    String.format(
                            "%d bullet(s) from your gun dealt a total of %d to Enemy #%d.\n\nTOTAL DAMAGE DEALT: %d + %d <- (Shooting stat, %d / 2)",
                            normalBullets, damageAmount, enemyID + 1, damageAmount, playerExtraDamage, playerShooting),
                    "DAMAGE REPORT",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Refreshes / Updates the UI elements on the screen with their proper values.
     */
    public void refreshGUI() {

        healthBar.setValue(combatEncounter.player.hp);
        shieldBar.setText(String.format("%d", combatEncounter.player.shield));

        // Refreshes the actions points to its updated values.
        actionPointText.setText(String.format("Action Points: %d", combatEncounter.actionPoints));

        /**
         * Button and Ability PP refreshing
         */

        for (int i = 1; i < 7; i++) {
            if (combatEncounter.abilityID.get(i).getAbilityCost() < combatEncounter.actionPoints) {
                abilityButtonID.get(i).setEnabled(true);
            } else if (combatEncounter.abilityID.get(i).getAbilityCost() > combatEncounter.actionPoints) {
                abilityButtonID.get(i).setEnabled(false);
            }

            abilityCosts.get(i).setText(String.format("%d", combatEncounter.abilityID.get(i).getAbilityCost()));
        }

        for (int i = 1; i < 4; i++) {
            if (combatEncounter.targetID.get(i) != null) {
                if (combatEncounter.targetID.get(i).intention == actionState.ATTACK) {
                    intentions.get(i).setIcon(ATK_ICON);
                    intentions.get(i)
                            .setText(String.format("%d x %d", combatEncounter.targetID.get(i).attackTurn.peek(),
                                    combatEncounter.targetID.get(i).actions));
                } else if (combatEncounter.targetID.get(i).intention == actionState.SHIELD) {

                    intentions.get(i).setIcon(SHIELD_ICON);
                    intentions.get(i).setText(String.format("%d", combatEncounter.targetID.get(i).shieldTurn.peek()));

                } else {
                    intentions.get(i).setIcon(HEAL_ICON);
                    intentions.get(i).setText(String.format("%d x %d", combatEncounter.targetID.get(i).healTurn.peek(),
                            combatEncounter.targetID.get(i).actions));
                }
            }
        }

        // If enemy1 exists
        if (combatEncounter.enemy1 != null) {
            // If enemy1's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy1.hp <= 0) {
                combatEncounter.enemy1.isActive = false;
                enemy1HealthBar.setVisible(false);
                enemy1Image.setIcon(ENEMYDEAD_IMAGE);
                enemy1Intention.setVisible(false);
                enemy1Shield.setVisible(false);
                targetButton2.setEnabled(false);

            } else {
                enemy1HealthBar.setValue(combatEncounter.enemy1.hp);
                enemy1Shield.setText(String.format("%d", combatEncounter.targetID.get(1).shield));
            }
        }

        // If enemy2 exists
        if (combatEncounter.enemy2 != null) {
            // If enemy2's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy2.hp <= 0) {
                combatEncounter.enemy2.isActive = false;
                enemy2HealthBar.setVisible(false);
                enemy2Image.setIcon(ENEMYDEAD_IMAGE);
                enemy2Intention.setVisible(false);
                enemy2Shield.setVisible(false);
                targetButton3.setEnabled(false);
            } else {
                enemy2HealthBar.setValue(combatEncounter.enemy2.hp);
                enemy2Shield.setText(String.format("%d", combatEncounter.targetID.get(2).shield));
            }
        }

        // If enemy3 exists
        if (combatEncounter.enemy3 != null) {

            // If enemy3's HP is equal or below zero, disable it. This in turn "kills the
            // enemy"
            if (combatEncounter.enemy3.hp <= 0) {
                combatEncounter.enemy3.isActive = false;
                enemy3HealthBar.setVisible(false);
                enemy3Image.setIcon(ENEMYDEAD_IMAGE);
                enemy3Intention.setVisible(false);
                enemy3Shield.setVisible(false);
                targetButton1.setEnabled(false);

            } else {
                enemy3HealthBar.setValue(combatEncounter.enemy3.hp);
                enemy3Shield.setText(String.format("%d", combatEncounter.targetID.get(3).shield));
            }
        }

        if (combatEncounter.player.hp >= 100) {
            abilityButton5.setEnabled(false);
        }

    }

    /**
     * Opens the game over screen and cleans up current UI.
     */
    void gameOver() {
        window.dispose();
        GameOverScreen gameOverScreen = new GameOverScreen();

    }
}
