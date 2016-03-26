

public class Sphere {

	public final int radius;
	private int x;
	private int y;
	
	public Sphere(int radius, int x, int y) {
		this.radius = radius;
		setX(x);
		setY(y);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}


	
}
