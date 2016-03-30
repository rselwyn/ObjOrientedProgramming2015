package activity2;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"Queen", "King"};
		String[] suit = {"Spade", "Heart"};
		int[] vals = {12,13};
		Deck d = new Deck(ranks,suit,vals);
		System.out.println(d);
	}
	
	public static Deck initializeTwentyOneDeck() {
		String[] ranks = {"Two","Three", "Four", "Five", "Size", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace","Two","Three", "Four", "Five", "Size", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace","Two","Three", "Four", "Five", "Size", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace","Two","Three", "Four", "Five", "Size", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace"};
		String[] suits = new String[52];
		for (int i=0;i<13;i++) suits[i] = "Hearts";
		for (int i=13;i<26;i++) suits[i] = "Diamonds";
		for (int i=26;i<39;i++) suits[i] = "Spades";
		for (int i=39;i<52;i++) suits[i] = "Clubs";
		int[] vals = {2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14};
		return new Deck(ranks,suits,vals);
		
	}
}
