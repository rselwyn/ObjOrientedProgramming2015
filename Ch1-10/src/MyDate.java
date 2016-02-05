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
	
	/**
	 * 
	 * @param year the year
	 * @param months the month
	 * @param days the day
	 * @return whether or not the day was a leap year
	 */
	public static boolean isValidDate(int year, int months, int days){
		if (!isLeapYear(year) && months == 2 && days == 29) return false;
		
		if (!(days<daysInMonths[months]) && days>=1){
			return false;
		}
		if (!(1 < year && year < 9999)) return false;
		
		if (!(months<12 && months>0)) return false;
		
		
		return true;
	}
	
	/**
	 * Gets the day of week
	 * @param year: the year
	 * @param month: the month
	 * @param day: the day
	 * @return the day of the week
	 * @throws ParseException
	 */
	public static int getDayOfWeek(int year, int month, int day) throws ParseException{
		Calendar c = Calendar.getInstance();
		c.setTime(new SimpleDateFormat("dd/M/yyyy").parse(day+"/"+month+"/"+year));
		/*
		 * The builtin returns 1 as sunday, so we have to change it to 0 for sunday, 1 for monday, etc.
		 */
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
		if ((1 <= month && month <= 12)) this.month = month;
		else{
			throw new IllegalArgumentException("Bad month value");
		}
	}
	
	/**s
	 * Set the day.
	 * @param day: the day to set
	 */
	public void setDay(int day){
		if (1 <= day){
			
			//normal day
			if (day <= daysInMonths[getMonth()-1] && !isLeapYear(this.year)){
				this.day = day;
				return;
			}
			//leap year and the day
			else if (isLeapYear(getYear()) && getMonth() == 2 && day<=27){
				this.day = day;
				return;
			}
			else {
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
	
	/**
	 * To string specified online
	 */
	public String toString(){
		try{
			return this.strDays[getDayOfWeek(this.year, this.month, this.day)] + " " + getDay() + " " + this.strMonths[getMonth()-1] + " " + getYear();
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
		//normal day and it is not a feb 28
		if (getDay()<this.daysInMonths[getMonth()-1] && !(getMonth() == 2 && day== 28 && isLeapYear(getYear()))){
			setDay(getDay()+1);
		}
		//last day of the month, 
		else if (getDay() == this.daysInMonths[getMonth()-1] && !(getMonth() == 2 && day== 28 && isLeapYear(getYear()))){
			setDay(1);
			return nextMonth();
		}
		else if ((getMonth() == 2 && day== 28 && isLeapYear(getYear()))){
			day++;
		}
		else if ((getMonth() == 2 && day== 29 && isLeapYear(getYear()))){
			setDay(1);
			setMonth(getMonth()+1);
			
		}
		return this;
	}
	
	/**
	 * Increment the month
	 * @return the object with an incremented month
	 */
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
	 * increment the year
	 * @return the new mydate
	 */
	public MyDate nextYear(){
		setYear(getYear()+1);
		if (isLeapYear(getYear())){
			if (getMonth()==2 && getDay() == 29) setDay(getDay()-1);
		}
		
		return this;
	}
	
	/**
	 * Helper method to equalize the date after incrementing the month
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
	
	/**
	 * Returns the object with the day decremented 
	 */
	public MyDate previousDay(){
		if (getDay()!=1){
			setDay(getDay()-1);
//			System.out.println("C1");
		}
		else if (getDay() == 1 && getMonth()!=1 && getMonth()!=3){
			setDay(daysInMonths[getMonth()-1]);
			setMonth(getMonth()-1);
//			System.out.println("C2");
		}
		else if (getDay() == 1 && getMonth() == 1){
			setYear(getYear()-1);
			setMonth(12);
			setDay(31);
//			System.out.println("C3");
		}
		else if (getMonth() == 3 && getDay() == 1){
			if (isLeapYear(getYear())){
				setMonth(getMonth()-1);
				setDay(28);
			}
			else{
				setMonth(getMonth()-1);
				setDay(29);
			}
		}		
		return this;
	}
	
	/**
	 * Decrement the month
	 */
	public MyDate previousMonth(){
		if (getMonth() != 1){
			setMonth(getMonth()-1);
			equalizeMonth();
		}
		else{
			setMonth(12);
			equalizeMonth();
		}
		return this;
	}
	
	/**
	 * Decrement the year
	 * @return
	 */
	public MyDate previousYear(){
		if (getMonth()!=2)
		setYear(getYear()-1);
		else if (getMonth()==2){
			if (getDay() == 29) setDay(28);
			
		}
		return this;
	}
	
	
}
