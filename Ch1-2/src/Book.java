
public class Book {
	/*
	 * Instance variables
	 */
	private String name;
	private Author author;
	private double price;
	private int qtyInStock;
	
	/*
	 * Constructor #1 for book
	 */
	public Book(String name, Author author, double price){
		this.name = name;
		this.author = author;
		setPrice(price);
	}
	
	/*
	 * Constructor #2 for book
	 */
	public Book(String name, Author author, double price, int quantity){
		this.name = name;
		this.author = author;
		setPrice(price);
		setQuantity(quantity);
	}
	
	
	/*
	 * @return the book name
	 */
	public String getName(){
		return this.name;
	}
	
	/*
	 * @return the Author (object)
	 */
	public Author getAuthor(){
		return this.author;
	}
	
	/*
	 * @return the price of the book
	 */
	public double getPrice(){
		return this.price;
	}
	
	/*
	 * @return the number of the books in stock
	 */
	public int getStock(){
		return this.qtyInStock;
	}
	
	/*
	 * @param price: the price to set for the book
	 */
	public void setPrice(double price){
		this.price = price;
	}
	
	/*
	 * @param quantity: the book quantity
	 */
	public void setQuantity(int quantity){
		this.qtyInStock = quantity;
	}
}
