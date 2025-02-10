package s11;

public class Vector5 {
	static int[]a;
	static int[]b;
	private static int k = 2;
	
	public static void main(String arg []) {
		int repetitions = Integer.parseInt(arg[0]);
		long t1,t2;
		int sum = 0;
		
		for (int n=10000; n<=Integer.MAX_VALUE; n*=k){ //n is increased *5   
			  a = new int[n];
			  b = new int[n];
			  Vector1.fillIn(a);
			  Vector1.fillIn(b);
			  
			  t1 = System.currentTimeMillis();
			  //We have to repeat the whole process to be measured
			  for (int repetition=1; repetition<=repetitions; repetition++){    	
			     Vector1.maximum(a, b);
			  }
			  t2 = System.currentTimeMillis();
			  System.out.printf("SIZE=%d TIME=%d milliseconds SUM=%d NTIMES=%d\n", n, t2-t1, sum, repetitions);	
		}//for 
		
	}//main
}
