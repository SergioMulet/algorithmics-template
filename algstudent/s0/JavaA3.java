package s0;

import java.util.ArrayList;
import java.util.List;

public class JavaA3 {

	private boolean isPrime(int n) {
		for(int i =2; i < n/(2+1); i++) {
			if(n%i == 0) 
				return false;
		}
		return true;
	}
	
	private List<Integer> getPrimes(int n){
		List<Integer> primes = new ArrayList<>();
		for(int i = 2; i < n; i++) {
			if(isPrime(i))
				primes.add(n);
		}
		return primes;
	}
	
	public void execute() {
		int n = 10000;
		for(int i = 1; i <= 7; i++) {
			long t1 = System.currentTimeMillis();
			List<Integer> primes = getPrimes(n);
			long t2 = System.currentTimeMillis();
			System.out.println("n = " + n + " time= " + (t2-t1));
			n=n*2;	
		}
	}
}
