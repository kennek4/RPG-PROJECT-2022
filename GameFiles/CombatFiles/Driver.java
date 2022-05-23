package CombatFiles;

// import java.util.Random;
import java.util.Scanner;

public class Driver {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Random r = new Random();
        Armour class4 = new Armour(4, 12);

        Player player = new Player(100, 6, 4, 6, 6, class4);
        Gun gun = new Gun(new PlayerAbility("Spray & Pray", false, 5, 2, 5, 55, 2),
                new PlayerAbility("Burst Fire", true, 9, 3, 3, 65, 3),
                new PlayerAbility("Double Time", true, 10, 2, 2, 75, 4),
                new PlayerAbility("Single Shot", true, 13, 1, 1, 85, 5));
        player.gun = gun;

        CombatEncounter cb = new CombatEncounter(player, 1);
        CombatUI ui = new CombatUI(cb);

        gun.ui = ui;
        cb.ui = ui;

    }
}  
