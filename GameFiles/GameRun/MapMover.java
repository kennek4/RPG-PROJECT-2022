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
import GameRun.MapGraph.MapNode;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
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

    final ImageIcon PLAYER_ICON = new ImageIcon("GameFiles\\playerPortrait.png");

    private JLabel playerPortrait = new JLabel(PLAYER_ICON);
    private JLabel playerName = new JLabel();
    private JButton playerStats = new JButton();
    private JButton playerInv = new JButton();

    private HashMap<Integer, MapGraph> areaCodes;

    private MapGraph.MapNode currentLocation;
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

    static final private String PREVIOUS = "previous";
    static final private String UP = "up";
    static final private String NEXT = "next";

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

        this.currentArea = areaCodes.get(1);
        this.currentLocation = currentArea.getNode("hospital");
        this.aboveNode = currentArea.getAdjList(currentLocation.name).get(0);
        this.rightNode = currentArea.getAdjList(currentLocation.name).get(1);

        createWindow();
    }

    protected JButton makeNavigationButton(String imageName,
            String actionCommand,
            String toolTipText,
            String altText) {

        // Create and initialize the button.
        JButton button = new JButton();
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this);

        button.setText(altText);

        return button;
    }

    protected void addButtons(JToolBar toolBar) {
        JButton button = null;

        // first button
        button = makeNavigationButton("Back24", PREVIOUS,
                "Back to previous something-or-other",
                "Previous");
        toolBar.add(button);

        // second button
        button = makeNavigationButton("Up24", UP,
                "Up to something-or-other",
                "Up");
        toolBar.add(button);

        // third button
        button = makeNavigationButton("Forward24", NEXT,
                "Forward to something-or-other",
                "Next");
        toolBar.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        int direction = 0;

        // Handle each button.
        if (PREVIOUS.equals(cmd)) { // first button clicked
            direction = 0;
        } else if (UP.equals(cmd)) { // second button clicked
            direction = 1;
        } else if (NEXT.equals(cmd)) { // third button clicked
            direction = 2;
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
            currentLocationPanel.setPreferredSize(new Dimension(100, 100));
            currentLocationLabel.setText("니가 여기다");
            currentLocationPanel.add(currentLocationLabel);
            c.gridx = 1;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            add(currentLocationPanel, c);

            rightLocationPanel = new JPanel();
            rightLocationPanel.setPreferredSize(new Dimension(100, 100));
            rightLocationLabel.setText("오른쪽 있는 곳");
            rightLocationPanel.add(rightLocationLabel);
            c.gridx = 2;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            add(rightLocationPanel, c);

            leftLocationPanel = new JPanel();
            leftLocationPanel.setPreferredSize(new Dimension(100, 100));
            leftLocationLabel.setText("왼쪽 있는 곳");
            leftLocationPanel.add(leftLocationLabel);
            c.gridx = 0;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            add(leftLocationPanel, c);

            aboveLocationPanel = new JPanel();
            aboveLocationPanel.setPreferredSize(new Dimension(100, 100));
            aboveLocationLabel.setText("위에 있는 곳");
            aboveLocationPanel.add(aboveLocationLabel);
            c.gridx = 1;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 1;
            add(aboveLocationPanel, c);
        }
    }

    class PlayerInventory extends JPanel {
        public PlayerInventory() {
            set
        }
    }

    /**
     * Creates the left side of the Game window; contains player info
     */
    class PlayerInfo extends JPanel {
        public PlayerInfo() {
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
                        String.format("Perception: %d\n Organization: %d\n Dexterity: %d\n Shooting: %d",
                                player.perception, player.organization, player.dexterity,
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

            playerInv.setText("Show Inventory");
            playerStats.addActionListener(a -> {
                String inventorySlots = "";
                for (int i = 0; i < player.organization; i++) {
                    inventorySlots += "%d ";
                }

            });
            playerInv.setToolTipText("Shows the contents of the player's inventory.");
            c.insets = new Insets(10, 0, 10, 0);

            c.gridheight = 1;
            c.gridwidth = 1;
            c.gridx = 2;
            c.gridy = 2;
            add(playerInv, c);

            playerName.setText(player.name);
            playerName.setForeground(WHITE);
            c.insets = new Insets(10, 40, 10, 40);
            c.gridheight = 1;
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 2;
            add(playerName, c);
        }

    }

    /**
     * Updates the current location of the player.
     * 
     * @param direction
     */
    private void moveTo(int direction) {
        if (currentArea.getAdjList(currentLocation.name).size() == 2) {
            if (direction == 2) {
                direction = 1;
                currentLocation = currentArea.getAdjList(currentLocation.name).get(direction);
            }
        } else {
            currentLocation = currentArea.getAdjList(currentLocation.name).get(direction);
        }
        updateLocations();

        // Creates an encounter if there are enemies in the area
        if (currentArea.getNode(currentLocation.name).data.enemyAmount > 0) {
            game.createCombatEncounter(currentArea.getNode(
                    currentLocation.name).data.tier,
                    currentArea.getNode(currentLocation.name).data.enemyAmount, window, player, game);
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
                break;
            case (3):
                aboveLocationLabel.setText(String.format("%s", currentArea.getAdjList(currentLocationName).get(1)));
                aboveLocationLabel.setVisible(true);
                aboveLocationPanel.setVisible(true);
                rightLocationLabel.setText(String.format("%s", currentArea.getAdjList(currentLocationName).get(2)));
                leftLocationLabel.setText(String.format("%s", currentArea.getAdjList(currentLocationName).get(0)));
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
        PlayerInfo playerInfo = new PlayerInfo();

        window = new JFrame();
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
