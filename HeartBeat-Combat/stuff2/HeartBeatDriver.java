package stuff2;

public class HeartBeatDriver {
	public static void main(String[] args) {
		Weapon m4a1 = new Weapon("M4A1", 15, 85, 20, 30, 5);
		Weapon ak12 = new Weapon("AK-12", 12, 80, 30, 30, 3);
		Armour class4Armour = new Armour(4, 0.45);
		Player player = new Player(200, 5, 8, 7, 5, m4a1, class4Armour);
		Enemy enemy = new Enemy(200, 5, ak12, class4Armour);

		InputDriver inputDriver = new InputDriver();

		HeartBeat hb = new HeartBeat(player, enemy, inputDriver, 0);
		hb.inputDriver.hb = hb;

		UI window = new UI(inputDriver, hb);
		hb.ui = window;

		Thread gameWindow = new Thread(window);
		Thread hbThread = new Thread(hb);
		gameWindow.start();
		hbThread.start();
	}
}
