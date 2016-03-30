import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class ChargeCalculator extends JFrame{
	//Frame constants
	public final int WIDTH = 700;
	public final int HEIGHT = 700;
	
	private final int RADIUS = 20;
	
	//Spheres
	private Sphere one = new Sphere(RADIUS,300,200);
	private Sphere two = new Sphere(RADIUS,450,500);
	
	/**
	 * Because of the how force is inversely proportional to
	 * the distance squared, as soon as the distance between the spheres gets really close,
	 * the spheres will over adjust in their position and move completely off screen.  To counter
	 * act this, I store the last force values and I apply them instead of the correct force if
	 * the distance is less than the constant.
	 */
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
		drawCenteredCircle(g, one.getX(), one.getY(), one.radius, Color.BLACK);
		drawCenteredCircle(g, two.getX(), two.getY(), two.radius, Color.BLACK);
		
		/**
		 * Draw the first arrow
		 */
		double[] points = vectorMagCalculator(one.getX(),two.getX(),one.getY(),two.getX());
		drawArrowLine(g,one.getX(), one.getY(), (int) (one.getX() + scalar*points[0]), (int) (one.getY() + scalar*points[1]), 10, 10, Color.RED);
		g.setColor(Color.RED);
		g.drawLine(one.getX(), one.getY(), (int) (one.getX() + scalar*points[0]), (int) (one.getY() + scalar*points[1]));
		
		/**
		 * Draw the second arrow
		 */
		drawArrowLine(g,two.getX(), two.getX(), (int) (two.getX() - scalar*points[0]), (int) (two.getY() - scalar*points[1]), 10, 10, Color.ORANGE);
		g.setColor(Color.ORANGE);
		g.drawLine(two.getX(), two.getY(), (int) (two.getX() -  scalar*points[0]), (int) (two.getY() - scalar*points[1]));
		
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
		updateSpherePositions(); //update the sphere position
		repaint();
	}
	
	/**
	 * Change the sphere positions.
	 */
	private void updateSpherePositions() {
		double distancex = this.two.getX() - one.getX();
        double distancey = this.two.getY() - one.getX();
        double distanceSquared = distancex * distancex + distancey * distancey;
        double distance = Math.sqrt(distanceSquared);
        double force = 100000/distanceSquared;
        double forceX = force * distancex / distance;
        double forceY = force * distancey / distance;
        //prevent overcompensation
        //see the constants section for more info on this
        if (distance > STOP_MOVING_WITH_CURRENT_FORCE_DISTANCE){	
        	one.setX((int) (one.getX() + forceX));
        	one.setY((int) (one.getY() + forceY));
        	two.setX((int) (two.getX() - forceX));
        	two.setY((int) (two.getY() - forceY));
	        this.lastForceValueX = forceX;
	        this.lastForceValueY = forceY;
        }
        else {
        	one.setX((int) (one.getX() + lastForceValueX));
        	one.setY((int) (one.getY() + lastForceValueY));
        	two.setX((int) (two.getX() - lastForceValueX));
        	two.setY((int) (two.getY() - lastForceValueY));
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
