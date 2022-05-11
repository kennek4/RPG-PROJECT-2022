package stuff2;

import javax.swing.Timer;

import stuff2.Enemy.EnemyState;
import stuff2.Player.PlayerState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
	private int combatDistance;
	private int baseDistance;
	private String playerAction = "none";
	private boolean enemyAttackAction;

	public HeartBeat(Player player, Enemy enemy, InputDriver inputDriver, int baseDistance) {

		// Entity objects
		this.player = player;
		this.enemy = enemy;
		
		// States
		this.eState = Enemy.EnemyState.NOT_LOOKING;
		this.pState = Player.PlayerState.NOT_IN_COVER;

		this.inputDriver = inputDriver;
		this.baseDistance = baseDistance;

		// Setting the which combat cycle the heartbeat is in.
		if (pState == Player.PlayerState.NOT_IN_COVER && eState == Enemy.EnemyState.LOOKING) {

			this.hbState = HeartBeat.State.COMBAT;

		} else {

			this.hbState = HeartBeat.State.NOT_IN_COMBAT;

		}

		combatDistance = ((int) Math.pow(player.perception, 2) / 2) + baseDistance;

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
		System.out.println("\n*You line up your sights...*");
		if (player.weapon.getAmmoCount() > 0) {
			if (r.nextDouble(100) > player.weapon.getAcc()) {
				System.out.println("\n*...and you missed!*");
			} else {
				enemy.hp -= player.weapon.getDmg();
				System.out.println("\n*...and hit the enemy!*");
				System.out.printf("\n[You hit the enemy for %d]", player.weapon.getDmg());
			}
			player.weapon.shootWeapon();
		} else {
			System.out.println("\nNo more ammo! Reload your gun!");
		}

	}

	/**
	 * The enemies attack on heartbeat start
	 */
	private void enemyAttack() {

		if (pState == Player.PlayerState.IN_COVER) {
			System.out.println("\n*The enemy missed! The enemy hit your cover instead...*");
		} else if (r.nextDouble(100) > 30.00) {
			System.out.println("\n*Bullets from the enemy zip past you and miss!*");

		} else {
			player.hp -= enemy.dmg;
			System.out.println("*\nYou've been hit!*");
			System.out.printf("\n[The enemy hit you for %d]", enemy.dmg);

		}
	}

	// When player is engaged in combat
	public void beatCycle() {
		enemyAttackAction = r.nextBoolean();

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
			case ("none"):
				System.out.println("You missed your chance...");
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
		Timer timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
