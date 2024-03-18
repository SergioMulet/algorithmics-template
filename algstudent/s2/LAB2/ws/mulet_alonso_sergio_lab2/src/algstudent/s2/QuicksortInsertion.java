package algstudent.s2;

public class QuicksortInsertion {
	static int[] v;
	 private static int K = 1000; 

	 public static void quicksortInsertion(int[] a, int left, int right) {
			if (right - left + 1 <= K) {
	            insertionSort(a, left, right);
	        } else {
	        	int i = left;
	    		int j = right - 1;
	    		int pivot;
	    		
	    		if (left < right){ 
	    			int center = median_of_three(a, left, right);
	    			if ((right - left) >= 3){ 
	    				pivot = a[center];
	    				Vector.interchange(a, center, right);
	    				do {         
	    			    	while (a[i] <= pivot && i < right) i++; 
	    			    	while (a[j] >= pivot && j > left) j--; 
	    			        if (i < j) Vector.interchange(a, i, j);
	    			    } while (i < j);
	    				Vector.interchange(a, i, right);
	    				quicksortInsertion(a, left, i-1);
	    				quicksortInsertion(a, i+1, right);		
	    			} 
	    		} 
	        }
		}
		
		public static void quicksort(int[] a) {
			quicksortInsertion(a, 0, a.length-1);
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

	    private static void insertionSort(int[] array, int left, int right) {
	        for (int i = left + 1; i <= right; i++) {
	            int key = array[i];
	            int j = i - 1;
	            while (j >= left && array[j] > key) {
	                array[j + 1] = array[j];
	                j--;
	            }
	            array[j + 1] = key;
	        }
	    }

	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];
		
		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksort(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 
}
