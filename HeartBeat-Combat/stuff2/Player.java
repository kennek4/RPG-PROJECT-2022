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
	private int hp, perception;
	
	
	public Player(int hp, int perception) {
		this.playerState = PlayerState.NOT_IN_COVER;
		this.hp = hp;
		this.perception = perception;
	}
}
