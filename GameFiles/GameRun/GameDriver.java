package GameRun;

import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import CombatFiles.Armour;
import CombatFiles.CombatEncounter;
import CombatFiles.CombatUI;
import CombatFiles.Gun;
import CombatFiles.Player;
import CombatFiles.PlayerAbility;

/**
 * The script that runs the whole game.
 */
public class GameDriver {

    Random r = new Random();

    public static HashMap<Integer, Armour> armours;
    static HashMap<Integer, Gun> guns;

    static Player player = new Player(100, 6, 4, 6, 6, null);
    static GameDriver game = new GameDriver();
    static MapData mapData = new MapData();
    public static MapMover mapNav = new MapMover(mapData, game, player);

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,
                "A second American Civil War has broken out; American military bases across the global fall into disarray.\nAmerican bases in South Korea have been left completely destroyed or basically obsolete and causes North Korea to thrust through the DMZ and attack.\nWithout American support, South Korean forces are unable to defend against the initial attacks of the North Korean army.\nThe ROK Military Forces and the South Korean government are forced back to the Busan Perimeter, a situation both sides were familiar with considering it was what happened in the First Korean War. ",
                "Intro", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "You are part of the 707th Special Forces Unit of the ROK Military.\nYou have been tasked with retrieving a pacakge from behind enemy lines and brining it back to HQ.",
                "Intro", JOptionPane.PLAIN_MESSAGE);

        String name = JOptionPane.showInputDialog(null, "Enter name: ", "Player Name", JOptionPane.OK_OPTION);
        if (name != null) {
            player.name = name;
        }
        /**
         * Creation of all the guns in the game.
         */
        Gun K2 = new Gun(new PlayerAbility("Spray & Pray | ALL", false, 1, 5, 10, 15),
                new PlayerAbility("Burst Fire | SINGLE", true, 5, 3, 3, 30),
                new PlayerAbility("Double Time | SINGLE", true, 9, 3, 2, 30),
                new PlayerAbility("Single Shot | SINGLE", true, 6, 1, 1, 25), "K2");

        Gun M4A1 = new Gun(new PlayerAbility("Pot Shots | ALL", false, 3, 5, 5, 20),
                new PlayerAbility("Precise Burst | SINGLE", true, 5, 3, 3, 35),
                new PlayerAbility("Mag. Dump | ALL", false, 2, 10, 10, 5),
                new PlayerAbility("Single Shot | SINGLE", true, 4, 2, 3, 25), "M4A1");

        Gun SR25 = new Gun(new PlayerAbility("Between the Eyes | SINGLE", true, 40, 10, 1, 60),
                new PlayerAbility("Leg Shots | SINGLE", true, 9, 3, 2, 60),
                new PlayerAbility("Hip-Fire | ALL", false, 8, 2, 2, 10),
                new PlayerAbility("Centre Mass | SINGLE", true, 10, 3, 2, 40), "SR-25");

        Gun M870 = new Gun(new PlayerAbility("Dragon's Breath | ALL", false, 5, 7, 5, 30),
                new PlayerAbility("Modern Day Musket | SINGLE", true, 9, 3, 1, 45),
                new PlayerAbility("Bird Shot | ALL", false, 1, 5, 15, 15),
                new PlayerAbility("Buckshot | SINGLE", true, 5, 2, 5, 20), "M870");

        Gun Type88 = new Gun(new PlayerAbility("Blood Red | SINGLE", true, 7, 3, 2, 20),
                new PlayerAbility("Sickle Shot | SINGLE", true, 9, 6, 4, 35),
                new PlayerAbility("Knock-off | ALL", false, 5, 4, 5, 15),
                new PlayerAbility("Centre Mass | SINGLE", true, 4, 2, 3, 25), "Type88");

        Gun Type56 = new Gun(new PlayerAbility("Blood Red | SINGLE", true, 7, 3, 2, 20),
                new PlayerAbility("Sickle Shot | SINGLE", true, 9, 6, 4, 35),
                new PlayerAbility("Knock-off | ALL", false, 5, 4, 5, 15),
                new PlayerAbility("Centre Mass | SINGLE", true, 4, 2, 3, 25), "Type56");

        Gun AK12 = new Gun(new PlayerAbility("Crimson Fire | SINGLE", true, 7, 3, 2, 20),
                new PlayerAbility("Sickle Shot | SINGLE", true, 9, 5, 4, 35),
                new PlayerAbility("Bullet Hell | ALL", false, 5, 5, 6, 15),
                new PlayerAbility("Centre Mass | SINGLE", true, 4, 2, 3, 25), "AK12");

        Gun HK416 = new Gun(new PlayerAbility("Schadenfreude | SINGLE", true, 10, 8, 3, 30),
                new PlayerAbility("Centre Mass | SINGLE", true, 9, 5, 3, 35),
                new PlayerAbility("German Lead | ALL", false, 5, 4, 5, 15),
                new PlayerAbility("Anvil Fire | SINGLE", true, 8, 2, 2, 30), "HK416");

        Gun dev_gun = new Gun(new PlayerAbility("dev kill | kill", false, 100, 1,
                100, 100),
                new PlayerAbility("Centre Mass | SINGLE", true, 9, 5, 3, 35),
                new PlayerAbility("German Lead | ALL", false, 5, 4, 5, 15),
                new PlayerAbility("Anvil Fire | SINGLE", true, 8, 2, 2, 30), "devgun");

        guns = new HashMap<>() {
            {
                put(1, K2);
                put(2, M4A1);
                put(3, SR25);
                put(4, M870);
                put(5, Type88);
                put(6, Type56);
                put(7, AK12);
                put(8, HK416);
            }
        };

        Armour class2Armour = new Armour(1, 30);
        Armour class3Armour = new Armour(2, 35);
        Armour class4Armour = new Armour(3, 45);
        Armour class5Armour = new Armour(4, 50);

        armours = new HashMap<>() {
            {
                put(1, class2Armour);
                put(2, class3Armour);
                put(3, class4Armour);
                put(4, class5Armour);
            }
        };
        player.armour = armours.get(1);
        player.addToInventory(K2, null);
        player.gun = player.inventory.get(0);

    }

    /**
     * A method that creates a combat encounter in the respective area.
     * 
     * @param tier            the enemy tier that can be found in this area
     * @param amountOfEnemies the amount of enemies in this area
     * @param windowToHide    the main window that will be hidden during combat
     * @param player          the player object
     * @param game            the GameDriver class.
     */
    public void createCombatEncounter(int tier, int amountOfEnemies, JFrame windowToHide, Player player,
            GameDriver game, boolean isLastArea) {
        windowToHide.setVisible(false);

        CombatEncounter combatEncounter = new CombatEncounter(player, amountOfEnemies, tier);
        combatEncounter.isLastArea = isLastArea;
        combatEncounter.window = windowToHide;
        combatEncounter.game = game;
        CombatUI combatUI = new CombatUI(combatEncounter);
        combatEncounter.ui = combatUI;
    }

    /**
     * Allows the player to get the rested buff (50 Shield at the start of the next
     * combat + 20 hp; has a chance to spawn an encounter and not give the buff
     * however.)
     * 
     * @param window the window that will be hidden during the combat.
     */
    public void playerRest(JFrame window) {
        int roll = r.nextInt(1, 100);
        if (roll > 75) {
            JOptionPane.showMessageDialog(window,
                    "As you were trying to rest, you hear footsteps coming towards you...\nYou take your gun out...",
                    "Rest Event", JOptionPane.OK_OPTION);
            createCombatEncounter(1, r.nextInt(2) + 1, window, player, game, false);
        } else {
            player.isRested = true;
            JOptionPane.showMessageDialog(window,
                    "You find a safe place to rest...\n\nYou wake up a few hours later.\nYou start to move forward...",
                    "Rested", JOptionPane.OK_OPTION);
        }
    }

    /**
     * A method that rolls loot after every enemy encounter.
     * 
     * @param window the JOptionPane's parent component
     * @param player the player object
     */
    public void rollForLoot(JFrame window, Player player) {

        // Rolls a random number; if that number is greater than (75 -
        // (player.perception * 2)) then the player is given the option to pick up a
        // gun.
        if (r.nextInt(1, 100) > (85)) {
            int choice = JOptionPane.showOptionDialog(window, "CHOOSE YOU REWARD", "LOOT",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Shooting +1", "Pick Up Enemy Weapon", "Dexterity +1" }, "Pick Up Enemy Weapon");
            switch (choice) {
                case (0):
                    player.shooting++;
                    break;
                case (1):
                    Gun gunRoll = guns.get(r.nextInt(1, guns.size()));
                    while (player.inventory.contains(gunRoll) == true) {
                        gunRoll = guns.get(r.nextInt(1, guns.size()));
                    }

                    player.addToInventory(gunRoll, null);
                    break;
                case (2):
                    player.dexterity++;
                    break;
            }
        } else {
            int choice = JOptionPane.showOptionDialog(window, "CHOOSE YOU REWARD", "LOOT",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Shooting +1", "Dexterity +1" }, "Shooting +1");
            switch (choice) {
                case (0):
                    player.shooting++;
                    break;
                case (1):
                    player.dexterity++;
                    break;
            }
        }

        window.setVisible(true);

    }

    /**
     * Swaps the weapon currently equipped by the player.
     */
    public void equipWeapon() {
        if (player.inventory.size() == 1) {
            JOptionPane.showMessageDialog(null, "You only have 1 item in your inventory, you can't swap.",
                    "Weapon Swap Error", JOptionPane.OK_OPTION);
        } else {
            String inv = "";
            for (int i = 0; i < player.inventory.size(); i++) {
                inv += String.format("Inventory Slot %d: %s\n", i, player.inventory.get(i).gunName);
            }

            String choice = JOptionPane.showInputDialog(null, inv, "Weapon Swap", JOptionPane.QUESTION_MESSAGE);
            try {
                if (Integer.parseInt(choice) > player.inventory.size()) {
                    JOptionPane.showMessageDialog(null, "Invalid Inventory Slot Number", "Swap Error",
                            JOptionPane.OK_OPTION);
                } else {

                    int slot = Integer.parseInt(choice);

                    player.gun = player.inventory.get(slot);

                    JOptionPane.showMessageDialog(null,
                            String.format("Successfully equipped %s", player.gun.gunName),
                            "Weapon Swap", JOptionPane.OK_OPTION);
                }
            } catch (Exception e) {
            }
        }
    }
}
