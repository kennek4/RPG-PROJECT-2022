package CombatFiles;

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

	int hp, dexterity;
	Weapon weapon;
	Armour armour;
	String name;

	public Enemy(String name, int hp, int dexterity, Weapon weapon, Armour armour) {

		this.name = name;
		this.hp = hp;
		this.dexterity = dexterity;

		this.weapon = weapon;
		this.armour = armour;
	}
}
