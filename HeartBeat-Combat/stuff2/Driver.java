package stuff2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GUI ui = new GUI();

        while (true) {
            System.out.print("\nReduce health by: ");
            int dmg = sc.nextInt();
            ui.healthBar.setValue(ui.healthBar.getValue() - dmg);
        }
    }
}
