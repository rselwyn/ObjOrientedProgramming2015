
public class MyTriangle {
	private MyPoint v1;
	private MyPoint v2;
	private MyPoint v3;
	
	/*
	 * The constructor which takes integer points
	 * @param x1: the first x coordinate
	 * @param x2: the second x coordinate
	 * @param x3: the third x coordinate
	 * @param y1: the first y coordinate
	 * @param y2: the second y coordinate
	 * @param y3: the third y coordinate
	 */
	public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
		this.v1 = new MyPoint(x1,y1);
		this.v2 = new MyPoint(x2,y2);
		this.v3 = new MyPoint(x3,y3);
	}
	
	/*
	 * Takes in points as point objects
	 * @param v1: the first point of the triangle
	 * @param v2: the second point of the triangle
	 * @param v3: the third point of the triangle
	 */
	public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	/*
	 * @return the perimeter of the triangle
	 */
	public double perimeter(){
		System.out.println(v1.distance(v2) +" " +  v2.distance(v3) + " "+ v3.distance(v1));
		return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
	}
	
	/*
	 * @return the requested toString
	 */
	public String toString(){
		return "Triangle @ ("+this.v1.getX()+","+this.v1.getY()+"), (" + this.v2.getX() +"," + this.v2.getY() + "), ("+this.v3.getX()+","+this.v3.getY()+")" ;
	}
	
	public void printType(){
		if (v1.distance(v2) == v2.distance(v3) && v2.distance(v3) == v3.distance(v1)){
			System.out.println("This triangle is Equilateral");
		}
		else if (v1.distance(v2) == v2.distance(v3) || v2.distance(v3) == v3.distance(v1)){
			System.out.println("This triangle is Isoceles");
		}
		else{
			System.out.println("The triangle is scalene.");
		}
	}
}
