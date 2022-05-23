package CombatFiles;

import java.util.HashMap;
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;

public class Enemy {

	Random r = new Random();

	public enum healthState {

		HEALTHY {
			@Override
			healthState nextState() {
				return SLIGHTY_HURT;
			}

			@Override
			int chanceToAttack() {
				return 100;
			}
		},
		SLIGHTY_HURT {
			@Override
			healthState nextState() {
				return HURT;
			}

			@Override
			int chanceToAttack() {
				return 90;
			}
		},
		HURT {
			@Override
			healthState nextState() {
				return CRITICAL_CONDITION;
			}

			@Override
			int chanceToAttack() {
				return 75;
			}
		},
		CRITICAL_CONDITION {
			@Override
			healthState nextState() {
				return DEAD;
			}

			@Override
			int chanceToAttack() {
				return 50;
			}
		},
		DEAD {
			@Override
			healthState nextState() {
				return null;
			}

			@Override
			int chanceToAttack() {
				return 0;
			}
		};

		abstract healthState nextState();

		abstract int chanceToAttack();
	}

	public enum actionState {
		ATTACK,
		HEALING,
		SHIELD;
	}

	public healthState currentHealthState;

	// Stats
	int hp, dexterity, enemyTier, actions, shield;
	Armour armour;
	String name;

	// Boolean that determines whether or not the enemy will be able to attack or
	// not
	// When this option is false, the enemy will not be able to attack and is
	// deactivated (essentially is "killed")
	Boolean isActive;

	// The enemy's dmg range
	int dmgBounds;

	// DMG Range variables
	private final int TIER_1 = 8;
	private final int TIER_2 = 10;
	private final int TIER_3 = 12;
	private final int TIER_4 = 14;
	private final int TIER_5 = 18; // Boss level dmg

	/**
	 * The base dmg for different enemy tiers.
	 * 
	 * Integer -> Enemy tier
	 * int[] -> Tier damage range (int[].length = 2, int[0] = lower dmg bound,
	 * int[1] = high dmg bound)
	 */

	HashMap<Integer, Integer> enemyTierMaxDMG = new HashMap<>() {
		{
			put(1, TIER_1);
			put(2, TIER_2);
			put(3, TIER_3);
			put(4, TIER_4);
			put(5, TIER_5);
		}
	};

	/**
	 * Sets the enum state of the enemy depending on the current health of the enemy
	 * 
	 * @return healthState
	 */
	healthState setHealthState() {
		if (hp == 100) {
			return healthState.HEALTHY;
		} else if (hp < 100 && hp >= 85) {
			return healthState.SLIGHTY_HURT;
		} else if (hp < 85 && hp >= 50) {
			return healthState.HURT;
		} else if (hp < 50 && hp > 0) {
			return healthState.CRITICAL_CONDITION;
		} else if (hp == 0) {
			return healthState.DEAD;
		}
		return healthState.DEAD;
	}

	Queue<Integer> attackTurn;
	Queue<Integer> healTurn;
	Queue<Integer> shieldTurn;
	Queue<actionState> nextTurnIntention;

	public actionState intention;

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

		this.dmgBounds = enemyTierMaxDMG.get(enemyTier);
		attackTurn = new LinkedList<>() {
			{
				offer(r.nextInt(dmgBounds) + 1);
			}
		};

		System.out.println("attackTurn: " + attackTurn);

		healTurn = new LinkedList<>() {
			{
				offer(r.nextInt(5) + 1);
			}
		};

		nextTurnIntention = new LinkedList<>() {
			{
				offer(actionState.ATTACK);
			}
		};

		shieldTurn = new LinkedList<>() {
			{
				offer(r.nextInt(10) + 1);
			}
		};
		this.intention = nextTurnIntention.poll();

		this.isActive = true;
		this.currentHealthState = setHealthState();
		this.shield = 0;
	}

	/**
	 * Enemy attack method, called when enemies need to attack the player.
	 */
	void attack() {

		// Rolls for the next attack
		attackTurn.offer(r.nextInt(dmgBounds) + 1);

	}

	void heal() {

		// Rolls for next heal
		healTurn.offer(r.nextInt(10) + 1);

	}

	void shield() {

		// Rolls for the next shield.
		shieldTurn.offer(r.nextInt(10) + 1);
		System.out.println(shieldTurn);
	}

	void nextTurn() {
		if ((r.nextInt(100) + 1) < currentHealthState.chanceToAttack()) {
			nextTurnIntention.offer(actionState.ATTACK);
			attack();
		} else if (r.nextInt(100) + 1 < currentHealthState.chanceToAttack()){
			nextTurnIntention.offer(actionState.HEALING);
			heal();
		} else {
			nextTurnIntention.offer(actionState.SHIELD);
			shield();
		}
		intention = nextTurnIntention.poll();
	}

	void rollActions() {
		actions = r.nextInt(3) + 1;
	}
}
