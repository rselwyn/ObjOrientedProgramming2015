package activity3;

import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {4,2,3,1};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values1 = perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values2 = selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] perfectShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		int iterValue = 0;
		
		if (values.length%2==1){
			// odd length algorithim
			for (int firstIter = 0; firstIter < (values.length + 1)/2; firstIter++){
				shuffled[iterValue] = values[firstIter];
				iterValue+=2;
			}
			iterValue = 1;
			for (int secondIter = (values.length+1)/2; secondIter < values.length; secondIter++) {
				shuffled[iterValue] = values[secondIter];
				iterValue+=2;
			}
			
		}
		else {
			// even length algorithim
			for (int firstIter = 0; firstIter < values.length/2; firstIter++){
				shuffled[iterValue] = values[firstIter];
				iterValue+=2;
			}
			iterValue = 1;
			for (int secondIter = values.length/2; secondIter < values.length; secondIter++) {
				shuffled[iterValue] = values[secondIter];
				iterValue+=2;
			}
			
		}
		
		return shuffled;
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] selectionShuffle(int[] values) {
		Random rand = new Random();
		int[] shuffled = new int[values.length];
		for (int i = 0; i < values.length-1; i++) {
			int rnged = rand.nextInt(values.length-i);
			while(values[rnged] < -1) {
				rnged = rand.nextInt(values.length-i);
			}
			shuffled[i] = values[rnged];
			values[rnged] = -2;
		}
		return shuffled;
	}
	

}
