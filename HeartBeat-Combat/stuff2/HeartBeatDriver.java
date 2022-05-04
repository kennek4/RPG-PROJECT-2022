package stuff2;


public class HeartBeatDriver {
	public static void main(String[] args) {
		Weapon m4a1 = new Weapon("M4A1", 32, 40, 20);
		Player player = new Player(200, 5, 8, 7, 5, m4a1);
		Enemy enemy = new Enemy(200, 20);
		
		InputDriver inputDriver = new InputDriver();
		UI window = new UI(inputDriver);
		
		HeartBeat hb = new HeartBeat(player, enemy, inputDriver, 0);
		hb.inputDriver.hb = hb;
		
		Thread hbThread = new Thread(hb);
		hbThread.start();
	}
}
