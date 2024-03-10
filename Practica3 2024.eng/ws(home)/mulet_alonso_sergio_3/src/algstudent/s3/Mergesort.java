package algstudent.s3;

public class Mergesort {

	static void mergesort(int left, int right, int[] elements) {
		if (right > left) {
			// Get the index of the element in the middle
			int center = (right + left) / 2;
			// Sort the left side of the array
			mergesort(left, center, elements);
			// Sort the right side of the array
			mergesort(center + 1, right, elements);
			// Combine both parts
			combine(left, center, center + 1, right, elements);
		}
	}

	static void combine(int x1, int x2, int y1, int y2, int[] elements) {
		int sizeX = x2 - x1 + 1;
		int sizeY = y2 - y1 + 1;
		int[] left = new int[sizeX];
		int[] right = new int[sizeY];
		// Copy the elements from left to center into a helper
		for (int i = 0; i < sizeX; i++) {
			left[i] = elements[x1 + i];
		}
		// Copy the elements from center+1 to right into a helper
		for (int i = 0; i < sizeY; i++) {
			right[i] = elements[y1 + i];
		}
		// Copy the smallest elements from either the left or the
		for (int i = 0; i < sizeX; i++) {
			
		}
		int i = 0, j = 0, k = x1;

        // Merge the two arrays back into the original array
        while (i < sizeX && j < sizeY) {
            if (left[i] <= right[j]) {
                elements[k] = left[i];
                i++;
            } else {
                elements[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[] if any
        while (i < sizeX) {
            elements[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[] if any
        while (j < sizeY) {
            elements[k] = right[j];
            j++;
            k++;
        }

	}

}
