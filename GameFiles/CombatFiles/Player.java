package CombatFiles;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The user
 */
public class Player {

	Random r = new Random();

	public String name;
	public ArrayList<Gun> inventory;
	public int hp, perception, organization, dexterity, shooting, shield;
	public Armour armour;
	public Gun gun;

	public Boolean isRested = false;

	private String[] ranks = { "Private", "Captain", "Sergeant", "Lieutenant" };
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

		this.inventory = new ArrayList<>();
		if (name == null) {
			this.name = String.format("%s %s", (ranks[r.nextInt(ranks.length)]), lastNames[r.nextInt(ranks.length)]);
		} else {
			this.name = String.format("%s %s", (ranks[r.nextInt(ranks.length)]), name);
		}

	}

	/**
	 * Method to add a gun to the player's inventory
	 * 
	 * @param gun the gun object that will be added.
	 */
	public void addToInventory(Gun gun, JFrame window) {
		if ((inventory.size() + 1) <= organization) {
			inventory.add(gun);
		} else {
			JOptionPane.showConfirmDialog(window,
					"Inventory is full! Cannot add another item.\n Empty an inventory slot before adding a new item.",
					"Inventory is full", JOptionPane.OK_OPTION);
		}
	}

	/**
	 * A method to remove an item from the inventory *NOT REVERSIBLE*
	 * 
	 * 
	 */
	public void removeFromInventory() {
		if (inventory.size() == 1) {
			JOptionPane.showMessageDialog(null, "You only have 1 item in your inventory, you can't discard.",
					"Discard Weapon Error", JOptionPane.OK_OPTION);
		} else {
			String inv = "";
			for (int i = 0; i < inventory.size(); i++) {
				inv += String.format("Inventory Slot %d: %s\n", i, inventory.get(i).gunName);
			}

			String choice = JOptionPane.showInputDialog(null, inv, "Discard Weapon", JOptionPane.QUESTION_MESSAGE);
			try {
				if (Integer.parseInt(choice) > inventory.size()) {
					JOptionPane.showMessageDialog(null, "Invalid Inventory Slot Number", "Discard Error",
							JOptionPane.OK_OPTION);
				} else {

					int slot = Integer.parseInt(choice);

					inventory.remove(slot);

					JOptionPane.showMessageDialog(null,
							String.format("Successfully removed %s", gun.gunName),
							"Discard Weapon", JOptionPane.OK_OPTION);
				}
			} catch (Exception e) {
			}
		}
	}
}
