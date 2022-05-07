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

	// Combat variables
	private int combatDistance;
	private int baseDistance;
	private boolean playerAttackAction;
	private boolean enemyAttackAction;

	public HeartBeat(Player player, Enemy enemy, InputDriver inputDriver, int baseDistance) {

		this.eState = Enemy.EnemyState.NOT_LOOKING;
		this.pState = Player.PlayerState.NOT_IN_COVER;
		this.player = player;
		this.enemy = enemy;
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
			System.out.println("You are already in shooting position");
		} else {
			pState = PlayerState.NOT_IN_COVER;
			System.out.println("\nYou stand in shooting position");
		}
	}

	public void queuePlayerAttack() {
		if (pState == PlayerState.IN_COVER) {
			System.out.println("You can't shoot while hiding in cover...");
		} else {
			playerAttackAction = true;
			System.out.println("*You line up your sights...*");
			if (hbState == State.NOT_IN_COMBAT) {
				hbState = State.COMBAT;
				System.out.println("[You will be in combat next heartbeat]");
			}
		}
	}

	private void playerAttack() {
		enemy.hp -= player.weapon.dmg;
		System.out.println("*\n...and hit the enemy!*");
		System.out.printf("\n[You hit the enemy for %f]", player.weapon.dmg);
	}

	private void enemyAttack() {
		if (pState == Player.PlayerState.IN_COVER) {
			System.out.println("*The enemy missed! The enemy hit your cover instead...*");
		} else {
			player.hp -= enemy.dmg;
			System.out.println("\n*You've been hit!*");
			System.out.printf("\n[The enemy hit you for %d]", enemy.dmg);
		}
	}

	public void combatCycle() {
		enemyAttackAction = r.nextBoolean();

		if (playerAttackAction && enemyAttackAction) {
			if (player.dexterity > enemy.dexterity) {
				System.out.println("\n[You get to shoot first]");
				playerAttack();
				enemyAttack();
			}
		} else if (playerAttackAction && !enemyAttackAction) {
			playerAttack();
		} else if (enemyAttackAction && !playerAttackAction) {
			enemyAttack();
		}

		enemyAttackAction = false;
		playerAttackAction = false;
	}

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

	@Override
	public void run() {
		Timer timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (hbState == State.COMBAT) {
					combatCycle();
				} else {
					nonCombatCycle();
				}
			}
		});

		timer.start();
	}
}
