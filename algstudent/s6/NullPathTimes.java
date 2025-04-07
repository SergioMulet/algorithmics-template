package algstudent.s6;

public class NullPathTimes {

	public static void main(String[] args) {
		long t1, t2;
		NullPath path;
		for (int n = 200; n <= 300; n+=5) {
			path = new NullPath(n);
			t1 = System.currentTimeMillis();
			for(int i = 0; i < 100; i++) {
				path.fillInWeights();
				path.findNullPath();
			}
			t2= System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1)/100.0 + "ms");
		}
		
		//Now trying with the square of the last nullpath calculated
		path = new NullPath(900);
		t1 = System.currentTimeMillis();
		for(int i = 0; i < 100; i++) {
			path.fillInWeights();
			path.findNullPath();
		}
		t2= System.currentTimeMillis();
		System.out.println(900 + "\t" + (t2 - t1)/100.0 + "ms");
	}
}
