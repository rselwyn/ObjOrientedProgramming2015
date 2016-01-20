
public class TestMyPolynomial {
	
	public static void main(String[] args){
		MyPolynomial poly = new MyPolynomial(1,2,3,4,5);
		System.out.println(poly); //Test to string
		System.out.println(poly.evaluate(1)); //Test evaluate
		System.out.println(poly.add(new MyPolynomial(1,2,3,4,5))); //test add
		
		//Should throw an Illegal Argument Error because the polynomials are not the same size
		try{
			System.out.println(poly.add(new MyPolynomial(1)));	
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}

}
