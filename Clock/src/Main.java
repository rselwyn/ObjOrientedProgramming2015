
public class Main {
	
	private static final int width = 1000;
	private static final int height = 700;
	
	public static void main(String[] args) {
		Clock c = new Clock(width,height);
		c.start("    A Very Cool Clock");
		c.setVisible(true);
	}

}
