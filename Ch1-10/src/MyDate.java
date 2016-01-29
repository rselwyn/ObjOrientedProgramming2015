
public class MyDate {
	private int year;
	private int month;
	private int day;
	
	//Months
	private final String[] strMonths = {
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
	
	private final String[] strDays = {
		"Sunday",
		"Monday",
		"Tuesday",
		"Wednesday",
		"Thursday",
		"Friday",
		"Saturday"
	};
	
	private final int[] daysInMonths = {
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
	public boolean isLeapYear(int year){
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}

	
}
