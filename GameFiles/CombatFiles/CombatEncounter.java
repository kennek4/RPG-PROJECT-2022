package CombatFiles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import CombatFiles.Enemy.actionState;
import GameRun.GameDriver;

/**
 * The class that handles all combat logic between enemies and the player /
 * user.
 */
public class CombatEncounter {

    Random r = new Random();
    public CombatUI ui;
    public JFrame window;
    public GameDriver game;
    public boolean isLastArea;

    // Player related variables
    Player player;
    Enemy playersTarget;
    int actionPoints, playerExtraDamage;
    int tier;
    boolean isBoss = false;

    // Enemy variables
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    int numberOfEnemies;
    int deadEnemies = 0;

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
    public CombatEncounter(Player player, int numberOfEnemies, int levelEnemyTier) {
        this.player = player;
        this.player.shield = 0;

        // Player is rested.
        if (player.isRested == true) {
            player.shield = 50;
            player.hp += 20;
            if (player.hp > 100) {
                player.hp = 100;
            }
        }

        this.numberOfEnemies = numberOfEnemies;
        this.tier = levelEnemyTier;

        if (levelEnemyTier == 5) {
            isBoss = true;
        }

        // Mapping the player skills to a HashMap for easier access later on.
        abilityID = new HashMap<>() {
            {
                put(1, player.gun.a1);
                put(2, player.gun.a2);
                put(3, player.gun.a3);
                put(4, player.gun.a4);
                put(5, new PlayerAbility("First Aid", new int[] { 10, 20 + player.perception }, 0, 4, 3));
                put(6, new PlayerAbility("Armour Up", null, player.armour.armourAmount, 4, 2));
            }
        };

        // The initial action points of the player. Action points increase depending on
        // player's dexterity5
        actionPoints = 7 + (Math.floorDiv(player.dexterity, 3));

        // Extra damage depending on the player's shooting skill
        playerExtraDamage = (Math.floorDiv(player.shooting, 2));

        switch (this.numberOfEnemies) {
            // When only one enemy is inside the cell
            case (1):
                System.out.println("1 Enemy has spawned");
                enemy1 = new Enemy("Tom", 100, levelEnemyTier,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);
                break;

            // When two enemies are inside the cell
            case (2):
                System.out.println("2 Enemies have spawned");
                enemy1 = new Enemy("Tom", 100, levelEnemyTier,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);

                enemy2 = new Enemy("Jeff", 100, levelEnemyTier,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(2, enemy2);
                break;

            // When three enemies are inside the cell (the max amount)
            case (3):
                System.out.println("3 Enemies have spawned");
                enemy1 = new Enemy("Tom", 100, levelEnemyTier,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(1, enemy1);

                enemy2 = new Enemy("Jeff", 100, levelEnemyTier,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(2, enemy2);

                enemy3 = new Enemy("Billy", 100, levelEnemyTier,
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                targetID.put(3, enemy3);

                break;
        }
    }

    /**
     * Updates the enemy's currentHealthState enum state.
     */
    private void updateEnemyHealthState() {
        // Updating enemy healthStates
        for (int i = 1; i < 7; i++) {
            if (targetID.get(i) != null) {
                targetID.get(i).currentHealthState = targetID.get(i).setHealthState();
            }
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
        actionPoints -= abilityID.get(playerAbilityNumber).getAbilityCost();
        int baseDamage = abilityID.get(playerAbilityNumber).useAbility();
        int actions = abilityID.get(playerAbilityNumber).getNumberOfActions();

        // Goes through all of the enemies in the combat and applies damage to them.
        for (int i = 0; i < targetID.size(); i++) {
            playersTarget = targetID.get(i + 1);
            if (playersTarget != null && playersTarget.isActive == true) {

                int totalDamage = 0;
                int normalBullets = 0;
                int critDamageDealt = 0;
                int critBullets = 0;

                for (int bullet = 0; bullet < actions; bullet++) {
                    int roll = r.nextInt(100);
                    if (roll < abilityID.get(playerAbilityNumber).getCritChance()) {
                        // System.out.println("Bullet " + bullet + " crit!");
                        critDamageDealt += (baseDamage * 2);
                        critBullets++;
                        totalDamage += critDamageDealt;
                    } else {
                        totalDamage += baseDamage;
                        normalBullets++;
                    }
                }

                // Shield check against enemy
                if (playersTarget.shield > ((totalDamage) + playerExtraDamage)) {
                    playersTarget.shield -= ((totalDamage) + playerExtraDamage);
                } else {
                    playersTarget.hp -= (((totalDamage) - playersTarget.shield) + playerExtraDamage);
                    playersTarget.shield = 0;
                }

                // Shows total damage dealt
                ui.damageOverView(i, critBullets, normalBullets, totalDamage, critDamageDealt, playerExtraDamage,
                        player.shooting);
            }
        }

        // Refreshes the HP of the enemies on the screen.
        updateEnemyHealthState();
        ui.refreshGUI();
    }

    /**
     * A method for targeted abilities to call.
     * 
     * @param playerAbilityNumber the GunAbility ID.
     * @param target              the enemy target for the ability.
     */
    void targetedAbility(int playerAbilityNumber, int ID) {

        Enemy target = targetID.get(ID);
        actionPoints -= abilityID.get(playerAbilityNumber).getAbilityCost();
        int baseDamage = abilityID.get(playerAbilityNumber).useAbility();
        int actions = abilityID.get(playerAbilityNumber).getNumberOfActions();

        int totalDamage = 0;
        int normalBullets = 0;
        int critDamageDealt = 0;
        int critBullets = 0;

        for (int bullet = 0; bullet < actions; bullet++) {
            int roll = r.nextInt(100);
            if (roll < abilityID.get(playerAbilityNumber).getCritChance()) {
                // System.out.println("Bullet " + bullet + " crit!");
                critDamageDealt += (baseDamage * 2);
                critBullets++;
                totalDamage += critDamageDealt;
            } else {
                totalDamage += baseDamage;
                normalBullets++;
            }
        }

        // Shield checks.
        if (target.shield > ((totalDamage) + playerExtraDamage)) {
            target.shield -= ((totalDamage) + playerExtraDamage);
        } else {
            target.hp -= (((totalDamage) - target.shield) + playerExtraDamage);
            target.shield = 0;
        }

        // Shows total damage dealt to the enemy
        ui.damageOverView(ID, critBullets, normalBullets, totalDamage, critDamageDealt, playerExtraDamage,
                player.shooting);

        updateEnemyHealthState();
        ui.refreshGUI();
    }

    /**
     * Use player support ability
     * 
     * @param playerAbilityNumber the support ability ID
     */
    void useSupportAbility(int playerAbilityNumber) {
        actionPoints -= abilityID.get(playerAbilityNumber).getAbilityCost();
        switch (playerAbilityNumber) {
            // Healing
            case (5):
                int healAmount = r.nextInt(abilityID.get(playerAbilityNumber).getHealRange()[1])
                        + abilityID.get(playerAbilityNumber).getHealRange()[0];
                if (player.hp + healAmount > 100) {
                    player.hp = 100;
                } else {
                    player.hp += healAmount;
                }
                break;
            // Armour / Shield
            case (6):
                player.shield += abilityID.get(playerAbilityNumber).getArmourAmount();
                break;
        }
        updateEnemyHealthState();
        ui.refreshGUI();
    }

    /**
     * A method that is called when the player's turn is finished.
     * This method deals with the combat logic for enemies.
     */
    void enemyTurn(int i) {

        if (targetID.get(i) != null) {
            if (targetID.get(i).isActive == true) {
                if (targetID.get(i).intention == actionState.ATTACK) {
                    int dmg = targetID.get(i).attackTurn.poll();
                    System.out.println("Dmg: " + dmg);
                    int actions = targetID.get(i).actions;
                    targetID.get(i).rollActions();
                    ui.refreshGUI();
                    if (player.shield > (dmg * actions)) {
                        player.shield -= dmg * actions;
                    } else {
                        player.hp -= ((dmg * actions) - player.shield);
                        player.shield = 0;
                    }
                } else if (targetID.get(i).intention == actionState.HEALING) {
                    int actions = targetID.get(i).actions;
                    int amount = targetID.get(i).healTurn.poll();

                    targetID.get(i).hp += ((int) Math.floor(amount * actions));
                    targetID.get(i).currentHealthState = targetID.get(i).setHealthState();
                } else if (targetID.get(i).intention == actionState.SHIELD) {
                    targetID.get(i).shield += targetID.get(i).shieldTurn.poll();
                }
                targetID.get(i).nextTurn();
            }

            // Sets enemy health back to 100 if the enemy healed for over their max health
            if (targetID.get(i).hp > 100) {
                targetID.get(i).hp = 100;
            }
        }

        // Checks if player is dead; if player is dead go to game over screen.
    }

    /**
     * End player turn, resets action points and enemies perform their actions
     */
    void endTurn() {
        actionPoints = 7 + (Math.floorDiv(player.dexterity, 3));
        for (int i = 1; i < 4; i++) {
            if (targetID.get(i) != null) {
                if (targetID.get(i).isActive == true) {
                    enemyTurn(i);
                }
            }
        }

        if (player.hp <= 0) {
            ui.gameOver();
        }

        for (int i = 1; i < 4; i++) {
            if (targetID.get(i) != null) {
                if (targetID.get(i).isActive == false && targetID.get(i).hp <= 0) {
                    deadEnemies++;
                }
            }
        }

        if (deadEnemies == numberOfEnemies) {
            endCombat();
        } else {
            deadEnemies = 0;
        }

        ui.refreshGUI();
    }

    /**
     * Method that ends combat, then rolls for loot.
     */
    private void endCombat() {
        System.out.println("Combat Ending...");

        if (isLastArea) {
            ui.window.dispose();
            JOptionPane.showMessageDialog(ui.window,
                    "As the crackles of gun fire settle down and the adrenaline of combat disappears, you move across the now cleared bridge.\nAs you arrive to the other side of the bridge, you arrive in friendly territory.\nThe perilous journey to retrive and deliver back the Platinum USB has lead you to reach the outer edge of the Busan Perimiter.",
                    "End Game", JOptionPane.OK_OPTION);
            JOptionPane.showMessageDialog(ui.window,
                    "Shortly after arriving you reach the ROK Military HQ located at the Busan Naval Base...\n\nYou hand over the Platinum USB to the Special Forces Commander.",
                    "End Game", JOptionPane.OK_OPTION);

            JOptionPane.showMessageDialog(ui.window,
                    "The Platinum USB you handed over contained the necessary information to create a successful counter attack on the northern part of the Busan Perimeter.\nEncirclement of an entire North Korean army group north of the perimeter allowed the ROK forces to push the North Koreans back to the 38th Demarkation Line.\n\nBecause of your efforts, that is the story so far...",
                    "The END", JOptionPane.OK_OPTION);

            JOptionPane.showMessageDialog(ui.window,
                    "Mission Successful\nPackage Succesfully Delivered.\nCourier Survived.", "The END",
                    JOptionPane.OK_OPTION);
            System.exit(1);
        } else {
            // Upgrades armour when the combat was a tier 5
            if (isBoss) {
                JOptionPane.showMessageDialog(ui.window,
                        "As you clear the checkpoint of its guards, you look around for supplies...\nYou find new body armour and equip it immidiately.\n(Armour Class +1)\n\nYou update your map...\n(Perception +1)",
                        "Upgrade", JOptionPane.PLAIN_MESSAGE);
                player.armour = GameDriver.armours.get(player.armour.armourClass + 1);
                player.perception += 1;

                // Updates the armour up ability
                abilityID.put(6, new PlayerAbility("Armour Up", null, player.armour.armourAmount, 4, 2));
            }

            ui.window.dispose();

            player.isRested = false;
            game.rollForLoot(window, player);
        }
    }
}
