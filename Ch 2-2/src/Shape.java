
public class Shape {
	private String color = "red";
	private boolean filled = true;
	
	/**
	 * No argument constuctor.
	 */
	public Shape(){
		setColor("Green");
		setFilled(false);
	}
	
	/**
	 * Constructor that sets all the instance variables.
	 * @param color: the color
	 * @param filled: filled or not
	 */
	public Shape(String color, boolean filled){
		setColor(color);
		setFilled(filled);
	}
	
	/**
	 * To string method
	 */
	public String toString() {
		return "A shape with color of " + getColor() + " and " + (isFilled() ? "filled" : "not filled");
	}
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return filled or not
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * @param color: the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @param filled: the filled to set
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	
	
}
