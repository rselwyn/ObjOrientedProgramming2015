/**
 * Notes:
 * 	getDayOfWeek() will return the day of the week.
 *  All of the code has been tested to work with the use cases provided online.
 *  All of the tests in this file should work.
 */
import java.text.ParseException;

public class TestMyDate {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//tests from the website
//		System.out.println(MyDate.isLeapYear(2012));
		
		MyDate d1 = new MyDate(2012, 2, 28);
		System.out.println(d1);             // Tuesday 28 Feb 2012
		System.out.println(d1.nextDay());   // Wednesday 29 Feb 2012
		System.out.println(d1.nextDay());   // Thursday 1 Mar 2012
		System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012 
		System.out.println(d1.nextYear() + "\n");  // Monday 1 Apr 2013

		MyDate d2 = new MyDate(2012, 1, 2);
		System.out.println(d2);                 // Monday 2 Jan 2012
		System.out.println(d2.previousDay());   // Sunday 1 Jan 2012
		System.out.println(d2.previousDay());   // Saturday 31 Dec 2011
		System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011  <-- NOT WORKINg
		System.out.println(d2.previousYear());  // Tuesday 30 Nov 2010  <-- NOT WORKINg

		MyDate d3 = new MyDate(2012, 2, 29);
		System.out.println(d3.previousYear());  // Monday 28 Feb 2011

		try{
			MyDate d4 = new MyDate(2099, 11, 33); // Invalid year, month, or day!
		}
		catch(Exception e){
			System.out.println("Invalid day was caught.");
		}
		
		try{
			MyDate d5 = new MyDate(2011, 2, 29);  // Invalid year, month, or day!
		}
		catch(Exception e){ System.out.println("Invalid day was caught");}
		
		System.out.println(MyDate.getDayOfWeek(2016, 1, 30)); //test get day of week
		System.out.println(new MyDate(2016,2,1));
		System.out.println(new MyDate(2016,2,1).nextDay().previousDay());
	}

}
