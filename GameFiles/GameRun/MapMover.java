package GameRun;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import CombatFiles.Player;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.awt.Color;

public class MapMover extends JPanel implements ActionListener {

    JFrame window;

    // Colours
    final protected Color BLACK = new Color(34, 35, 35);
    final protected Color WHITE = new Color(240, 246, 240);

    GameDriver game;
    Player player;

    MapData mapData;
    MapGraph currentArea;
    int currentAreaID = 1;
    boolean isLastArea = false;

    final ImageIcon PLAYER_ICON = new ImageIcon("GameFiles\\UI\\playerPortrait.png");
    final ImageIcon UP_ARROW = new ImageIcon("GameFiles\\UI\\upbutton.png");
    final ImageIcon RIGHT_ARROW = new ImageIcon("GameFiles\\UI\\right arrow.png");

    final ImageIcon BUILDING = new ImageIcon("GameFiles\\UI\\building.png");

    private JButton restButton = new JButton();
    private JLabel playerPortrait = new JLabel(PLAYER_ICON);
    private JButton playerStats = new JButton();
    private JButton playerInv = new JButton();
    private JButton upButton, rightButton;

    private HashMap<Integer, MapGraph> areaCodes;

    public MapGraph.MapNode currentLocation;
    private MapGraph.MapNode leftNode;
    private MapGraph.MapNode aboveNode;
    private MapGraph.MapNode rightNode;

    private JPanel currentLocationPanel;
    private JPanel leftLocationPanel;
    private JPanel aboveLocationPanel;
    private JPanel rightLocationPanel;

    private JLabel currentLocationLabel = new JLabel();
    private JLabel leftLocationLabel = new JLabel();
    private JLabel aboveLocationLabel = new JLabel();
    private JLabel rightLocationLabel = new JLabel();

    HashMap<Integer, MapGraph.MapNode> nodeID;
    HashMap<Integer, JLabel> nodeLabels;
    HashMap<Integer, MapGraph.MapNode> areaStarts;

    static final private String UP = "up";
    static final private String NEXT = "next";

    /**
     * Map Movement GUI
     * 
     * @param mapData map node info
     * @param game    gamedriver
     * @param player  the player object
     */
    public MapMover(MapData mapData, GameDriver game, Player player) {
        this.player = player;
        this.game = game;
        this.mapData = mapData;
        // System.out.println(currentLocation + "1");
        nodeID = new HashMap<>() {
            {
                put(0, leftNode);
                put(1, aboveNode);
                put(2, rightNode);
            }
        };

        nodeLabels = new HashMap<>() {
            {
                put(0, leftLocationLabel);
                put(1, aboveLocationLabel);
                put(2, rightLocationLabel);
            }
        };

        areaCodes = new HashMap<>() {
            {
                put(1, mapData.area1);
                put(2, mapData.area2);
                put(3, mapData.area3);
                put(4, mapData.area4);
                put(5, mapData.area5);
                put(6, mapData.area6);
            }
        };

        areaStarts = new HashMap<>() {
            {
                put(1, mapData.area1.getNode("Hospital"));
                put(2, mapData.area2.getNode("Highway"));
                put(3, mapData.area3.getNode("Dirty Road"));
                put(4, mapData.area4.getNode("Junction"));
                put(5, mapData.area5.getNode("Elementary School"));
            }
        };

        this.currentArea = areaCodes.get(currentAreaID);
        this.currentLocation = currentArea.getNode(areaStarts.get(currentAreaID).name);
        this.aboveNode = currentArea.getAdjList(currentLocation.name).get(0);
        this.rightNode = currentArea.getAdjList(currentLocation.name).get(1);

        createWindow();
    }

    protected JButton makeNavigationButton(ImageIcon image,
            String actionCommand,
            String toolTipText,
            String altText) {

        // Create and initialize the button.
        JButton button = new JButton();
        button.setIcon(image);
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this);

        button.setText(altText);

        return button;
    }

    protected void addButtons(JToolBar toolBar) {

        // first button
        upButton = makeNavigationButton(UP_ARROW, UP,
                "Move up.",
                "Up");
        upButton.setVisible(false);
        toolBar.add(upButton);

        // second button
        rightButton = makeNavigationButton(RIGHT_ARROW, NEXT,
                "Advance forward.",
                "Forward");
        toolBar.add(rightButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        int direction = 0;

        // Handle each button.

        if (UP.equals(cmd)) { // second button clicked
            direction = 1;
            updateLocations();

        } else if (NEXT.equals(cmd)) { // third button clicked
            direction = 2;
            updateLocations();

        }

        moveConfirmation(direction);
    }

    /**
     * Creates the right side of the Game window; contains the map data and map
     * moving buttons.
     */
    class GraphicMap extends JPanel {
        JToolBar movementButtons;
        GridBagConstraints c = new GridBagConstraints();

        public GraphicMap() {

            setBackground(BLACK);
            setLayout(new GridBagLayout());

            movementButtons = new JToolBar();
            movementButtons.setFloatable(false);
            addButtons(movementButtons);

            // Lay out the main panel.
            setPreferredSize(new Dimension(400, 400));
            c.gridx = 0;
            c.gridy = 2;
            c.gridwidth = 3;
            c.gridheight = 1;
            add(movementButtons, c);

            currentLocationPanel = new JPanel();
            currentLocationPanel.setPreferredSize(new Dimension(110, 100));
            currentLocationPanel.setLayout(new GridBagLayout());
            currentLocationPanel.add(currentLocationLabel);
            c.gridx = 1;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            add(currentLocationPanel, c);

            rightLocationPanel = new JPanel();
            rightLocationPanel.setPreferredSize(new Dimension(110, 100));
            rightLocationPanel.setLayout(new GridBagLayout());
            rightLocationPanel.add(rightLocationLabel);
            c.gridx = 2;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            add(rightLocationPanel, c);

            leftLocationPanel = new JPanel();
            leftLocationPanel.setPreferredSize(new Dimension(110, 100));
            leftLocationPanel.setLayout(new GridBagLayout());
            leftLocationPanel.add(leftLocationLabel);
            c.gridx = 0;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            add(leftLocationPanel, c);

            aboveLocationPanel = new JPanel();
            aboveLocationPanel.setPreferredSize(new Dimension(110, 100));
            aboveLocationPanel.setLayout(new GridBagLayout());
            aboveLocationPanel.add(aboveLocationLabel);
            c.gridx = 1;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 1;
            add(aboveLocationPanel, c);

        }
    }

    /**
     * Creates the left side of the Game window; contains player info
     */
    class PlayerInfo extends JPanel {
        Player player;

        public PlayerInfo(Player player) {
            this.player = player;
            setLayout(new GridBagLayout());
            setPreferredSize(new Dimension(300, 400));
            setBackground(BLACK);

            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 0;
            c.gridy = 0;
            c.gridheight = 2;
            c.gridwidth = 3;
            add(playerPortrait, c);

            playerStats.setText("Show Stats");
            playerStats.addActionListener(a -> {
                JOptionPane.showMessageDialog(this,
                        String.format(
                                "Name: %s\nCurrent HP: %d/100\n\nPerception: %d - Flat increase to max heal\n Organization: %d - Flat increase to inventory space\n Dexterity: %d - Increases action points per turn\n Shooting: %d - Increases final damage of abilities",
                                player.name, player.hp, player.perception, player.organization, player.dexterity,
                                player.shooting),
                        "STATS", JOptionPane.PLAIN_MESSAGE);
                ;
            });
            playerStats.setToolTipText("Shows the player's current stats.");
            c.insets = new Insets(10, 0, 10, 0);
            c.gridheight = 1;
            c.gridwidth = 1;
            c.gridx = 0;
            c.gridy = 2;
            add(playerStats, c);

            restButton.setText("Rest");
            restButton.addActionListener(a -> {
                int choice = JOptionPane.showConfirmDialog(this,
                        String.format(
                                "Current HP: %d/100\n\nAre you sure you want to sleep?\nYou will heal 20%% of your max health and start with 50 shield in the next area with combat.\n (WARNING: Enemies may stumble upon you resting)",
                                player.hp),
                        "Rest", JOptionPane.YES_NO_OPTION);
                if (choice == 0) {
                    if (player.hp >= 100) {
                        JOptionPane.showMessageDialog(this,
                                "You have no time to rest, you must move on. (HP already at max.)", "Move on Courier",
                                JOptionPane.OK_OPTION);
                    } else {
                        game.playerRest(window);
                    }
                }

            });
            c.gridx = 1;
            c.gridy = 2;
            c.insets = new Insets(10, 10, 10, 10);
            add(restButton, c);

            playerInv.setText("Show Inventory");
            playerInv.addActionListener(a -> {
                String x = showInventory();
                int choice = JOptionPane.showOptionDialog(this, x, "INVENTORY ITEMS", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] { "Back", "Swap weapon", "Discard Weapon" }, "Back");
                if (choice == 1) {
                    game.equipWeapon();
                } else if (choice == 2) {
                    GameDriver.player.removeFromInventory();
                }
            });
            playerInv.setToolTipText("Shows the contents of the player's inventory.");
            c.insets = new Insets(10, 0, 10, 0);
            c.gridheight = 1;
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 2;
            add(playerInv, c);

        }

        private String showInventory() {
            String inventoryItems = "PACKAGE: Platinum USB \n\n-------------------------------\n";
            for (int i = 0; i < player.inventory.size(); i++) {
                if (player.inventory.get(i).gunName == player.gun.gunName) {
                    inventoryItems += "EQUIPPED: " + (player.inventory.get(i).gunName) + "\n";
                } else {
                    inventoryItems += (player.inventory.get(i).gunName) + "\n";
                }
            }

            return inventoryItems;
        }

    }

    /**
     * Updates the current location of the player.
     * 
     * @param direction
     */
    private void moveTo(int direction) {

        // Updates and changes currentLocation depending on the button pressed.
        if (currentArea.getAdjList(currentLocation.name).size() == 2) {
            if (direction == 2) {
                direction = 1;
                currentLocation = currentArea.getAdjList(currentLocation.name).get(direction);
            }
        } else if (currentArea.getAdjList(currentLocation.name).size() == 1) {
            currentLocation = currentArea.getAdjList(currentLocation.name).get(0);
        } else {
            currentLocation = currentArea.getAdjList(currentLocation.name).get(direction);
        }

        // Checks if the area is the last area of the game
        if (currentAreaID == 5) {
            if (currentArea.getNode("Bridge").name == currentLocation.name) {
                isLastArea = true;
            }
        }

        // Creates a combat encouter if the enemy amount of the node is > 0
        // Also checks if area is the last area.
        if (currentArea.getNode(currentLocation.name).data.enemyAmount > 0) {
            game.createCombatEncounter(currentArea.getNode(
                    currentLocation.name).data.tier,
                    currentArea.getNode(currentLocation.name).data.enemyAmount, window, player, game, isLastArea);
        }
        // Updates current area when the last node of an area is reached
        if (currentArea.getNode(currentLocation.name).data.tier == 5) {
            currentAreaID++;
            currentArea = areaCodes.get(currentAreaID);
            currentLocation = areaStarts.get(currentAreaID);
        }

        if (!isLastArea) {
            updateLocations();
        }

    }

    /**
     * Prompts the user and asks for confirmation about moving to that location
     * 
     * @param direction the int direction that the user is planning to move to
     */
    private void moveConfirmation(int direction) {
        int choice = JOptionPane.showConfirmDialog(window, "Are you sure you want to move here?", "MOVE CONFIRMATION",
                JOptionPane.YES_NO_OPTION);

        if (choice == 0) {
            moveTo(direction);
        }
    }

    /**
     * Updates the JLabels with there new respective locations
     */
    private void updateLocations() {
        String currentLocationName = currentLocation.name;
        for (int i = 0; i < currentArea.getAdjList(currentLocationName).size(); i++) {
            MapGraph.MapNode x = nodeID.get(i);
            x = currentArea.getAdjList(currentLocationName).get(i);
            nodeID.put(i, x);
        }

        switch (currentArea.getAdjList(currentLocationName).size()) {
            case (2):
                rightLocationLabel.setText(String.format("%s", currentArea.getAdjList(currentLocationName).get(1)));
                leftLocationLabel.setText(String.format("%s", currentArea.getAdjList(currentLocationName).get(0)));

                aboveLocationLabel.setVisible(false);
                aboveLocationPanel.setVisible(false);
                upButton.setEnabled(false);
                upButton.setVisible(false);
                break;
            case (3):
                aboveLocationLabel.setText(String.format("%s", currentArea.getAdjList(currentLocationName).get(1)));

                aboveLocationLabel.setVisible(true);
                aboveLocationPanel.setVisible(true);
                rightLocationLabel.setText(String.format("%s", currentArea.getAdjList(currentLocationName).get(2)));
                leftLocationLabel.setText(String.format("%s", currentArea.getAdjList(currentLocationName).get(0)));

                upButton.setEnabled(true);
                upButton.setVisible(true);
                break;
        }

        currentLocationLabel.setText(currentLocationName);
    }

    /**
     * Method that initializes the window that contains both player info and a
     * moveable map.
     */
    void createWindow() {
        GraphicMap map = new GraphicMap();
        PlayerInfo playerInfo = new PlayerInfo(player);

        window = new JFrame();
        window.setTitle("The Courier");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(WHITE);
        window.setLayout(new GridLayout(1, 0, 5, 0));

        window.add(playerInfo);
        window.add(map);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        updateLocations();
    }
}
