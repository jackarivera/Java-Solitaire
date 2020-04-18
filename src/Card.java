import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card {

	private int CARD_VALUE; // 1-13  | 1 = Ace | 11 = Jack | 12 = Queen | 13 = King
	private int CARD_SUIT; // 1-4 | 1 = Diamonds | 2 = Hearts  | 3 = Clubs | 4 = Spades
	private boolean CARD_VISIBLE; // Determines whether the card will return the back side of card (false) or the card front (true)
	private ImageIcon CARD_IMAGE_FRONT;
	private ImageIcon CARD_IMAGE_BACK;
	
	public Card(int CARD_VALUE, int CARD_SUIT) {
		this.CARD_VALUE = CARD_VALUE;
		this.CARD_SUIT = CARD_SUIT;
		
		CARD_VISIBLE = true;
		CARD_IMAGE_FRONT = new ImageIcon("resources/" + getFileName(CARD_VALUE, CARD_SUIT) + ".png");
		CARD_IMAGE_BACK = new ImageIcon("resources/back@2x.png");
	}
	
	private String getFileName(int CARD_VALUE, int CARD_SUIT) {
		String s = "";
		if (CARD_VALUE == 1)
			s += "ace";
		else if (CARD_VALUE == 11)
			s += "jack";
		else if (CARD_VALUE == 12)
			s += "queen";
		else if (CARD_VALUE == 13)
			s += "king";
		else if (CARD_VALUE > 1 && CARD_VALUE < 11)
			s += CARD_VALUE;
		else 
			return "error";
		
		s += "_of_";
		
		if (CARD_SUIT == 1)
			s += "diamonds";
		else if (CARD_SUIT == 2)
			s += "hearts";
		else if (CARD_SUIT == 3)
			s += "clubs";
		else if (CARD_SUIT == 4)
			s += "spades";
		else
			return "error";
		
		return s;
	}
	
	/*
	 * Gets the card's numerical value in the form of a string
	 * Returns A, 2-10, J, Q, K 
	 */
	public String getCardValueString() {
		switch(CARD_VALUE) {
			case 1:
				return "A";
			case 2:
				return "2";
			case 3:
				return "3";
			case 4:
				return "4";
			case 5:
				return "5";
			case 6:
				return "6";
			case 7:
				return "7";
			case 8:
				return "8";
			case 9:
				return "9";
			case 10:
				return "10";
			case 11:
				return "J";
			case 12:
				return "Q";
			case 13:
				return "K";
			default: 
				return "Error! Card.java getCardValueString()";
		}
	}
	
	/*
	 * Returns the numerical card value
	 */
	public int getCardValue() {
		return CARD_VALUE;
	}
	
	/*
	 * Returns the card suit in the form of a string
	 */
	public String getCardSuitString() {
		switch (CARD_SUIT) {
			case 1:
				return "Diamonds";
			case 2:
				return "Hearts";
			case 3:
				return "Clubs";
			case 4:
				return "Spades";
			default:
				return "Error! Card.java getCardSuitString()";
		}
	}
	
	/*
	 * Returns the numerical value of the card's suit
	 */
	public int getCardSuit() {
		return CARD_SUIT;
	}
	
	/*
	 * Returns the cards image icon to be used in a button
	 */
	public ImageIcon getCardImage() {
		if (CARD_VISIBLE)
			return CARD_IMAGE_FRONT;
		else
			return CARD_IMAGE_BACK;
	}
	
	/*
	 * Returns a button filled with the current card
	 */
	public JButton getCardButton() {
		JButton jb = new JButton();
		
		jb.setSize(Global.CARD_BUTTON_WIDTH, Global.CARD_BUTTON_HEIGHT);
		jb.setIcon(new ImageIcon(getCardImage().getImage().getScaledInstance(Global.CARD_BUTTON_WIDTH, Global.CARD_BUTTON_HEIGHT, java.awt.Image.SCALE_SMOOTH)));
		
		return jb;
	}
}
