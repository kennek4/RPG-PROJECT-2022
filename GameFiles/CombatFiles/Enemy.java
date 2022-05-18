package CombatFiles;

import java.util.HashMap;
import java.util.Random;

public class Enemy {

	// Stats
	int hp, dexterity, enemyTier;
	Armour armour;
	String name;

	// Boolean that determines whether or not the enemy will be able to attack or
	// not
	// When this option is false, the enemy will not be able to attack and is
	// deactivated (essentially is "killed")
	Boolean isActive;

	// The enemy's dmg range
	int[] dmgBounds;

	// DMG Range variables
	private int[] tier1 = { 8, 15 };
	private int[] tier2 = {};
	private int[] tier3 = {};
	private int[] tier4 = {};
	private int[] tier5 = {}; // Boss level dmg

	/**
	 * The base dmg for different enemy tiers.
	 * 
	 * Integer -> Enemy tier
	 * int[] -> Tier damage range (int[].length = 2, int[0] = lower dmg bound,
	 * int[1] = high dmg bound)
	 */

	HashMap<Integer, int[]> enemyTierDMGRanges = new HashMap<>() {
		{
			put(1, tier1);
			put(2, tier2);
			put(3, tier3);
			put(4, tier4);
			put(5, tier5);
		}
	};

	/**
	 * Enemy class constructor
	 * 
	 * @param name      the name of the enemy
	 * @param hp        the hp the enemy has
	 * @param enemyTier the tier that the enemy is at, this determines the damage
	 *                  range of the enemy
	 * @param armour    the armour object the enemy is carrying, this determines how
	 *                  much shield the enemy can shield themselves with in a given
	 *                  turn
	 */
	public Enemy(String name, int hp, int enemyTier, Armour armour) {

		this.name = name;
		this.hp = hp;
		this.armour = armour;

		this.isActive = true;
		this.dmgBounds = enemyTierDMGRanges.get(enemyTier);
	}

	/**
	 * Enemy attack method, called when enemies need to attack the player.
	 */
	public int attack() {
		Random r = new Random();
		int dmg = (r.nextInt(dmgBounds[0], dmgBounds[1] + 1));

		int actions = r.nextInt(1, 4);

		return dmg * actions;
	}
}
