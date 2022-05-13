package stuff2;

import java.util.Random;

public class Weapon {
	public int dmg, acc, critChance, ammoCapacity, shootCost, currentAmmoCount;
	private String weaponName;

	private Random r = new Random();

	public Weapon(String weaponName, int dmg, int acc, int critChance, int ammoCapacity, int shootCost) {

		this.weaponName = weaponName;

		// Main Stats
		this.dmg = dmg;
		this.ammoCapacity = ammoCapacity;
		this.currentAmmoCount = ammoCapacity;
		this.shootCost = shootCost;

		// Secondary stats
		this.acc = acc;
		this.critChance = critChance;
	}

	public int shootWeapon() {
		// if (currentAmmoCount == 0) {
		// System.out.println("*You are out of ammo...*");
		// } else {
		// currentAmmoCount -= shootCost;
		// System.out.printf("\nAmmo: %d", currentAmmoCount);
		// }
		if (currentAmmoCount == 0) {
			System.out.println("*\nYou squeeze the trigger and hear a dry click...*");
			System.out.println("You couldn't shoot because you ran out of ammo...\n");
			return 0;
		}

		// Total dmg that will be returned
		int totalDmg = 0;

		// Figuring out how many valid shots the weapon has left.
		int validShots = shootCost;
		if ((currentAmmoCount - shootCost) < 0) {
			validShots = (shootCost - Math.abs(currentAmmoCount - shootCost));
		}

		System.out.println("Valid shots: " + validShots);

		// Bullet calculations (each bullet will do different dmg)
		for (int i = 0; i < validShots; i++) {
			boolean isCrit = (r.nextInt(100) > critChance);

			// If the bullet crit or not
			if (isCrit) {
				totalDmg += (dmg * 1.5);
			} else {
				totalDmg += totalDmg;
			}
		}

		System.out.println("Total spray dmg: " + totalDmg);
		return totalDmg;
	}

	public void reloadWeapon() {
		System.out.println("\n[You reload your weapon...]");
		currentAmmoCount = ammoCapacity;
		System.out.printf("\nAmmo: %d", currentAmmoCount);
	}

	public int getAmmoCount() {
		return currentAmmoCount;
	}

	public int getAcc() {
		return acc;
	}

	public int getDmg() {
		return dmg;
	}

	public int getCritChance() {
		return critChance;
	}

	public String getWeaponName() {
		return weaponName;
	}

}
