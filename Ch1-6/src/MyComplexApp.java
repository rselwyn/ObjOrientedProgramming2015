import java.util.*;
/*
 * This app follows the specification online.
 */
public class MyComplexApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyComplex num1 = getNewComplex(); //get num1
		MyComplex num2 = getNewComplex(); //get num2
		
		/*
		 * Requirements for num1
		 */
		System.out.println("Number 1 is: " + num1);
 		String is = !num1.isReal() ? "NOT" : "";
		System.out.println(num1 + " is " + is + " a pure real number.");
		is = !num1.isImaginary() ? "NOT" : "";
		System.out.println(num1 + " is " + is + " a pure imaginary number.\n");
		
		/*
		 * Requirements for num2
		 */
		System.out.println("Number 2 is: " + num2);
 		is = !num2.isReal() ? "NOT" : "";
		System.out.println(num2 + " is " + is + " a pure real number.");
		is = !num2.isImaginary() ? "NOT" : "";
		System.out.println(num2 + " is " + is + " a pure imaginary number.\n");
		
		is = num1.equals(num2) ? "" : "NOT";
		System.out.println(num1 + "is " + is + " equal to" + num2);
		System.out.println(num1 + "+" + num2 +" = " + num1.add(num2));
		System.out.println(num1 + "-" + num2 +" = " + num1.subtact(num2));
		
	}
	//Abstraction of getting a new complex
	private static MyComplex getNewComplex(){
		Scanner scan = new Scanner(System.in); //Scanner object
		System.out.println("Enter a complex number (real and imaginary part).  Press enter in between the real and complex part.");
		return new MyComplex(scan.nextDouble(),scan.nextDouble());
	}

}
