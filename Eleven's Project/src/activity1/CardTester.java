package activity1;
/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card first = new Card("King", "Hearts", 13);
		Card second = new Card("Queen", "Hearts", 12);
		Card third = new Card("King", "Hearts", 13);
		
		System.out.println(first.matches(second) + " <<<< false");
		System.out.println(second.matches(second) + " <<<< true");
		System.out.println(third.pointValue());
		System.out.println(first.suit());
	}
}
