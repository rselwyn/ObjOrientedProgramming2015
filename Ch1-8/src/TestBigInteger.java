/*
 * I have been asked to write a program that adds two BigIntegers and multiplies them.
 * My program does that by instantiating two new BigIntegers, 
 * and then using their built in method add() and multiply()
 */

import java.math.*;
public class TestBigInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instantiate the two big integer
		BigInteger i1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
		BigInteger i2 = new BigInteger("22222222222222222222222222222222222222222222222222");
		
		//Print the sum and the product
		System.out.println(i1.add(i2));
		System.out.println(i1.multiply(i2));
	}

}
