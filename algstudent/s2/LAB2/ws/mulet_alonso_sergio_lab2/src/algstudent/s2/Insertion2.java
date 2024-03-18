package algstudent.s2;

public class Insertion2 {
	static int[] v;
	
	public static void insertion(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int pivot = a[i];
            int j = i - 1;
            while (j >= left && pivot < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = pivot;
        }
    }
	
	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		insertion(v, 0, -1);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		insertion(v, 0, -1);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		insertion(v,0, -1);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 
}
