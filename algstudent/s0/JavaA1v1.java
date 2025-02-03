package s0;

import java.util.ArrayList;
import java.util.List;

public class JavaA1v1 {

	public List<Integer> getPrimes(int n){
		JavaA1v0 java = new JavaA1v0();
		List<Integer> primes = new ArrayList<>();
		for(int i = 2; i < n; i++) {
			if(java.isPrime(i))
				primes.add(n);
		}
		return primes;
	}
}
