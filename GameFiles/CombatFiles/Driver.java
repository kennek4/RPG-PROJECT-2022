package CombatFiles;

import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        Armour class4 = new Armour(4, 20);
        Weapon ak47 = new Weapon("AK-47", 12, 70, 20, 30, 3);
        Player player = new Player(100, 6, 4, 6, 6, ak47, class4);

        // int enemyCount = r.nextInt(3) + 1;
        // System.out.println(enemyCount);

        CombatEncounter cb = new CombatEncounter(player, 3);
        GUI ui = new GUI(cb);

        while (true) {
            System.out.print("\nReduce health by: ");
            int dmg = sc.nextInt();
            player.hp -= dmg;
            ui.modifyHealthBar(dmg);
            System.out.println(player.hp);
        }
    }
}
