
public class TestPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPoint[] points = new MyPoint[10];
		for (int i = 1; i<=10; i++){
			points[i-1] = new MyPoint(i,i);
			//Fill the array with the required points
		}
		
		for (MyPoint p : points){
			//Print out the toString method of the point
			System.out.println(p);
		}
	}

}
