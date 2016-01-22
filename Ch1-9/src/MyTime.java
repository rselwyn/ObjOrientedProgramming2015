
public class MyTime {
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;
	
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
	 * 
	 */
	public String toString(){
		return getHours()+":"+getMinute()+":"+getSeconds();
	}
	/**
	 * Changes the second to the next second
	 */
	public void nextSecond(){
		
	}
	
	
	
}
