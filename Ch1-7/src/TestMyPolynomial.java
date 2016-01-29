/**
 * This code has been written to satisfy the assignment 1.7
 * I wrote MyPolynomial, and the test class TestMyPolynomial.
 * This class is designed to take in a polynomial as such
 *  a polynomial 3x^2+2x^1+3 should be instantiated with 
 *   new MyPolynomial(3,2,3);
 *   
 * I'm not sure if this is written correctly because Mr. Kuszmaul mentioned that the input
 * should be the other way around.
 *
 */
public class TestMyPolynomial {
	
	public static void main(String[] args){
		MyPolynomial poly = new MyPolynomial(1,2,3,4,5);
		System.out.println(poly);// Test to string
		System.out.println(poly.evaluate(1)); //Test evaluate
		System.out.println(poly.add(new MyPolynomial(1,2,3,4,5))); // test add
		
		System.out.println("\n\nTesting Adding");
		
		MyPolynomial addTest = new MyPolynomial(2,3);
		System.out.println(addTest);
		System.out.println(new MyPolynomial(3,4,5,6));
		System.out.println(addTest.add(new MyPolynomial(3,6,4,5)));
		
		System.out.println("\n\nTesting multiplying");
		System.out.println(new MyPolynomial(1,2).multiply(new MyPolynomial(1,2)));
		System.out.println(new MyPolynomial(4,5,6).multiply(new MyPolynomial(6,7,9,8)));
	}

}
