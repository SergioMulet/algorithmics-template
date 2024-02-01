package alg01;

import java.util.ArrayList;
import java.util.List;

public class Vector1 {
	
	public static void main(String [] args) {
		
		int n = 10000;
		for (int i = 0; i < 7; i++) {
			double t1= System.currentTimeMillis ();
			List<Integer> primes = PrimeList(n);
			double t2 = System.currentTimeMillis ();
			System.out.print("n = " + n + "*** time = " + (t2-t1) + " milliseconds ");
			n = n*2;
		}
	}


	public static boolean isPrime(int x) {
		for (int i = 2; i < x; i++) {
			if(x%i == 0)
				return false;
		}
		return true;
			
	}
	
	public static List<Integer> PrimeList(int x){
		List<Integer> primes = new ArrayList<>();
		for (int i =2; i < x; i++) {
			if (isPrime(i))
				primes.add(i);
		}
		return primes;
	}
	
}
