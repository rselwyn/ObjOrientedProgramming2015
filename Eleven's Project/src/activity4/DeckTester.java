package activity4;


/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red", "red"};
		int[] pointValues = {11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);
		
		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		String[] ranksTwo = {"Two","Three", "Four", "Five", "Size", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace","Two","Three", "Four", "Five", "Size", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace","Two","Three", "Four", "Five", "Size", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace","Two","Three", "Four", "Five", "Size", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace"};
		String[] suitsTwo = new String[52];
		for (int i=0;i<13;i++) suitsTwo[i] = "Hearts";
		for (int i=13;i<26;i++) suitsTwo[i] = "Diamonds";
		for (int i=26;i<39;i++) suitsTwo[i] = "Spades";
		for (int i=39;i<52;i++) suitsTwo[i] = "Clubs";
		int[] vals = {2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14};
		Deck de = new Deck(ranksTwo,suitsTwo,vals);
		System.out.println(de);
	}
}
