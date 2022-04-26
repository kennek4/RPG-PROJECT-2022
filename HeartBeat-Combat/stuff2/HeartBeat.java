package stuff2;

import javax.swing.Timer;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface PlayerAction {
	void executeAction();
}

public class HeartBeat implements Runnable{
	
	// Declaring variables
	private Random r = new Random();
	public Player player;
	public Player.PlayerState pState;
	public Enemy enemy;
	public Enemy.EnemyState eState;
	private JFrame root;
	public InputDriver inputDriver;
	
	public HeartBeat(Player player, Enemy enemy, InputDriver inputDriver) {
		
		this.eState = Enemy.EnemyState.NOT_LOOKING;
		this.pState = Player.PlayerState.NOT_IN_COVER;
		this.player = player;
		this.enemy = enemy;
		this.inputDriver = inputDriver;
		
		// Creating the JFrame
		System.out.println(pState);
		root = new JFrame("HeartBeat test");
		root.setSize(new Dimension(500,500));
		root.setLocationRelativeTo(null);
		root.addKeyListener(inputDriver);
		root.setVisible(true);
		
		// Prints they enemy's initial state
		System.out.println(eState);
		System.out.println(eState.stateDialogue());
	}
	
	public void combatCycle() {
		
		// Enemy random state change
		if (r.nextBoolean()) {
			System.out.println(eState);
			System.out.println(eState.stateDialogue());
			eState = eState.nextState();
			System.out.println();
		}
	}

	@Override
	public void run() {
		Timer timer = new Timer(5500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combatCycle();
				System.out.println(pState);
			}
		});
		
		timer.start();
	}
}
