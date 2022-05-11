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

	public int hp, dmg, dexterity;

	public Enemy(int hp, int dmg, int dexterity) {
		this.hp = hp;
		this.dmg = dmg;
		this.dexterity = dexterity;
	}
}
