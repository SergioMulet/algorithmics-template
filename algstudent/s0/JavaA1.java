package s0;

import java.util.List;

public class JavaA1 {

	public void main(String[]args) {
		int n = 10000;
		for(int i = 1; i <= 7; i++) {
			long t1 = System.currentTimeMillis();
			List<Integer> primes = new JavaA1v1().getPrimes(n);
			long t2 = System.currentTimeMillis();
			System.out.println("n = " + n + " time= " + (t2-t1));
			n=n*2;	
		}
	}
}
