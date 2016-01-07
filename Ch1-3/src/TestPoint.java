
public class TestPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPoint[] points = new MyPoint[10];
		for (int i = 1; i<=10; i++){
			points[i-1] = new MyPoint(i,i);
		}
		
		for (MyPoint p : points){
			System.out.println(p);
		}
	}

}
