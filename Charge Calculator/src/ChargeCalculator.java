import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChargeCalculator extends JFrame{
	
	public final int WIDTH = 500;
	public final int HEIGHT = 500;
	
	public int xCharge1 = 100;
	public int yCharge1 = 200;
	public final int radiusOne = 90;
	
	public final int xCharge2 = 400;
	public final int yCharge2 = 450;
	public final int radiusTwo = 90;
	
	public final static double radiansToDegrees = Math.PI/180;
	
	
	
	public ChargeCalculator(String title) {
		super(title);
	}
	
	public void start() {
		this.setResizable(false);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		
		final int sleep = 500;	
		final int scalar = 9000000;
		
		drawCenteredCircle(g, xCharge1, yCharge1, radiusOne, Color.BLACK);
		drawCenteredCircle(g, xCharge2, yCharge2, radiusTwo, Color.BLACK);
		double[] points = vectorMagCalculator(xCharge1,xCharge2,yCharge1,yCharge2);
		drawArrowLine(g,xCharge1, yCharge1, (int) (xCharge1 + scalar*points[0]), (int) (yCharge1 + scalar*points[1]), 10, 10, Color.RED);
		g.setColor(Color.RED);
		g.drawLine(xCharge1, yCharge1, (int) (xCharge1 + scalar*points[0]), (int) (yCharge1 + scalar*points[1]));
		
		drawArrowLine(g,xCharge2, yCharge2, (int) (xCharge2 - scalar*points[0]), (int) (yCharge2 - scalar*points[1]), 10, 10, Color.ORANGE);
		g.setColor(Color.ORANGE);
		g.drawLine(xCharge2, yCharge2, (int) (xCharge2 -  scalar*points[0]), (int) (yCharge2 - scalar*points[1]));
		
		
		try{
			Thread.sleep(sleep);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		repaint();
		System.out.println("HERE");
	}
	

	/**
	 * Draws a circle with center coordinates, a radius, and the color.
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
	
	public void makeTextLabel(String text, int x, int y, Graphics g) {
		g.drawString(text, x, y);
	}
	
	/**
	 * Calculate the charge
	 * @param primaryCharge	the first charge
	 * @param secondaryCharge	the second charge
	 * @param radius	the radius
	 * @return the charge
	 */
	public static double calcCharge(double primaryCharge, double secondaryCharge, double radius) {
		return (primaryCharge * secondaryCharge)/(Math.sqrt(radius));
	}
	
	/**
	 * The generalized function for a charge between two points.
	 * This uses the formula given by Mr. Kuszmaul.
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @return
	 */
	public static double pointChargeCalculator(double x1, double x2, double y1, double y2) {
		return 1/(Math.pow((x2-x1),2) + Math.pow(y2-y1, 2));
	}
	
	/**
	 * The generalized function to return a vector that represents the force.
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @return
	 */
	public static double[] vectorMagCalculator(double x1, double x2, double y1, double y2) {
		double deltaX = x2-x1;
		double deltaY = y2-y1;
		double angle = Math.atan(deltaY/deltaX);
		double charge = pointChargeCalculator(x1, x2, y1, y2);
		double[] ret = {charge*Math.cos(angle),charge*Math.sin(angle)};
		return ret;
		
	}
	
	/**
	 * http://stackoverflow.com/questions/2027613/how-to-draw-a-directed-arrow-line-in-java
	 * @param g
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param d
	 * @param h
	 * @param c
	 */
	private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h, Color c){
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};
        g.setColor(c);
        g.fillPolygon(xpoints, ypoints, 3);
     }
	
	private class Panel extends JPanel implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
