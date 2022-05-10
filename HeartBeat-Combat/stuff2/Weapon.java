package stuff2;

import java.util.Random;

public class Weapon {
	public int dmg, acc, critChance, ammoCapacity, shootCost, currentAmmoCount;
	private String weaponName;

	Weapon(String weaponName, int dmg, int acc, int critChance, int ammoCapacity, int shootCost) {
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

	public void shootWeapon() {
		if (currentAmmoCount == 0) {
			System.out.println("*You are out of ammo...*");
		} else {
			currentAmmoCount -= shootCost;
			System.out.printf("\nAmmo: %d", currentAmmoCount);
		}
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
