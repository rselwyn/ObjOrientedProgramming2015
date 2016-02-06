
public class Book {
	/**
	 * Instance variables
	 */
	private String name;
	private double price;
	private int qtyInStock;
	private int numAuthors = 0;
	private Author[] authors = new Author[5];
	
	/**
	 * Constructor #1 for book
	 */
	public Book(String name, Author[] authors, double price){
		this.name = name;
		this.authors = authors;
		setPrice(price);
	}
	
	/**
	 * Constructor #2 for book
	 */
	public Book(String name, Author[] authors, double price, int quantity){
		this.name = name;
		this.authors = authors;
		setPrice(price);
		setQuantity(quantity);
	}
	
	
	/**
	 * @return the book name
	 */
	public String getName(){
		return this.name;
	}
	
	
	/**
	 * @return the price of the book
	 */
	public double getPrice(){
		return this.price;
	}
	
	/**
	 * @return the number of the books in stock
	 */
	public int getStock(){
		return this.qtyInStock;
	}
	
	/**
	 * @param price: the price to set for the book
	 */
	public void setPrice(double price){
		this.price = price;
	}
	
	/**
	 * @param quantity: the book quantity
	 */
	public void setQuantity(int quantity){
		this.qtyInStock = quantity;
	}
	
	/**
	 * Return the authors array
	 * @return the authors
	 */
	public Author[] getAuthors(){
		return this.authors;
	}
	
	/**
	 * Print the authors
	 */
	public void printAuthors(){
		for (Author a : getAuthors()) System.out.println(a);
	}
	
	/**
	 * Add an author to the array
	 * @param a: the author
	 */
	public void addAuthor(Author a){
		authors[numAuthors] = a;
		numAuthors++;
	}
	
	/**
	 * Tries to remove an author from the array
	 * @param a: the author
	 * @return the success of removing an author
	 */
	public boolean removeAuthor(Author a){
		for (int i = 0; i < 5; i++){
			try{
				if (authors[i].getEmail() == a.getEmail() && authors[i].getName() == a.getName()){
					authors[i] = null;
					return true;
				}
			}
			catch(Exception e){
				
			}
		}
		return false;
	}
}
