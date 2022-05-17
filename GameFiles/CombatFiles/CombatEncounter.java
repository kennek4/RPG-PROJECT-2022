package CombatFiles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * The class that handles all combat logic between enemies and the player /
 * user.
 */
public class CombatEncounter {

    Random r = new Random();
    CombatGUI ui;

    // Player related variables
    Player player;
    Enemy playersTarget;

    // Enemy variables
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    int numberOfEnemies;

    // Possible armour for enemy initialization
    List<Armour> enemyArmours = Arrays.asList(new Armour(0, 5),
            new Armour(2, 10), new Armour(3, 15));

    // ID HashMaps
    HashMap<Integer, Enemy> targetID = new HashMap<>();
    HashMap<Integer, GunAbility> abilityID = new HashMap<>();

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
                enemy1 = new Enemy("Tom", 90, 2,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);
                break;

            // When two enemies are inside the cell
            case (2):
                System.out.println("this is 2");
                enemy1 = new Enemy("Tom", 90, 2,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);

                enemy2 = new Enemy("Jeff", 90, 2,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(2, enemy2);
                break;

            // When three enemies are inside the cell (the max amount)
            case (3):
                System.out.println("this is 3");
                enemy1 = new Enemy("Tom", 90, 2,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);

                enemy2 = new Enemy("Jeff", 90, 2,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(2, enemy2);

                enemy3 = new Enemy("Billy", 90, 2,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(3, enemy3);

                break;
        }

        abilityID.put(1, player.gun.a1);
        abilityID.put(2, player.gun.a2);
        abilityID.put(3, player.gun.a3);
        abilityID.put(4, player.gun.a4);

    }

    /**
     * Uses the appropriate player ability depending on which button is pressed in
     * the UI.
     * 
     * @param playerAbilityNumber the GunAbility ID.
     */
    void usePlayerAbility(int playerAbilityNumber) {
        int dmg = abilityID.get(playerAbilityNumber).useAbility();

        // Goes through all of the enemies in the combat and applies damage to them.
        for (int i = 0; i < targetID.size(); i++) {
            playersTarget = targetID.get(i + 1);
            playersTarget.hp -= dmg;
        }

        // Refreshes the HP of the enemies on the screen.
        ui.refreshEnemyHP();
    }

    /**
     * A method for targeted abilities to call.
     * 
     * @param playerAbilityNumber the GunAbility ID.
     * @param target              the enemy target for the ability.
     */
    void targetedAbility(int playerAbilityNumber, Enemy target) {
        target.hp -= abilityID.get(playerAbilityNumber).useAbility();
        ui.refreshEnemyHP();
    }
}
