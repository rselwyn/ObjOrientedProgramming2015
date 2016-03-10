
public class Main {
	
	private static final int width = 1000;
	private static final int height = 700;
	
	/**
	 * Instantiate a clock
	 * @param args
	 */
	public static void main(String[] args) {
		Clock c = new Clock(width,height);
		c.start("    A Very Cool Clock");
		
	}

}
