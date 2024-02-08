package alg01;

import java.util.List;

public class Vector1 {
	
	public static void main(String [] args) {
		
		int n = 10000;
		for (int i = 0; i < 7; i++) {
			double t1= System.currentTimeMillis ();
			List<Integer> primes = Vector1_2.PrimeList(n);
			double t2 = System.currentTimeMillis ();
			System.out.print("n = " + n + "*** time = " + (t2-t1) + " milliseconds ");
			n = n*2;
		}
	}
	
}
