
public class MyTime {
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;
	
	/**
	 * Constructor for the object
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
	public MyTime(int hours, int minutes, int seconds){
		setHours(hours);
		setMinute(minutes);
		setSeconds(seconds);
	}
	
	/**
	 * Get the hours
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}
	/**
	 * Return the hour value
	 * @param hours
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	/**
	 * Get the minutes
	 * @return the minutes
	 */
	public int getMinute() {
		return minutes;
	}
	
	/**
	 * Set the minutes
	 * @param minute
	 */
	public void setMinute(int minute) {
		this.minutes = minute;
	}
	
	/**
	 * The seconds
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}
	/**
	 * Sets the seconds
	 * @param seconds
	 */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	/**
	 * To string method
	 */
	public String toString(){
		return getHours()+":"+getMinute()+":"+getSeconds();
	}
	
	/**
	 * Changes the second to the next second
	 */
	public MyTime nextSecond(){
		int second = getSeconds();
		int minute = getMinute();
		int hour = getHours();
		if (second != 59){
			second++; 
		}
		else{
			if (minute!=59){
				minute++;
			}
			else{
				minute = 0;
				if (hours!=23){
					hour++;
				}
				else{
					hour = 0;
				}
			}
			second = 0;
		}
		
		return new MyTime(hour,minute,second);
	}
	
	/**
	 * Changes the minute to the next minute
	 */
	public MyTime nextMinute(){
		int second = getSeconds();
		int minute = getMinute();
		int hour = getHours();
		
		if (minute!=59){
			minute++;
		}
		else{
			minute = 0;
			if (hours!=23){
				hour++;
			}
			else{
				hour = 0;
			}
		
		}
	
		
		return new MyTime(hour,minute,second);
	}
	
	/**
	 * Changes the second to the next second
	 */
	public MyTime nextHour(){
		int second = getSeconds();
		int minute = getMinute();
		int hour = getHours();
		
		if (hours!=23){
			hour++;
		}
		else{
			hour = 0;
		}
		
		return new MyTime(hour,minute,second);
	}
	
	/**
	 * Previous second
	 * @return a new object with the previous second
	 */
	public MyTime previousSecond(){
		int second = getSeconds();
		int minute = getMinute();
		int hour = getHours();
		if (second != 0){
			second--;
		}
		else{
			seconds=59;
			if (minute == 0){
				if (hour == 0){
					hour = 23;
				}
				else{
					hour--;
				}
			}
			else{
				minute--;
			}	
		}
		
		return new MyTime(hour,minute,second);
	}

	/**
	 * Turns back the clock one minute
	 * @return an object with a previous 
	 */
	public MyTime previousMinute(){
		int second = getSeconds();
		int minute = getMinute();
		int hour = getHours();

		if (minute == 0){
			minute = 59;
			
			if (hour == 0){
				hour = 23;
			}
			else{
				hour--;
			}
		}
		else{
			minute--;
		}	

		return new MyTime(hour,minute,second);
	}
	
	/**
	 * Change the hour back by 1
	 * @return the new MyTime with the hour -1
	 */
	public MyTime previouseHour(){
		int second = getSeconds();
		int minute = getMinute();
		int hour = getHours();

		if (hour == 0){
			hour = 23;
		}
		else{
			hour--;
		}


		return new MyTime(hour,minute,second);
	}
}
