
public class MyPoint {
	private int x;
	private int y;
	
	/*
	 * No argument constructor that sets the point a t (0,0)
	 */
	public MyPoint(){
		setXY(0,0);
	}
	
	/*
	 * The constructor that sets the point at a given point
	 */
	public MyPoint(int x, int y){
		//Set x and y
		setXY(x,y);
	}
	
	
	
	/*
	 * Set the coordinates
	 * @param x: the x coordinate
	 * @param yL the y coordinate
	 */
	public void setXY(int x, int y){
		setX(x);
		setY(y);
	}
	
	/*
	 * @param x
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
	
	public double distance(int x , int y){
		double xDiff = getX() - x;
		double yDiff = getY() - y;
		return Math.pow((Math.pow(xDiff, 2.0) + Math.pow(yDiff, 2)),1/2);
	}
	
	public double distance(MyPoint point){
		return distance(point.getX(),point.getY());
	}
	
}
