
public class MyPoint {
	private int x;
	private int y;
	
	/*
	 * No argument constructor that sets the point at (0,0)
	 */
	public MyPoint(){
		setXY(0,0);
	}
	
	/*
	 * The constructor that sets the point at a given point, passed through parameters
	 * @param x: the x coordinate
	 * @param y: the y coordinate
	 */
	public MyPoint(int x, int y){
		//Set x and y
		setXY(x,y);
	}
	
	
	
	/*
	 * Set the coordinates
	 * @param x: the x coordinate
	 * @param y: the y coordinate
	 */
	public void setXY(int x, int y){
		setX(x);
		setY(y);
	}
	
	/*
	 * @param x: the x coordinate
	 */
	public void setX(int x){
		this.x = x;
	}
	
	/*
	 * @param y: the y value
	 */
	public void setY(int y){
		this.y = y;
	}
	
	/*
	 * @return x: the x instance variable
	 */
	public int getX(){
		return this.x;
	}
	
	/*
	 * @return y: the y instance variable
	 */
	public int getY(){
		return this.y;
	}
	
	/*
	 * toString method
	 */
	public String toString(){
		return "("+this.x+","+this.y+")";
	}
	
	/*
	 * Returns the distance of two points
	 * @param x: the x value
	 * @param y: the y value
	 */
	public double distance(int x , int y){
		double xDiff = getX() - x;
		double yDiff = getY() - y;
		xDiff = xDiff*xDiff;
		yDiff = yDiff*yDiff;
		return Math.sqrt(xDiff+yDiff);
	}
	/*
	 * @param point: a point object to find the distance from
	 */
	public double distance(MyPoint point){
		return distance(point.getX(),point.getY());
	}
	
}
