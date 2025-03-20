package algstudent.s4;

public class GreedyTimes {

	public static void main(String[] args) {
		long t1, t2;
		for(int n = 8; n < 65537; n*=2) {
			t1= System.currentTimeMillis();
			String filename = "src/algstudent/s4/sols/g" + n + ".json";
			GraphColouring.greedy(Greedy.getGraph(filename));
			t2= System.currentTimeMillis();
			System.out.println(n + "\t" + (t2 - t1));
		}
		
	}

}
