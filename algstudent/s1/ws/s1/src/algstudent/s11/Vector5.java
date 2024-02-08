package algstudent.s11;

public class Vector5 {

	public static void main(String arg []) {
		int repetitions = Integer.parseInt(arg[0]);
		long t1,t2;
		int sum = 0;
		int size = 0;
		long t11 = 0;
		
		for (int n=10; n<=Integer.MAX_VALUE; n*=5){ //n is increased *5   
			  int[] v = new int[n];
			  int[] w = new int[2];
			  Vector1.fillIn(v);
			  
			  t1 = System.currentTimeMillis();
			  t11 = t1;
			  //We have to repeat the whole process to be measured
			 maximum(v, w);
			 size = n;
			  }
			  t2 = System.currentTimeMillis();
			  System.out.printf("SIZE=%d TIME=%d milliseconds SUM=%d NTIMES=%d\n",size, t2-t11, sum, repetitions);	
		
	}//main
	
	/** 	
	 * This method calculates the maximum and its position 
	 * and returns them
	 * @param a Vector with numbers
	 * @param m m[0] gives the position of the max value and m[1] gives the max value
	 */
	public static void maximum(int[]a, int[]m){
	  int n = a.length;
	  m[0] = 0; //Initial position for max value
	  m[1] = a[0]; //Initial max value
	  for (int i=1; i<n; i++) //The rest of the elements
	     if (a[i] > m[1]) {
	    	m[0] = i;
	     	m[1] = a[i];
	     }
	} 
}
