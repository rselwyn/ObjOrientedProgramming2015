import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class ChargeCalculator extends JFrame{
	
	public final int WIDTH = 700;
	public final int HEIGHT = 700;
	
	//values for charge 1
	public int xCharge1 = 300;
	public int yCharge1 = 200;
	public final int radiusOne = 90;
	
	//values for charge 2
	public int xCharge2 = 400;
	public int yCharge2 = 450;
	public final int radiusTwo = 90;
	
	private double lastForceValueX;
	private double lastForceValueY;
	
	public static final int STOP_MOVING_WITH_CURRENT_FORCE_DISTANCE = 180;
	
	/**
	 * Constructor that only takes in the title
	 * @param title
	 */
	public ChargeCalculator(String title) {
		super(title);
	}
	
	/**
	 * Start the charge calculator.
	 * 
	 * Set the:
	 * 	- Size
	 * 	- Default Close Operation
	 * 	- Background
	 * 	- Visibility
	 */
	public void start() {
		this.setResizable(false);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		repaint();
	}
	
	/**
	 * Paint the charges and arrows
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.WIDTH, this.HEIGHT);
		final int sleep = 50;	//sleep time
		final int scalar = 9000000; //charge scalar so that the charge is visible
		drawCenteredCircle(g, xCharge1, yCharge1, radiusOne, Color.BLACK);
		drawCenteredCircle(g, xCharge2, yCharge2, radiusTwo, Color.BLACK);
		
		/**
		 * Draw the first arrow
		 */
		double[] points = vectorMagCalculator(xCharge1,xCharge2,yCharge1,yCharge2);
		drawArrowLine(g,xCharge1, yCharge1, (int) (xCharge1 + scalar*points[0]), (int) (yCharge1 + scalar*points[1]), 10, 10, Color.RED);
		g.setColor(Color.RED);
		g.drawLine(xCharge1, yCharge1, (int) (xCharge1 + scalar*points[0]), (int) (yCharge1 + scalar*points[1]));
		
		/**
		 * Draw the second arrow
		 */
		drawArrowLine(g,xCharge2, yCharge2, (int) (xCharge2 - scalar*points[0]), (int) (yCharge2 - scalar*points[1]), 10, 10, Color.ORANGE);
		g.setColor(Color.ORANGE);
		g.drawLine(xCharge2, yCharge2, (int) (xCharge2 -  scalar*points[0]), (int) (yCharge2 - scalar*points[1]));
		
		/**
		 * Recursively call the repaint() method to 
		 * update the screen.
		 */
		try{
			Thread.sleep(sleep);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		updateSpherePositions();
		repaint();
	}
	
	/**
	 * Move the spheres along.
	 */
	private void updateSpherePositions() {
		double distancex = this.xCharge2 - this.xCharge1;
        double distancey = this.yCharge2 - this.xCharge1;
        double distanceSquared = distancex * distancex + distancey * distancey;
        double distance = Math.sqrt(distanceSquared);
        double force = 100000/distanceSquared;
        double forceX = force * distancex / distance;
        double forceY = force * distancey / distance;
	    System.out.println(distance);
        if (distance > STOP_MOVING_WITH_CURRENT_FORCE_DISTANCE){	
	        xCharge1 += forceX;
	        yCharge1 += forceY;
	        xCharge2 -= forceX;
	        yCharge2 -= forceY;
	        System.out.println("IM RUNNING");
	        this.lastForceValueX = forceX;
	        this.lastForceValueY = forceY;
        }
        else {
        	xCharge1 += this.lastForceValueX;
 	        yCharge1 += this.lastForceValueY;
 	        xCharge2 -= this.lastForceValueX;
 	        yCharge2 -= this.lastForceValueY;
        }
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
	/**
	 * Calculate the force between two charges
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
	 * @param x1	the first x position
	 * @param y1	the first y position
	 * @param x2	the second x position
	 * @param y2	the second y position
	 * @return
	 */
	public static double pointChargeCalculator(double x1, double x2, double y1, double y2) {
		return 1/(Math.pow((x2-x1),2) + Math.pow(y2-y1, 2));
	}
	
	/**
	 * The generalized function to return a vector that represents the force.
	 * @param x1	the first x position
	 * @param y1	the first y position
	 * @param x2	the second x position
	 * @param y2	the second y position
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
	 * Adapted with Minor Changes From:
	 * http://stackoverflow.com/questions/2027613/how-to-draw-a-directed-arrow-line-in-java
	 * @param g	the graphics object
	 * @param x1	the first x position
	 * @param y1	the first y position
	 * @param x2	the second x position
	 * @param y2	the second y position
	 * @param d		
	 * @param h
	 * @param c		the color
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
	
}
