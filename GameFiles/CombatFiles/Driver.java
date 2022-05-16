package CombatFiles;

import java.util.Random;
import java.util.Scanner;

public class Driver {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random r = new Random();
        Armour class4 = new Armour(4, 20);
        // Weapon type56 = new Weapon("Type 56", 12, 70, 20, 30, 3);

        Player player = new Player(100, 6, 4, 6, 6, class4);
        Gun gun = new Gun(new GunAbility("Spray & Pray", true, 12, 2, 5, 55),
                new GunAbility("Burst Fire", true, 9, 3, 3, 75),
                new GunAbility("Double Time", true, 10, 2, 2, 85),
                new GunAbility("Single Shot", true, 13, 1, 1, 99));
        player.gun = gun;
        // int enemyCount = r.nextInt(3) + 1;
        // System.out.println(enemyCount);
        CombatEncounter cb = new CombatEncounter(player, r.nextInt(3) + 1);
        GUI ui = new GUI(cb);

        gun.ui = ui;
        cb.ui = ui;

    }
}
