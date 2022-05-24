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

    static HashMap<Integer, Armour> armours;
    static HashMap<Integer, Gun> guns;

    static Player player = new Player(100, 6, 4, 6, 6, null);
    static GameDriver game = new GameDriver();
    static MapData mapData = new MapData();
    static MapMover mapNav = new MapMover(mapData, game, player);

    /**
     * Method that creates all the possible guns in the game.
     */

    public static void main(String[] args) {

        Gun K2 = new Gun(new PlayerAbility("Spray & Pray | ALL", false, 1, 5, 10, 15),
                new PlayerAbility("Burst Fire | SINGLE", true, 4, 3, 3, 30),
                new PlayerAbility("Double Time | SINGLE", true, 9, 4, 2, 20),
                new PlayerAbility("Single Shot | SINGLE", true, 4, 2, 1, 25), "K2");

        Gun M4A1 = new Gun(new PlayerAbility("Pot Shots | ALL", false, 3, 5, 5, 20),
                new PlayerAbility("Precise Burst | SINGLE", true, 5, 3, 3, 35),
                new PlayerAbility("Mag. Dump | ALL", false, 1, 10, 30, 5),
                new PlayerAbility("Single Shot | SINGLE", true, 4, 2, 3, 25), "M4A1");

        Gun SR25 = new Gun(new PlayerAbility("Between the Eyes | SINGLE", true, 20, 10, 1, 60),
                new PlayerAbility("Leg Shots | SINGLE", true, 9, 3, 2, 60),
                new PlayerAbility("Hip-Fire | ALL", false, 5, 2, 5, 15),
                new PlayerAbility("Centre Mass | SINGLE", true, 9, 2, 3, 40), "SR-25");

        Gun M870 = new Gun(new PlayerAbility("Dragon's Breath | ALL", false, 5, 7, 5, 30),
                new PlayerAbility("Modern Day Musket | SINGLE", true, 9, 3, 1, 45),
                new PlayerAbility("Bird Shot | ALL", false, 1, 5, 15, 15),
                new PlayerAbility("Buckshot | SINGLE", true, 5, 2, 5, 20), "M870");

        Gun Type88 = new Gun(new PlayerAbility("Blood Red | SINGLE", true, 7, 3, 2, 20),
                new PlayerAbility("Sickle Shot | SINGLE", true, 9, 5, 4, 35),
                new PlayerAbility("Knock-off | ALL", false, 5, 4, 5, 15),
                new PlayerAbility("Centre Mass | SINGLE", true, 4, 2, 3, 25), "Type88");

        Gun Type56 = new Gun(new PlayerAbility("Blood Red | SINGLE", true, 7, 3, 2, 20),
                new PlayerAbility("Sickle Shot | SINGLE", true, 9, 5, 4, 35),
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

        Gun dev_gun = new Gun(new PlayerAbility("dev kill | kill", false, 100, 1, 100, 100),
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

        Armour class2Armour = new Armour(2, 12);
        Armour class3Armour = new Armour(3, 18);
        Armour class4Armour = new Armour(4, 22);
        Armour class5Armour = new Armour(5, 30);

        armours = new HashMap<>() {
            {
                put(1, class2Armour);
                put(2, class3Armour);
                put(3, class4Armour);
                put(4, class5Armour);
            }
        };
        player.armour = armours.get(1);
        player.addToInventory(dev_gun, null);
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
            GameDriver game) {
        windowToHide.setVisible(false);

        CombatEncounter combatEncounter = new CombatEncounter(player, amountOfEnemies, tier);
        combatEncounter.window = windowToHide;
        combatEncounter.game = game;
        CombatUI combatUI = new CombatUI(combatEncounter);
        combatEncounter.ui = combatUI;
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
        if (r.nextInt(1, 100) > (75 - (player.perception * 2))) {
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
}
