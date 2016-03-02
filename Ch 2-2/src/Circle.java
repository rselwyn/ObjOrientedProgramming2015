
public class Circle extends Shape{
	private double radius = 1d;
	
	/**
	 * No-argument constructor.  Sets the radius to 1.0 automatically.
	 */
	public Circle() {
		super();
		setRadius(1.0);
	}
	
	/**
	 * Sets the color, radius, and filled.
	 * @param radius: the radius
	 * @param color: the color
	 * @param filled: the filled status
	 */
	public Circle(double radius, String color, boolean filled){
		setFilled(filled);	
		setRadius(radius);
		setColor(color);
	}
	
	/**
	 * Constructor sets the radius.
	 * @param radius: the radius
	 */
	public Circle(double radius){
		super();
		setRadius(radius);
	}
	
	/**
	 * Set the radius
	 * @param radius: the radius to set
	 */
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	/**
	 * Gets the radius
	 * @return the radius
	 */
	public double getRadius(){
		return this.radius;
	}
	
	/**
	 * Get the perimeter
	 * @return the perimeter of the circle
	 */
	public double getPerimeter() {
		return Math.PI * getRadius() * 2;
	}
	
	/**
	 * Get the area
	 * @return the area
	 */
	public double getArea(){
		return Math.PI * Math.pow(getRadius(), 2);
	}
	
	/**
	 * The toString method.
	 */
	@Override
	public String toString(){
		return "A circle with radius="+getRadius()+", which is a subclass of " + super.toString();
	}
}
