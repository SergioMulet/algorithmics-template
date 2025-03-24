package algstudent.s5;

public class MinimumPathsTimes {

	public static void main(String[] args) {
		long t1, t2;
		MinimumPaths path = new MinimumPaths();
		for(int n = 200; n < Integer.MAX_VALUE; n *= 2) {
			t1= System.currentTimeMillis();
			path.calculateMinimumPaths(n);
			t2= System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1));
		}
	}

}
