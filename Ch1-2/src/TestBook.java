/*
 * SOLUTION to 1.2
 */
public class TestBook {

	public static void main(String[] args) {
		//Construction using anonymous Author
		Book aBook = new Book("Of Mice and Men", new Author("Of Mice and Men", "johnsteibeck@gmail.com", "m".charAt(0)), 2,2);
		//Print the book
		System.out.println(aBook.getName());
		//Get  the stock number
		System.out.println(aBook.getStock());
		//Other constructor
		Book a = new Book("Of Mice and Men", new Author("Of Mice and Men", "johnsteibeck@gmail.com", "m".charAt(0)), 2);
	}

}
