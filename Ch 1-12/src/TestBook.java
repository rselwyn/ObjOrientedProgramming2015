/*
 * SOLUTION to 1.12.
 * This works by first creating a book,
 * then it prints the book's authors out.
 * It then tries to remove it.
 * The line below "Should be null" should be null
 */
public class TestBook {

	public static void main(String[] args) {
		Author[] authors = new Author[]{new Author("Author", "Email", "m".charAt(0))};
		Book b1 = new Book("Book Name", authors, 0);
		System.out.println("Current Authors:");
		b1.printAuthors();
		b1.removeAuthor(new Author("Author", "Email", "m".charAt(0))); //test removal
		System.out.println("Should be null:");
		b1.printAuthors();
	}

}
