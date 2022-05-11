package stuff2;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputDriver implements KeyListener {

	public HeartBeat hb;

	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char key = e.getKeyChar();
		// if (key == KeyEvent.VK_1) {
		// hb.pState = hb.pState.nextState();
		// hb.currentState();
		// }
	}
}
