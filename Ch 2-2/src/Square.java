
public class Square extends Rectangle {
	
	/**
	 * No arg constructor that calls the super constructor to set the other variables.
	 */
	public Square() {
		super();
	}
	
	/**
	 * Takes in the side and creates a square with it.
	 * @param side: the side length of a square.
	 */
	public Square(double side) {
		super(side,side);
	}
	
	/**
	 * Sets the length.
	 */
	@Override
	public void setLength(double side) {
		super.setLength(side);
		super.setWidth(side);
	}
	
	/**
	 * Sets the width.
	 */
	@Override
	public void setWidth(double side) {
		super.setLength(side);
		super.setWidth(side);
	}
	
	/**
	 * To string method defined online.
	 */
	public String toString() {
		return "A square with side="+getWidth()+", which is a subclass of " + super.toString();
	}
}
