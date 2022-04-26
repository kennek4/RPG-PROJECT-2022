package stuff2;


public class HeartBeatDriver {
	public static void main(String[] args) {
		Player player = new Player(100, 8);
		Enemy enemy = new Enemy(100, 20);
		
		InputDriver inputDriver = new InputDriver();
		HeartBeat hb = new HeartBeat(player, enemy, inputDriver);
		hb.inputDriver.hb = hb;
		
		Thread hbThread = new Thread(hb);
		hbThread.start();
		
	}
}
