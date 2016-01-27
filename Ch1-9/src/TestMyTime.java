/**
 * I wrote all the code specified online.
 * I also wrote the TestMyTime class.
 */

public class TestMyTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MyTime(10,21,33)); //test the instantiation and printing of a time object
		System.out.println(new MyTime(10,21,59).nextSecond()); //test the next second
		System.out.println(new MyTime(10,59,59).nextSecond()); //test the next second with the next minute being pushed automatically
		
		System.out.println(new MyTime(10,23,10).nextMinute()); //test the next minute
		
		System.out.println(new MyTime(10,20,30).nextMinute().previousMinute() + " " + (new MyTime(10,20,30))); //test 
		
		System.out.println(new MyTime(10,20,30).nextHour().nextHour().nextHour()); //test next hour (twice)
		
		
	}

}
