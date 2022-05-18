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
    int actionPoints;

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
    HashMap<Integer, PlayerAbility> abilityID;

    /**
     * CombatEncounter Constructor
     * 
     * @param player          the player object.
     * @param numberOfEnemies the number of enemies in this combat instance.
     */
    public CombatEncounter(Player player, int numberOfEnemies) {
        this.player = player;
        this.numberOfEnemies = numberOfEnemies;

        // Mapping the player skills to a HashMap for easier access later on.
        abilityID = new HashMap<>() {
            {
                put(1, player.gun.a1);
                put(2, player.gun.a2);
                put(3, player.gun.a3);
                put(4, player.gun.a4);
                put(5, new PlayerAbility("Bandage Up", new int[] { 10, 15 }, 0, 2));
                put(6, new PlayerAbility("Hunker Down", null, player.armour.armourAmount, 4));
            }
        };

        // The initial action points of the player.
        actionPoints = 10;

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
    }

    /**
     * Uses the appropriate player gun ability depending on which button is pressed
     * in
     * the UI.
     * 
     * @param playerAbilityNumber the GunAbility ID.
     */
    void usePlayerGunAbility(int playerAbilityNumber) {
        player.hp -= 50;
        actionPoints -= abilityID.get(playerAbilityNumber).getAbilityCost();
        int dmg = abilityID.get(playerAbilityNumber).useAbility();

        // Goes through all of the enemies in the combat and applies damage to them.
        for (int i = 0; i < targetID.size(); i++) {
            playersTarget = targetID.get(i + 1);
            playersTarget.hp -= dmg;
        }

        // Refreshes the HP of the enemies on the screen.
        ui.refreshGUI();
    }

    /**
     * A method for targeted abilities to call.
     * 
     * @param playerAbilityNumber the GunAbility ID.
     * @param target              the enemy target for the ability.
     */
    void targetedAbility(int playerAbilityNumber, Enemy target) {
        actionPoints -= abilityID.get(playerAbilityNumber).getAbilityCost();
        target.hp -= abilityID.get(playerAbilityNumber).useAbility();
        ui.refreshGUI();
    }

    void useSupportAbility(int playerAbilityNumber) {
        actionPoints -= abilityID.get(playerAbilityNumber).getAbilityCost();
        switch (playerAbilityNumber) {
            // Healing
            case (5):
                player.hp += r.nextInt(abilityID.get(playerAbilityNumber).getHealRange()[0],
                        abilityID.get(playerAbilityNumber).getHealRange()[1] + 1);
                break;
            // Armour / Shield
            case (6):

                break;
        }

        ui.refreshGUI();
    }

    /**
     * A method that is called when the player's turn is finished.
     * This method deals with the combat logic for enemies.
     */
    void enemyTurn() {

        // Runs through all the enemies and sees if they are capable of attacking or not
        // by
        // checking the isActive property.
        for (int i = 1; i < 4; i++) {
            if (targetID.get(i).isActive == true) {
                int dmg = targetID.get(i).attack();
                player.hp -= dmg;
            }
        }
    }
}
