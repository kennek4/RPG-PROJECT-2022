package stuff2;

public class Enemy {
	static enum EnemyState {
		LOOKING {
			@Override
			public EnemyState nextState() {
				return NOT_LOOKING;
			}

			@Override
			String stateDialogue() {
				// TODO Auto-generated method stub
				return "*Looks in your direction*";
			}
		},
		
		NOT_LOOKING {
			@Override
			public EnemyState nextState() {
				return LOOKING;
			}

			@Override
			String stateDialogue() {
				return "*Looks away*";
			}
		};
		abstract EnemyState nextState();
		abstract String stateDialogue();
	}
	private int hp,dmg;
	
	public Enemy(int hp, int dmg) {
		this.hp = hp;
		this.dmg = dmg;
	}
}
