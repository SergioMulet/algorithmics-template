package algstudent.s2;

/* This program is used to order n elements with a quadratic algorithm
(BUBBLE OR DIRECT EXCHANGE) */
public class Bubble {
	static int[] v;

	/* Sorting by the Bubble method O(n^2)*/
	public static void bubble(int[] a) {
		int n = a.length;	
		for (int i = 1; i < n; i++) 
			for (int j = n - 1; j >= i; j--) 
				if (a[j-1] > a[j]) { // in sorted vector this is always false so interchange is not executed
					Vector.interchange(a, j-1, j); //swap, in reverse is always executed, while in random maybe not, thats why is faster
				}
	}

	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		bubble(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		bubble(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		bubble(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 

}