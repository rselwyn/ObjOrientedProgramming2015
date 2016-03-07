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
	
	private boolean initialDraw = false;
	private final int height;
	private final int width;
	private final int centerX;
	private final int centerY;
	private final double radiansToDegrees =  Math.PI / 180;
	
	public Clock(int width, int height) {
		this.height = height;
		this.width = width;
		centerX = this.width/2;
		centerY = this.height/2;
	}
	
	public void start(String title) {
		this.setTitle(title);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		repaint();
		
	}
	
	public void paint(Graphics g) {

		printBackgroundImage(g);
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		drawCenteredCircle(g, centerX, centerY, 325, Color.BLACK);
		drawCenteredCircle(g, centerX, centerY, 300, Color.WHITE);

		System.out.println(calendar.get(Calendar.HOUR) +":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
		
		
		/**
		 * Second hand.
		 */
		int lineX = centerX + (int) (150*Math.cos(radiansToDegrees * calendar.get(Calendar.SECOND) * 6 - Math.PI/2));
		int lineY = centerY + (int) (150*Math.sin(radiansToDegrees * calendar.get(Calendar.SECOND) * 6 - Math.PI/2));
		g.setColor(Color.RED);
		g.drawLine(centerX, centerY, lineX, lineY);
		/**
		 * Minute hand
		 */
		lineX = centerX + (int) (130*Math.cos(radiansToDegrees * calendar.get(Calendar.MINUTE) *6 - Math.PI/2));
		lineY = centerY + (int) (130*Math.sin(radiansToDegrees * calendar.get(Calendar.MINUTE) *6 - Math.PI/2));
		g.setColor(Color.BLACK);
		g.drawLine(centerX, centerY, lineX, lineY);
		/**
		 * Hour hand
		 */
		lineX = centerX + (int) (80*Math.cos(radiansToDegrees * calendar.get(Calendar.HOUR) * 30 - Math.PI/2));
		lineY = centerY + (int) (80*Math.sin(radiansToDegrees * calendar.get(Calendar.HOUR) * 30 - Math.PI/2));
		g.setColor(Color.BLACK);
		g.drawLine(centerX, centerY, lineX, lineY);
		drawNumbers(g);
		
		
		final int sleep = 500;
		try{
			Thread.sleep(sleep);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void drawCenteredCircle(Graphics g, int x, int y, int r, Color c) {
		  x = x - (r/2);
		  y = y - (r/2);
		  g.setColor(c);
		  g.fillOval(x,y,r,r);  
	}
	
	public void drawNumbers(Graphics g) {
		String[] times = {"3","4","5","6","7","8","9","10","11","12","1","2"};
		for (int i = 0; i < 360; i+=30) {
			int labelX = centerX + (int) ((int) 130*Math.cos(radiansToDegrees * i)) -3;
			int labelY = centerY + (int) ((int) 130*Math.sin(radiansToDegrees * i)) +2;
			g.drawString(times[i/30], labelX , labelY);
		}
	}
	
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
			initialDraw = true;
		}
	}
}
