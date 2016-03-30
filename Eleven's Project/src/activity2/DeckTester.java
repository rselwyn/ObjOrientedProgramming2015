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
}
