
public class Main {

	public static void main(String[] args) {
		
		GUI gui = GUI.getInstance(); // Initializes our GUI. Creates an instance on first one then instance is accessible everywhere
		gui.initializeGUI();
		
		GamePlay game = new GamePlay();
		game.run();
	}

}
