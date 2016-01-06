
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
