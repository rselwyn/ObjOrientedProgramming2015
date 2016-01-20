import java.io.*;
import java.util.*;

public class MyPolynomial {
	private double[] coeffs; //The coefficients array
	
	/**
	 * Constructor using varargs 
	 * @param coeffs: the coefficients
	 */
	public MyPolynomial(double... coeffs){
		this.coeffs = coeffs;
	}
	/**
	 * Takes a polynomial from a file
	 * @param filename: the name of the file to open
	 */
	public MyPolynomial(String filename){
		Scanner in = null;
		try{
			in = new Scanner(new File(filename));
		}
		catch(Exception e){
			e.printStackTrace(); //file opening error
		}
		int degree = in.nextInt(); //degree of polynomial
		double[] coeffs = new double[degree+1]; //create a new double array of the coeffs
		for (int i = 0; i <coeffs.length; i++){
			coeffs[i] = in.nextDouble();
		}
	}
	/**
	 * @return the string specified on the website
	 */
	public String toString(){
		String retVal = "";
		for (int i = 0; i<coeffs.length; i++){
			retVal+=coeffs[i]+"x^"+(coeffs.length-i-1);
			if (i+1 != coeffs.length) retVal+="+";
		}
		return retVal;
	}
	
	/**
	 * Get the coefficient array
	 * @return the coefficient array
	 */
	public double[] getCoeffs(){
		return this.coeffs;
	}
	
	/**
	 * Returns the degree of the polynomial
	 * @return the degree of the polynomial, which is 1 less than the coefficient array length
	 */
	public int getDegree(){
		return this.coeffs.length-1;
	}
	
	/**
	 * Evaluate the polynomial for a given value
	 * @param x: the value of x
	 * @return the evaluated total
	 */
	public double evaluate(double x){
		int total = 0; //initialize the total
		for (int i = 0; i<coeffs.length; i++){
			total+=coeffs[i]*Math.pow(x,coeffs.length-i-1);
		}	
		return total;
	}
	
	/**
	 * 
	 * @param another: the polynomial to add with
	 * @return a new polynomial that is the sum of another and the polynomial
	 */
	public MyPolynomial add(MyPolynomial another){
		if (another.getDegree() != getDegree()){
			//If they are different sizes, throw an illegalargumentexception
			throw new IllegalArgumentException();
		}
		//the new coefficients
		double[] newCoeffs = new double[this.coeffs.length];
		for (int i = 0; i<this.coeffs.length; i++){
			newCoeffs[i] = this.coeffs[i] + another.getCoeffs()[i];
		}
		
		return new MyPolynomial(newCoeffs);
	}
	
	public MyPolynomial multiply(MyPolynomial another){
		if (another.getDegree() != getDegree()){
			//If they are different sizes, throw an illegalargumentexception
			throw new IllegalArgumentException();
		}
		
		double[] newCoeffs = new double[this.coeffs.length];
		for (int i = 0; i<this.coeffs.length; i++){
			newCoeffs[i] = this.coeffs[i] * another.getCoeffs()[i];
		}
		
		return new MyPolynomial(newCoeffs);
	}
	
}
