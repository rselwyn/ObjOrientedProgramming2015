/*
 * I followed the assignment by doing the following:
 *  -Write the MyComplex class
 *  -Write a test program
 *  -Write an app MyComplexApp that uses MyComplex
 *  
 *  I decided, due to the suggestion from the website, to make multiply with and 
 *  divide with produce new instances, rather than modifying the current instance.
 */
public class TestMyComplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyComplex complex = new MyComplex(2,3);
		System.out.println(complex.argumentInDegrees()); //test argument in degrees
		System.out.println(complex.argumentInRadians()); //test argument in radians
		System.out.println(complex.getImag()); //test getIma
		System.out.println(complex.isImaginary());//test is imaginary
		System.out.println(complex.multiplyWith(new MyComplex(2,-3))); //test multiply using anonymous instance
		System.out.println(complex.divideBy(new MyComplex(2,3)));
	}

}
