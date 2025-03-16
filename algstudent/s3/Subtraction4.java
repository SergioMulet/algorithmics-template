package algstudent.s3;

public class Subtraction4 {

	public static long rec4(int n) {
		long cont = 0;
		if (n <= 0)
			cont++;
		else {
			for(int i = 0; i< n*n; i++) { //O(n^2)
				cont++;
			}
			rec4(n - 1); //a=1; b=1; k=2 --> O(n^3)
		}
		return cont;
	}

	public static void main(String arg[]) {
		long t1, t2, cont = 0;
		for (int n = 100; n <= 1000000000; n*=2) {
			t1 = System.currentTimeMillis();

			cont = rec4(n);

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		} // for
	} // main
}
