package CombatFiles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CombatEncounter {

    Random r = new Random();
    GUI ui;

    // Player related variables
    Player player;
    Enemy playersTarget;

    // Enemy variables
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    int numberOfEnemies;

    // Possible weapon and armour combos for enemy initialization
    List<Weapon> enemyWeapons = Arrays.asList(new Weapon("Type 88", 12, 75, 20, 30, 1),
            new Weapon("Type 68", 10, 69, 15, 30, 1));

    List<Armour> enemyArmours = Arrays.asList(new Armour(0, 5),
            new Armour(2, 10), new Armour(3, 15));

    HashMap<Integer, Enemy> targetID = new HashMap<>();

    /**
     * CombatEncounter Constructor
     * 
     * @param player          the player object.
     * @param numberOfEnemies the number of enemies in this combat instance.
     */
    public CombatEncounter(Player player, int numberOfEnemies) {
        this.player = player;
        this.numberOfEnemies = numberOfEnemies;
        switch (this.numberOfEnemies) {
            // When only one enemy is inside the cell
            case (1):
                System.out.println("this is 1");
                enemy1 = new Enemy("Tom", 90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);
                break;

            // When two enemies are inside the cell
            case (2):
                System.out.println("this is 2");
                enemy1 = new Enemy("Tom", 90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);

                enemy2 = new Enemy("Jeff", 90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(2, enemy2);
                break;

            // When three enemies are inside the cell (the max amount)
            case (3):
                System.out.println("this is 3");
                enemy1 = new Enemy("Tom", 90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);

                enemy2 = new Enemy("Jeff", 90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(2, enemy2);

                enemy3 = new Enemy("Billy", 90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(3, enemy3);

                break;
        }
    }

    /**
     * Uses the appropriate player ability depending on which button is pressed in
     * the UI.
     * 
     * @param playerAbilityNumber the player ability ID.
     */
    void usePlayerAbility(int playerAbilityNumber) {
        switch (playerAbilityNumber) {

            // Attack Abilities
            case (1):
                System.out.println(1);
                if (player.gun.a1.needsTarget()) {
                    ui.targetToggle();
                    try {
                        synchronized (ui.main) {

                        }
                    } catch (InterruptedException e) {
                    }
                    playersTarget.hp -= player.gun.a1.useAbility();
                } else {

                }
                break;
            case (2):
                System.out.println(2);
                break;

            case (3):
                System.out.println(3);
                break;

            case (4):
                System.out.println(4);
                break;

            // Defensive Abilities
            case (5):
                System.out.println(5);
                break;

            case (6):
                System.out.println(6);
                break;
        }
    }

}
