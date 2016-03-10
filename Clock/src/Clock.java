import javax.swing.JFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Clock extends JFrame{
	
	/**
	 * initialDraw is whether or not there has been one draw loop already.
	 * height is the height
	 * width is the width
	 * centerX is the center x coordinate
	 * centerY is the center y coordinate
	 * degreesToRadians converts degrees to radians
	 * offSet is the time offset, which allows me to have different time zones
	 */
	private boolean initialDraw = false;
	private final int height;
	private final int width;
	private final int centerX;
	private final int centerY;
	private final double degreesToRadians =  Math.PI / 180;
	private double offSetForTimeZoneInRadians = 0;
	
	/**
	 * A constructor for the clock that takes in the width and height.
	 * @param width the width
	 * @param height the height
	 */
	public Clock(int width, int height) {
		this.height = height;
		this.width = width;
		centerX = this.width/2;
		centerY = this.height/2;
	}
	
	/**
	 * A constructor for the clock that takes in the width and height.
	 * @param width the width
	 * @param height the height
	 */
	public Clock(int width, int height, double offset) {
		this.height = height;
		this.width = width;
		centerX = this.width/2;
		centerY = this.height/2;
		this.offSetForTimeZoneInRadians = offset;	
	}
	
	
	
	/**
	 * A constructor where the user can set all the location values
	 * @param width: the width
	 * @param height: the height
	 * @param centerX: the center x coordinate
	 * @param centerY: the center y coordinate
	 */
	public Clock(int width, int height, int centerX, int centerY) {
		this.height = height;
		this.width = width;
		this.centerX = centerX;
		this.centerY = centerY;
	}
	

	/**
	 * A constructor where the user can set all the location values
	 * @param width: the width
	 * @param height: the height
	 * @param centerX: the center x coordinate
	 * @param centerY: the center y coordinate
	 */
	public Clock(int width, int height, int centerX, int centerY, String title, int offset) {
		this.height = height;
		this.width = width;
		this.centerX = centerX;
		this.centerY = centerY;
		this.offSetForTimeZoneInRadians = offset;
	}
	
	/**
	 * Default constructor
	 */
	public Clock() {
		this(500,500);
	}
	
	/**
	 * Starts the clock
	 * @param title
	 */
	public void start(String title) {
		this.setTitle(title);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
		repaint();	
	}
	
	/**
	 * The repaint method.  This method calls the method to print the background image.  It uses the abstracted drawClock() method 
	 * with the data from the instance of the calendar.  At the end, it calls itself again so it can update the clock.
	 */
	public void paint(Graphics g) {
		printBackgroundImage(g);
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		drawClock(centerX, centerY, g, calendar.get(Calendar.SECOND), calendar.get(Calendar.MINUTE), calendar.get(Calendar.HOUR), this.offSetForTimeZoneInRadians);
		final int sleep = 500;		
		try{
			Thread.sleep(sleep);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	/**
	 * An astraction to draw a clock.
	 * @param xc: the x center of the clock
	 * @param yc: the y center of the clock
	 * @param g: the graphics object
	 * @param timeS: the time in seconds
	 * @param timeM: the time in minutes
	 * @param timeH: the time in hours
	 * @param offset: the offset variable which can account for timezones
	 */
	public void drawClock(int xc, int yc, Graphics g, int timeS, int timeM, int timeH, double offset) {
		drawCenteredCircle(g, xc, yc, 325, Color.BLACK);
		drawCenteredCircle(g, xc, yc, 300, Color.WHITE);
		/**
		 * Second hand.
		 */
		int lineX = xc + (int) (150*Math.cos(degreesToRadians * timeS * 6 - Math.PI/2));
		int lineY = yc + (int) (150*Math.sin(degreesToRadians * timeS * 6 - Math.PI/2));
		g.setColor(Color.RED);
		g.drawLine(xc, yc, lineX, lineY);
		/**
		 * Minute hand
		 */
		lineX = centerX + (int) (130*Math.cos(degreesToRadians * timeM *6 - Math.PI/2));
		lineY = centerY + (int) (130*Math.sin(degreesToRadians * timeM *6 - Math.PI/2));
		g.setColor(Color.BLACK);
		g.drawLine(xc, yc, lineX, lineY);
		/**
		 * Hour hand
		 */
		int realTimeDeg = (int) (.5 * (60*timeH + timeM));
		lineX = xc + (int) (80*Math.cos(degreesToRadians * realTimeDeg - Math.PI/2 + offset));
		lineY = yc + (int) (80*Math.sin(degreesToRadians * realTimeDeg- Math.PI/2 + offset));
		g.setColor(Color.BLACK);
		g.drawLine(xc, yc, lineX, lineY);
		drawNumbers(g);
	}
	
	
	/**
	 * Draws a circle
	 * @param g: the graphics object
	 * @param x: the center x coordinate
	 * @param y: the center y coordinate
	 * @param r: the radius
	 * @param c: the color of the circle
	 */
	public void drawCenteredCircle(Graphics g, int x, int y, int r, Color c) {
		  x = x - (r/2);
		  y = y - (r/2);
		  g.setColor(c);
		  g.fillOval(x,y,r,r);  
	}
	
	/**
	 * Draws the numbers on the clock.
	 * @param g: the graphics object
	 */
	public void drawNumbers(Graphics g) {
		String[] times = {"3","4","5","6","7","8","9","10","11","12","1","2"};
		for (int i = 0; i < 360; i+=30) {
			int labelX = centerX + (int) ((int) 130*Math.cos(degreesToRadians * i)) -3;
			int labelY = centerY + (int) ((int) 130*Math.sin(degreesToRadians * i)) +2;
			g.drawString(times[i/30], labelX , labelY);
		}
	}
	
	/**
	 * Prints the background image out.
	 * @param g: the graphics object
	 */
	public void printBackgroundImage(Graphics g) {
		if(!initialDraw){
			int translateX = -50;
			int translateY = -30;
			try {
				g.translate(translateX, translateY);
				g.drawImage(ImageIO.read(new File("Background.jpg")), 50,50, this);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			g.translate(-translateX, -translateY);
		}
		this.initialDraw = true;
	}
	
	
	
}
