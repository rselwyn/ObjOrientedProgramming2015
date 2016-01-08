
public class MyCircle {
	private MyPoint center;
	private int radius;
	
	
	public MyCircle(int x, int y, int radius){
		setRadius(radius);
		setCenterXY(x,y);
	}
	
	public MyCircle(MyPoint center, int radius){
		setRadius(radius);
		setCenter(center);
	}
	
	/*
	 * @return the radius
	 */
	public int getRadius(){
		return this.radius;
	}
	/*
	 * Set the radius
	 * @param the radius
	 */
	public void setRadius(int radius){
		this.radius = radius;
	}
	
	/*
	 * @return the center object
	 */
	public MyPoint getCenter(){
		return this.center;
	}
	/*
	 * @param point: the center point
	 */
	public void setCenter(MyPoint point){
		this.center = point;
	}
	
	/*
	 * @return the center of the circle (x coordinate)
	 */
	public int getCenterX(){
		return this.center.getX();
	}
	
	/*
	 * @return the center of the circle (y coordinate)
	 */
	public int getCenterY(){
		return this.center.getY();
	}
	
	/*
	 * @param x: the x coordinate
	 * @param y: the y coordinate 
	 */
	public void setCenterXY(int x, int y){
		this.center = new MyPoint(x,y);
	}
	
	/*
	 * @return the toString specified online
	 */
	public String toString(){
		return "Circle * ("+getCenterX()+","+getCenterY()+") radius="+getRadius();
	}
	
	/*
	 * @return the area of the triangle
	 */
	public double getArea(){
		return getRadius()*getRadius()*Math.PI;
	}
	
	
}
