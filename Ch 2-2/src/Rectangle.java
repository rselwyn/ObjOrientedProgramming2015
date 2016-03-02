
public class Rectangle extends Shape {
	private double width = 1.0;
	private double length = 1.0;
	
	/**
	 * Call the super constructor only.
	 */
	public Rectangle() {
		super();
	}
	
	/**
	 * Sets the length and the width
	 * @param width: the width
	 * @param length: the length
	 */
	public Rectangle (double width, double length) {
		super();
		setWidth(width);
		setLength(length);
	}
	
	/**
	 * To string method.
	 */
	@Override
	public String toString() {
		return "Rectangle with width=" + getWidth() + "and length=" + getLength() + ", which is a subclass of " +super.toString();
	}

	/**
	 * Set all the instance variables.
	 * @param width: the width
	 * @param length: the length
	 * @param color: the color
	 * @param filled: filled or not
	 */
	public Rectangle (double width, double length, String color, boolean filled) {
		setWidth(width);
		setLength(length);
		setColor(color);
		setFilled(filled);
	}
	
	/**
	 * get the area
	 * @return the area of the rectangle
	 */
	public double getArea() {
		return getWidth() * getLength();
	}
	
	/**
	 * Gets the perimeter
	 * @return: the perimeter of the rectangle
	 */
	public double getPerimeter() {
		return 2 * getWidth() * getLength();
	}
	
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
}
