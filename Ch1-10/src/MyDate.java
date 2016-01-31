import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	//Months
	private static final String[] strMonths = {
			"Jan",
			"Feb",
			"Mar",
			"Apr",
			"May",
			"Jun",
			"Jul",
			"Aug",
			"Sep",
			"Oct",
			"Nov",
			"Dec"		
	};
	
	private static final String[] strDays = {
		"Sunday",
		"Monday",
		"Tuesday",
		"Wednesday",
		"Thursday",
		"Friday",
		"Saturday"
	};
	
	private static final int[] daysInMonths = {
		31,
		28,
		31,
		30,
		31,
		30,
		31,
		31,
		30,
		31,
		30,
		31
	};
	
	/**
	 * Code to see if a uear is a leap year.
	 * @param year: the year
	 * @return is it a leap year?
	 */
	public static boolean isLeapYear(int year){
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}
	
	public static boolean isValidYear(int months, int days, int year){
		if (!(days<daysInMonths[months]) && days>=1){
			return false;
		}
		if (!(1 < year && year < 9999)) return false;
		
		if (!(months<12 && months>0)) return false;
		
		
		return true;
	}
	
	public static int getDayOfWeek(int year, int month, int day) throws ParseException{
		Calendar c = Calendar.getInstance();
		c.setTime(new SimpleDateFormat("dd/M/yyyy").parse(day+"/"+month+"/"+year));
		/*
		 * The builtin returns 1 as sunday, so we have to change it to 0 for sunday, 1 for monday, etc.
		 */
		if (c.get(Calendar.DAY_OF_WEEK) == 1) return 7;
		return c.get(Calendar.DAY_OF_WEEK)-1;
	}
	
}
