package algstudent.s7;

public class NullPathTimesBB {

	public static void main(String[] args) {	
		long t1,t2;
		NullPathBB np;
		t1 = System.currentTimeMillis();
		for(int n = 20; n < 100; n += 5) {
			np = new NullPathBB(n);
			np.branchAndBound();
			//np.printSolution();
			t2 = System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1) + "ms");
		}
	}
}
