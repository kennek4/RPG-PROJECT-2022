package GameRun;

import java.util.HashMap;

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

    HashMap<Integer, Armour> armours;
    HashMap<Integer, Gun> guns;

    public static void main(String[] args) {

        Gun K2 = new Gun(new PlayerAbility("Spray & Pray | ALL", false, 1, 5, 10, 15),
                new PlayerAbility("Burst Fire | SINGLE", true, 4, 3, 3, 30),
                new PlayerAbility("Double Time | SINGLE", true, 9, 4, 2, 40),
                new PlayerAbility("Single Shot | SINGLE", true, 4, 2, 1, 25));

        Gun M4A1 = new Gun(new PlayerAbility("Pot Shots | ALL", false, 3, 5, 5, 20),
                new PlayerAbility("Precise Burst | SINGLE", true, 5, 3, 3, 35),
                new PlayerAbility("Mag. Dump | ALL", false, 1, 10, 30, 5),
                new PlayerAbility("Single Shot | SINGLE", true, 4, 2, 1, 25));

        Gun SR25 = new Gun(new PlayerAbility("Between the Eyes | SINGLE", true, 20, 10, 1, 60),
                new PlayerAbility("Leg Shots | SINGLE", true, 9, 3, 2, 60),
                new PlayerAbility("Hip-Fire | ALL", false, 5, 2, 5, 15),
                new PlayerAbility("Centre Mass | SINGLE", true, 9, 2, 3, 40));

        Armour class2 = new Armour(2, 12);

        Player player = new Player(100, 6, 4, 6, 6, class2);
        player.inventory[0] = K2;
        player.gun = player.inventory[0];

        GameDriver game = new GameDriver();
        MapData mapData = new MapData();
        MapMover mapNav = new MapMover(mapData, game, player);
    }

    public void createCombatEncounter(int tier, int amountOfEnemies, JFrame windowToHide, Player player,
            GameDriver game) {
        windowToHide.setVisible(false);

        CombatEncounter combatEncounter = new CombatEncounter(player, amountOfEnemies, tier);
        combatEncounter.window = windowToHide;
        combatEncounter.game = game;
        CombatUI combatUI = new CombatUI(combatEncounter);
        combatEncounter.ui = combatUI;
    }

    public void rollForLoot(JFrame window, Player player) {
        window.setVisible(true);
        int choice = JOptionPane.showOptionDialog(window, "CHOOSE YOU REWARD", "LOOT", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new Object[] { "Shooting +1", "Pick Up Enemy Weapon", "Dexterity +1" }, "Pick Up Enemy Weapon");
        switch (choice) {
            case (0):
                player.shooting++;
                break;
            case (1):
                System.out.println(1);
                break;
            case (2):
                player.dexterity++;
                break;
        }
    }
}
