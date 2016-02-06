/*
 * SOLUTION to 1.11
 * This code is similar to the regular book class (from 1.2),
 * but can hold authors as an array (passed in the constructor).
 * It uses a for-each loop to print the authors.
 * 
 */
public class TestBook {

	public static void main(String[] args) {
		//Construction using anonymous Author
		
		// Declare and allocate an array of Authors
		Author[] authors = new Author[2];
		authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
		authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');
		 
		// Declare and allocate a Book instance
		Book javaDummy = new Book("Java for Dummy", authors, 19.99, 99);
		System.out.println(javaDummy);  // toString()
		System.out.println("The authors are: ");
		javaDummy.printAuthors();
	}

}
