package game.logic;

public class Launcher {
	
	public static void main(String args[]) {
		new Thread(new Game()).start();
	}
}
