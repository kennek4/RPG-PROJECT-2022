package stuff2;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface PlayerAction {
	void executeAction();
}

public class HeartBeat implements Runnable{
	
	
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
	private int combatDistance;
	private int baseDistance;
	
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
		
		// Creating the JFrame
		System.out.println(pState);

		// Prints they enemy's initial state
		System.out.println(eState);
		System.out.println(eState.stateDialogue());
		
		
	}
	
	private void enemyAttack() throws InterruptedException {
		
	}
	
	
	public void combatCycle() {

	}
	
	public void nonCombatCycle() {
		// Decides whether or not the enemy is looking in your direction.
		if (r.nextBoolean()) {
			System.out.println(eState.stateDialogue());
			eState = eState.nextState();
			// print transition dialogue.
			System.out.println();
		}
	}

	@Override
	public void run() {
		Timer timer = new Timer(5500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (hbState == HeartBeat.State.COMBAT) {
					combatCycle();
				} else {
					
				}
			}
		});
		
		timer.start();
	}
}
