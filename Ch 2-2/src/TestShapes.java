
/**
 * I wrote all the code specified online.  This test class
 * tests the methods in the other classes. All the documentation
 * are in javadocs before the methods.
 */

public class TestShapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Square(2));
		System.out.println(new Circle());
		System.out.println(new Square(5).getArea() + " <<<<<< SHOULD BE 25.0");
		System.out.println(new Circle(10).getPerimeter() + " <<<<<< SHOULD BE 62.83");
		System.out.println(new Circle(100).getArea() + " <<<<<< SHOULD BE 31415.9265...");
	}

}
