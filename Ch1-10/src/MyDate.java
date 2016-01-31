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
	 * Constructor for the class
	 * @param year: the year
	 * @param month: the month
	 * @param date: the date
	 */
	public MyDate(int year, int month, int day){
		setDate(year,month,day);
	}
	
	/**
	 * Code to see if a year is a leap year.
	 * @param year: the year
	 * @return is it a leap year?
	 */
	public static boolean isLeapYear(int year){
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}
	
	public static boolean isValidDate(int year, int months, int days){
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
	
	/**
	 * Sets the date
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setDate(int year, int month, int day){
		if (isValidDate(year,month,day)){
			setYear(year);
			setMonth(month);
			setDay(day);
		}
		else{
			throw new IllegalArgumentException("Invalid year, month, or day!");
		}
	}
	
	/**
	 * Set the year
	 * @param year: the year to set
	 */
	public void setYear(int year){
		if ((1 < year && year < 9999)) this.year = year;
		else{
			throw new IllegalArgumentException("Bad year value");
		}
	}
	
	/**
	 * Set the month
	 * @param month: the month to set
	 */
	public void setMonth(int month){
		if ((1 < month && month < 12)) this.month = month;
		else{
			throw new IllegalArgumentException("Bad month value");
		}
	}
	
	/**s
	 * Set the day.
	 * @param day: the day to set
	 */
	public void setDay(int day){
		if (1 < day){
			if (day <= daysInMonths[getMonth()-1] && !isLeapYear(this.year)){
				this.day = day;
				return;
			}
			else if (isLeapYear(getYear()) && getMonth() == 2 && day<=27){
				this.day = day;
				return;
			}
		}
		throw new IllegalArgumentException("Bad date!");
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	
	public String toString(){
		try{
			return this.strDays[getDayOfWeek(this.year, this.month, this.day)-1] + " " + getDay() + " " + this.strMonths[getMonth()-1] + " " + getYear();
		}
		catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Change the date to the next day
	 * @return the new object with the date moved
	 */
	public MyDate nextDay(){
		if (getDay()<this.daysInMonths[getMonth()-1] && !(getMonth() == 2 && day== 27 && isLeapYear(getYear()))){
			setDay(getDay()+1);
		}
		else if (getDay() == this.daysInMonths[getMonth()-1] && !(getMonth() == 2 && day== 27 && isLeapYear(getYear()))){
			setDay(0);
			return nextMonth();
		}
		else if ((getMonth() == 2 && day== 27 && isLeapYear(getYear()))){
			day++;
			month++;
		}
		return this;
	}
	
	public MyDate nextMonth(){
		if (getMonth()==12){
			setMonth(1);
			setYear(getYear()+1);
			return equalizeMonth();
		}
		else {
			setMonth(getMonth()+1);
			return equalizeMonth();
		}
	}
	
	/**
	 * Helper method to equalize the date after incrementing the month
	 * @return
	 */
	private MyDate equalizeMonth(){
		if (getDay() == this.daysInMonths[getMonth()-2]){
			if (getMonth()==12){
				this.day = this.daysInMonths[0];
			}
			else{
				this.day = this.daysInMonths[getMonth()-1];
			}
		}
		return this;
	}
}
