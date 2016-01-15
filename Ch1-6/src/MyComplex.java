
public class MyComplex {
	private double real;
	private double imag;
	
	public MyComplex(double real, double imag){
		setValue(real,imag);
	}
	
	/**
	 * @param real: the real number
	 * @param imag: the imaginary coefficient
	 */
	public void setValue(double real, double imag){
		setReal(real);
		setImag(imag);
	}
	
	
	/**
	 * @return the real instance variable
	 */
	public double getReal(){
		return this.real;
	}
	/**
	 * @param real: the real number to set the instance variable
	 */
	public void setReal(double real){
		this.real = real;
	}
	/**
	 * @return the imaginary instance variable
	 */
	public double getImag(){
		return this.imag;
	}
	/**
	 * @param the double coefficient of the imaginary number
	 */
	public void setImag(double imag){
		this.imag = imag;
	}
	
	/**
	 * @return the toString from online
	 */
	public String toString(){
		return "("+getReal()+" + "+getImag()+"i )";
	}
	
	/**
	 * @return if imag ==0
	 */
	public boolean isReal(){
		return getImag() == 0;
	}
	
	/**
	 * @return is the number imaginary (if the imaginary coefficient != 0)
	 */
	public boolean isImaginary(){
		return getImag()!=0;
	}
	
	/**
	 * See if the complex number is equal to another complex number
	 * @param real: the real part of the comparing number
	 * @param imag: the imaginary part of the comparing number
	 */
	public boolean equals(double real, double imag){
		return getReal()==real && getImag() == imag;
	}
	
	/**
	 * See if this MyComplex object is equal to another one
	 * @param the other mycomplex object
	 */
	public boolean equals(MyComplex mc){
		return equals(mc.getReal(), mc.getImag());
	}
	
	/***
	 * Returns the magnitude of the complex number
	 * @return the magnitude
	 */
	public double magnitutde(){
		return Math.sqrt(Math.pow(getImag(),2) + Math.pow(getReal(), 2));
	}
	
	/**
	 * Returns the argument in radians
	 * Formula from the website
	 * @return the argument in radians
	 */
	public double argumentInRadians(){
		return Math.atan2(getImag(), getReal());
	}
	
	/**
	 * argumentInRadians but we convert radians to degrees
	 * @return the argumentInDegrees
	 */
	public int argumentInDegrees(){
		return (int) ((180/Math.PI)*argumentInRadians());
	}
	/**
	 * Return the conjugate
	 * @return the conjugate as a mycomplex
	 */
	public MyComplex conjugate(){
		return new MyComplex(getReal(), -getImag());
	}
	
	/**
	 * Return the conjugate
	 * @return the conjugate of the parameter
	 */
	public MyComplex conjugate(MyComplex con){
		return new MyComplex(con.getReal(), -con.getImag());
	}
	
	
	
	/**
	 * Returns a complex number that is the sum of two complex numbers
	 * @return the sum of the complex numbers
	 */
	public MyComplex add(MyComplex p){
		return new MyComplex((p.getReal()+getReal()), (p.getImag()+getImag()));
	}
	
	/**
	 * Returns a complex number that is the difference of two complex numbers
	 * @return the difference of the complex numbers
	 */
	public MyComplex subtact(MyComplex p){
		return new MyComplex((p.getReal()-getReal()), (p.getImag()-getImag()));
	}
	
	/**
	 * Multiply with another complex number
	 * @param the complex number to multiply by
	 */
	public MyComplex multiplyWith(MyComplex another){
		int ac = (int) (another.getReal() * getReal());
		int bd = (int) (another.getImag() * getImag());
		int ad = (int) (another.getReal() * getImag());
		int bc = (int) (another.getImag() * getReal());
		return new MyComplex((ac-bd), (ad+bc));
	}
	/**
	 * Return the mycomplex divided by another number
	 * @param num: the the complex number to divide the object by
	 * @return the divided complex number
	 */
	public MyComplex divideBy(MyComplex num){
		double cd = Math.pow(num.getImag(),2) + Math.pow(num.getReal(), 2); //get the cd value
//		return new MyComplex();
		MyComplex conjMult = multiplyWith(conjugate(num)); //find the conjugate
		MyComplex mult = multiplyWith(conjMult); //multiply  the conjugate by the objcet
		return new MyComplex(mult.getReal()/cd, mult.getImag()/cd); //return mult divided by cd val
	}
	
}
