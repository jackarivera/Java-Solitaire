import javax.swing.*;

public class GUI {

	
	private static volatile GUI instance;
	
	/*
	 * GUI Members. Public so they can be accessed by gameplay class for ease.
	 *
	 */
	public JFrame window;
	
	public void initializeGUI() {
		window = new JFrame();
		window.setSize(1280,720);//400 width and 500 height  
		window.setLayout(null);//using no layout managers  
		window.setVisible(true);//making the frame visible  
		window.setResizable(false);
	}
	
	
	/**
	 * Singleton setup of instance
	 * @return The master GUI instance
	 */
	public static GUI getInstance() {
		if (instance == null)
			instance = new GUI();
		return instance;
	}
}
