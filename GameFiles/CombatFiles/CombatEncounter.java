package CombatFiles;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CombatEncounter {

    Random r = new Random();
    Player player;

    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    int numberOfEnemies;

    List<Weapon> enemyWeapons = Arrays.asList(new Weapon("Type 88", 12, 75, 20, 30, 1),
            new Weapon("Type 68", 10, 69, 15, 30, 1));

    List<Armour> enemyArmours = Arrays.asList(new Armour(0, 5),
            new Armour(2, 10), new Armour(3, 15));

    public CombatEncounter(Player player, int numberOfEnemies) {
        this.player = player;

        this.numberOfEnemies = numberOfEnemies;
        switch (this.numberOfEnemies) {
            case (1):
                System.out.println("this is 1");
                enemy1 = new Enemy(90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                break;

            case (2):
                System.out.println("this is 2");
                enemy1 = new Enemy(90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));

                enemy2 = new Enemy(90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));

                break;

            case (3):
                System.out.println("this is 3");
                enemy1 = new Enemy(90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));

                enemy2 = new Enemy(90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));

                enemy3 = new Enemy(90, 5, enemyWeapons.get(r.nextInt(enemyWeapons.size())),
                        enemyArmours.get(r.nextInt(enemyArmours.size())));
                break;
        }
    }

    public void usePlayerAbility(int playerAbilityNumber) {
        switch (playerAbilityNumber) {

            // Attack Abilities
            case (1):
                System.out.println(1);
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
