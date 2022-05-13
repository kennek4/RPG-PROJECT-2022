package stuff2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import stuff2.Enemy.EnemyState;
import stuff2.Player.PlayerState;

interface PlayerAction {
	void executeAction();
}

public class HeartBeat implements Runnable {

	enum State {

		COMBAT {
			State nextState() {
				return NOT_IN_COMBAT;
			}
		},
		NOT_IN_COMBAT {
			State nextState() {
				return COMBAT;
			}
		};

		abstract State nextState();
	}

	// Declaring variables
	private Random r = new Random();
	public Player player;
	public Player.PlayerState pState;
	public Enemy enemy;
	public Enemy.EnemyState eState;
	public InputDriver inputDriver;
	private HeartBeat.State hbState;
	public UI ui;

	// Combat variables
	// private int combatDistance;
	// private int baseDistance;
	private String playerAction;
	private boolean enemyAttackAction;

	public HeartBeat(Player player, Enemy enemy, InputDriver inputDriver, int baseDistance) {

		// Entity objects
		this.player = player;
		this.enemy = enemy;

		// States
		this.eState = Enemy.EnemyState.NOT_LOOKING;
		this.pState = Player.PlayerState.NOT_IN_COVER;

		this.inputDriver = inputDriver;
		// this.baseDistance = baseDistance;

		// Setting the which combat cycle the heartbeat is in.
		if (pState == Player.PlayerState.NOT_IN_COVER && eState == Enemy.EnemyState.LOOKING) {

			this.hbState = HeartBeat.State.COMBAT;

		} else {

			this.hbState = HeartBeat.State.NOT_IN_COMBAT;

		}

		// combatDistance = ((int) Math.pow(player.perception, 2) / 2) + baseDistance;

		System.out.println(pState);

		System.out.println(eState);
		System.out.println(eState.stateDialogue());

	}

	//
	// PLAYER ACTIONS
	//
	public void takeCover() {
		if (pState == PlayerState.IN_COVER) {
			System.out.println("You are already in cover...");
		} else {
			pState = PlayerState.IN_COVER;
			System.out.println("\n*You go to cover*");
		}
	}

	public void shootingPos() {
		if (pState == PlayerState.NOT_IN_COVER) {
			System.out.println("You are already standing...");
		} else {
			pState = PlayerState.NOT_IN_COVER;
			System.out.println("\nYou stand in shooting position");
		}
	}

	/**
	 * Pre-heartbeat beat attack queue
	 */
	public void queuePlayerAttack() {
		if (pState == PlayerState.IN_COVER) {
			System.out.println("\nYou can't shoot while hiding in cover...");
		} else {
			playerAction = "attack";
			if (hbState == State.NOT_IN_COMBAT) {
				hbState = State.COMBAT;
				System.out.println("[You will be in combat next heartbeat]");
			}
		}
	}

	// Weapon reload
	public void queueReload() {
		playerAction = "reload";
	}

	private void playerReload() {
		System.out.println("*You begin to reload...*");
		player.weapon.currentAmmoCount = player.weapon.ammoCapacity;
		System.out.printf("\nAmmo: %d", player.weapon.currentAmmoCount);
	}

	/**
	 * The player attack that is execute on heartbeat start
	 */
	private void playerAttack() {

		System.out.println("\n\nPlayer Attack");

		boolean validAmmoCount = (player.weapon.getAmmoCount() > 0);
		boolean playerMissed = (r.nextInt(100) > player.weapon.getAcc());

		System.out.println("\n*You line up your sights...*");

		if (validAmmoCount) {
			int dmgDealt = player.weapon.shootWeapon();
			if (!playerMissed) {
				System.out.println("DMG before DMG Reduction: " + dmgDealt);
				System.out.println("DMG after DMG Reduction: " + (dmgDealt * enemy.armour.percentDmgReduction));
				enemy.hp -= (dmgDealt * enemy.armour.percentDmgReduction);

				System.out.printf("\n[You hit the enemy for %f]", (dmgDealt * enemy.armour.percentDmgReduction));

			} else {
				System.out.println("*...and you missed!*");
			}
		} else {
			System.out.println("\nNo more ammo! Reload your gun!");
		}
	}

	/**
	 * The enemies attack on heartbeat start
	 */
	private void enemyAttack() {

		System.out.println("\n\nEnemy Attack");
		int dmgDealt = enemy.weapon.shootWeapon();
		boolean enemyMissed = (r.nextInt(100) > enemy.weapon.acc);

		if (!enemyMissed) {
			if (pState == PlayerState.NOT_IN_COVER) {

				player.hp -= (dmgDealt * player.armour.percentDmgReduction);
				System.out.println("\n*The enemy manages to land their shots!*");
				System.out.printf("\n[The enemy hit you for %d]", dmgDealt);
			} else {

				// Reduced dmg taken due to being in cover.
				player.hp -= (dmgDealt * 0.25);
				System.out.println("\n*The enemy sprays towards your cover and their bullets miss you...*");
				System.out.println("*Stray shrapnel pepper you...*");
				System.out.printf("\n[The enemy hit you for %f]", (dmgDealt * 0.25));

			}
		} else {
			System.out.println("*\nA hail of bullets whizz pass you but miss you entirely...*");
		}

	}

	// When player is engaged in combat
	public void beatCycle() {
		enemyAttackAction = r.nextBoolean();

		System.out.printf("\nPLAYER HEALTH: %d", player.hp);
		System.out.printf("\nENEMY HEALTH: %d\n", enemy.hp);

		switch (playerAction) {
			// if attack is queued
			case ("attack"):
				if (enemyAttackAction) {
					if (player.dexterity > enemy.dexterity) {
						System.out.println("\n[You get to shoot first]");
						playerAttack();
						enemyAttack();
					} else {
						System.out.println("\n[The enemy gets to shoot first]");
						enemyAttack();
						playerAttack();
					}
				} else {
					playerAttack();
				}
				break;

			// if reload is queued
			case ("reload"):
				playerReload();
				break;

			// If nothing is queued
			case ("none"):
				System.out.println("You missed your chance...");

				// Enemy Attack
				if (enemyAttackAction) {
					enemyAttack();
				}

				break;
		}

		enemyAttackAction = false;
		playerAction = "none";
	}

	// When player is not in combat
	public void nonCombatCycle() {
		if (pState == PlayerState.NOT_IN_COVER && eState == EnemyState.LOOKING) {
			hbState = State.COMBAT;
			System.out.println("\nYou have been spotted! You are now in combat!");
		} else if (r.nextBoolean()) {
			System.out.println(eState.stateDialogue());
			eState = eState.nextState();
			// print transition dialogue.
			System.out.println();
		}
	}

	/**
	 * What is called every "X" ms
	 */
	@Override
	public void run() {
		Timer timer = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(playerAction);
				if (hbState == State.COMBAT) {
					beatCycle();
				} else {
					nonCombatCycle();
				}
			}
		});

		timer.start();
	}
}
