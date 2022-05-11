package stuff2;

public class Player {
	static enum PlayerState {
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
	public Weapon weapon;

	public Player(int hp, int perception, int org, int dex, int shooting, Weapon weapon) {
		Player.playerState = PlayerState.NOT_IN_COVER;
		this.perception = perception;
		this.organization = org;
		this.dexterity = dex;
		this.shooting = shooting;
		this.hp = hp;
		this.weapon = weapon;
	}
}
