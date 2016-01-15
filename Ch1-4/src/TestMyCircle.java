
public class TestMyCircle {

	public static void main(String[] args) {
		//Create circle with an anonymous instance of MyPoint
		MyCircle circle = new MyCircle(new MyPoint(2,2),3);
		System.out.println(circle.getArea()); //get the area
		System.out.println(circle.getCenterX()+","+circle.getCenterY());
		
	}

}
