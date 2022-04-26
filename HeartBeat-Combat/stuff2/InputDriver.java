package stuff2;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputDriver implements KeyListener {
	
	public HeartBeat hb;
	
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		if (key == KeyEvent.VK_1) {
			System.out.println("You pressed 1");
			hb.pState = hb.pState.nextState();
			System.out.println(hb.pState);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
