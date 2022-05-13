package stuff2;

public class Player {
	public static enum PlayerState {
		IN_COVER {
			public PlayerState nextState() {
				return NOT_IN_COVER;
			}
		},
		NOT_IN_COVER {
			public PlayerState nextState() {
				return IN_COVER;
			}
		};

		abstract PlayerState nextState();
	}

	public static PlayerState playerState;
	public int hp, perception, organization, dexterity, shooting;
	Weapon weapon;
	Armour armour;

	public Player(int hp, int perception, int org, int dex, int shooting, Weapon weapon, Armour armour) {
		Player.playerState = PlayerState.NOT_IN_COVER;

		// Player stats
		this.perception = perception;
		this.organization = org;
		this.dexterity = dex;
		this.shooting = shooting;

		this.hp = hp;
		this.weapon = weapon;
		this.armour = armour;
	}
}
