package s0;

public class JavaA1v0 {

	public boolean isPrime(int n) {
		for(int i =2; i < n; i++) {
			if(n%i == 0) 
				return false;
		}
		return true;
	}
}
