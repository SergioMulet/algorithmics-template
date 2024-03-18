package algstudent.s3;

public class Subtraction4 {
	static long cont;

	public static void rec4(int n) {

		if (n <= 0) {
			cont++;
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j< n; j++) {
					cont++;
				}
			}
			rec4(n-1);
		}
			
	}

	public static void main(String arg[]) {
		long t1, t2, cont = 0;
		for (int n = 100; n <= 1000000; n *= 2) {
			t1 = System.currentTimeMillis();

			rec4(n);

			t2 = System.currentTimeMillis();

			System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
		} // for
	} // main
}
