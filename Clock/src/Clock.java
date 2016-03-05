import javax.swing.JFrame;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Clock extends JFrame{
	
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		repaint();
		
	}
	
	public void paint(Graphics g) {
		drawCenteredCircle(g, centerX, centerY, 325, Color.BLACK);
		drawCenteredCircle(g, centerX, centerY, 300, Color.WHITE);
		
		/**
		 * Second hand.
		 */
		int lineX = centerX + (int) (150*Math.cos(radiansToDegrees * System.currentTimeMillis()/1000 % 60 *6));
		int lineY = centerY + (int) (150*Math.sin(radiansToDegrees * System.currentTimeMillis()/1000 % 60 *6));
		
		g.setColor(Color.RED);
		g.drawLine(centerX, centerY, lineX, lineY);
		/**
		 * Minute hand
		 */
		lineX = centerX + (int) (150*Math.cos(radiansToDegrees * System.currentTimeMillis()/60000 % 60 *6));
		lineY = centerY + (int) (150*Math.sin(radiansToDegrees * System.currentTimeMillis()/60000 % 60 *6));
		g.setColor(Color.BLACK);
		g.drawLine(centerX, centerY, lineX, lineY);
		/**
		 * Hour hand
		 */
		lineX = centerX + (int) (80*Math.cos(radiansToDegrees * System.currentTimeMillis()/(60000*24) % 60 *6));
		lineY = centerY + (int) (80*Math.sin(radiansToDegrees * System.currentTimeMillis()/(60000*24) % 60 *6));
		g.setColor(Color.BLACK);
		g.drawLine(centerX, centerY, lineX, lineY);
		
		
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
}
