
public class Book {
	/**
	 * Instance variables
	 */
	private String name;
	private double price;
	private int qtyInStock;
	private Author[] authors;
	
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
}
