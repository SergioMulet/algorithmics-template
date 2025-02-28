package algstudent.s2;

public class QuicksortInsertion {

	static int[] v;
	private static final int K = 1000;
	
	public static void quicksortInsertion(int a[]) {	
		quicksortInsertion(a, 0, a.length-1);
	}
	
	public static void quicksortInsertion(int[] a, int left, int right) {
		if(a.length <= K) {
			InsertionReimplemented.insertion(a, left, right);
		}
		else {
			Quicksort.quicksort(a, left, right);
		}
	}
	
	public static int median_of_three(int[] a, int left, int right) { 
		int center = (left + right) / 2;
		if (a[left] > a[center])
			Vector.interchange(a, left, center);
		if (a[left] > a[right])
			Vector.interchange(a, left, right);
		if (a[center] > a[right])
			Vector.interchange(a, center, right);
		return center;
	}
	
	
	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 
}
