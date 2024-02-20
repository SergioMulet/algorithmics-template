package algstudent.s0;

import java.util.ArrayList;
import java.util.List;

public class Vector1_2 {

	public static List<Integer> PrimeList(int x) {
		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < x; i++) {
			if (Vector1_1.isPrime(i))
				primes.add(i);
		}
		return primes;
	}
}
