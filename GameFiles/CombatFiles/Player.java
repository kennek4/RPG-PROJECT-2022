package CombatFiles;

import java.util.HashMap;
import java.util.Random;

/**
 * The user
 */
public class Player {

	Random r = new Random();

	public String name;
	public Gun[] inventory;
	public int hp, perception, organization, dexterity, shooting, shield;
	Armour armour;
	public Gun gun;

	private String[] ranks = { "Private", "Captain", "First Sergeant", "Lieutenant" };
	private String[] lastNames = { "Choi", "Lee", "Park", "Kim", "Go", "Jo", "Oh", "Jeong", "Lim", "Son" };

	/**
	 * Constructor for making the player object.
	 * 
	 * @param hp         the starting hp of the player.
	 * @param perception perception of the player.
	 * @param org        the organization of the player.
	 * @param dex        the dexterity of the player.
	 * @param shooting   the shooting skill of the player.
	 * @param armour     the Armour object the enemy is initialized with.
	 */
	public Player(int hp, int perception, int org, int dex, int shooting, Armour armour) {

		// Player stats
		this.perception = perception;
		this.organization = org;
		this.dexterity = dex;
		this.shooting = shooting;

		this.hp = hp;
		this.armour = armour;
		this.shield = 0;

		this.inventory = new Gun[dexterity];
		this.name = String.format("%s %s", (ranks[r.nextInt(ranks.length)]), (lastNames[r.nextInt(lastNames.length)]));

	}
}
