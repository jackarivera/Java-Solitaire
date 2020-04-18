import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePlay {

	private GUI gui;
	private int WindowX;
	private int WindowY;
	
	private ArrayList<Card> deckofcards = new ArrayList<>(
			Arrays.asList(
					new Card(1,1), 
					new Card(1,2),
					new Card(1,3),
					new Card(1,4), 
					new Card(2,1), 
					new Card(2,2),
					new Card(2,3),
					new Card(2,4), 
					new Card(3,1), 
					new Card(3,2),
					new Card(3,3),
					new Card(3,4),
					new Card(4,1), 
					new Card(4,2),
					new Card(4,3),
					new Card(4,4),
					new Card(5,1), 
					new Card(5,2),
					new Card(5,3),
					new Card(5,4), 
					new Card(6,1), 
					new Card(6,2),
					new Card(6,3),
					new Card(6,4),
					new Card(7,1), 
					new Card(7,2),
					new Card(7,3),
					new Card(7,4),
					new Card(8,1), 
					new Card(8,2),
					new Card(8,3),
					new Card(8,4),
					new Card(9,1), 
					new Card(9,2),
					new Card(9,3),
					new Card(9,4),
					new Card(10,1), 
					new Card(10,2),
					new Card(10,3),
					new Card(10,4),
					new Card(11,1), 
					new Card(11,2),
					new Card(11,3),
					new Card(11,4), 
					new Card(12,1), 
					new Card(12,2),
					new Card(12,3),
					new Card(12,4), 
					new Card(13,1), 
					new Card(13,2),
					new Card(13,3),
					new Card(13,4)
					));
	
	private ArrayList<ArrayList<Card>> gamePiles;
	private ArrayList<Card> pileOne;
	private ArrayList<Card> pileTwo;
	private ArrayList<Card> pileThree;
	private ArrayList<Card> pileFour;
	private ArrayList<Card> pileFive;
	private ArrayList<Card> pileSix;
	private ArrayList<Card> pileSeven;
	
	public GamePlay() {
		gui = GUI.getInstance();
		
		WindowX = gui.window.getWidth();
		WindowY = gui.window.getHeight();
		
		pileOne = new ArrayList<>();
		pileTwo = new ArrayList<>();
		pileThree = new ArrayList<>();
		pileFour = new ArrayList<>();
		pileFive = new ArrayList<>();
		pileSix = new ArrayList<>();
		pileSeven = new ArrayList<>();
		
		
		gamePiles = new ArrayList<>(Arrays.asList(pileOne, pileTwo, pileThree, pileFour, pileFive, pileSix, pileSeven));
	}
	
	
	public void run() {
		initCards();
		initStartScreen();
	}
	
	private void initStartScreen() {
		JLabel startTitle = new JLabel("Solitaire! by Jack");
		startTitle.setBounds(WindowX / 2 - 50, WindowY / 2 - 100, 100, 50);
		
		JButton startButton = new JButton("Start Game");
		startButton.setBounds(WindowX / 2 - 100, WindowY / 2, 200, 	50);
		
		gui.window.add(startTitle);
		gui.window.add(startButton);

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.window.remove(startTitle);
				gui.window.remove(startButton);
				initGameScreen();
				gui.window.repaint();
			}
		});
		gui.window.repaint();
	}
	
	private void initGameScreen() {
		JLabel cardDeckLabel = new JLabel("Card Deck");
		cardDeckLabel.setBounds(WindowX * 1/9 - 75, 10, 100, 25);
		
		JLabel gamePileLabel = new JLabel("Game Piles");
		gamePileLabel.setBounds(WindowX * 1/2 - 25, 10, 100, 25);
		
		JLabel acePileLabel = new JLabel("Ace Piles");
		acePileLabel.setBounds(WindowX * 8/9 , 10, 100, 25);
		
		gui.window.add(cardDeckLabel);
		gui.window.add(gamePileLabel);
		gui.window.add(acePileLabel);
	}
	
	private void initCards() {
		Collections.shuffle(deckofcards);
		dealCards();
	}
	
	private void dealCards() {
		int pileNumber = 0;
		for (ArrayList<Card> p : gamePiles) {
			pileNumber++;
			for (int i = 0; i < pileNumber; i++) {
				p.add(deckofcards.get(0));
				deckofcards.remove(0);
				System.out.print(p.get(i).getCardValueString() + "_" + p.get(i).getCardSuitString() + ", ");
			}
			System.out.println();
		}
	}
	
}
