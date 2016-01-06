/*
 * README:
 * I took the exercises from online, and I made all the edits required.
 * I did the following
 * 		-Added standard comments
 *  	-Added public setter methods
 *  	-Added toString() method
 *  	-Added "this" to specify instance variables
 */
public class CircleTest {

	public static void main(String[] args) {
		//Create a new circle
		Circle ci = new Circle(10,"Black");
		//Print the area
		System.out.println(ci.getArea());
		//Set it to a new radius
		ci.setRadius(20.0);
		//Print the new area
		System.out.println(ci.getArea());
		//Implicit call to toString()
		System.out.println(ci);
		
	}

}
