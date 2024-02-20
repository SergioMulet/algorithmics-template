package algstudent.s11;

public class Vector7 {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: java Vector6 <size_of_vector>");
			return;
		}

		int n = Integer.parseInt(args[0]);
		int[] v1 = new int[n];
		int[] v2 = new int[n];

		// Fill the vectors with random values
		Vector1.fillIn(v1);
		Vector1.fillIn(v2);

		long startTime = System.currentTimeMillis();

		// Calculate the number of matches using matches1 operation
		int matches = Vector1.matches2(v1, v2);

		long endTime = System.currentTimeMillis();

		long elapsedTime = (endTime - startTime);

		// Output the result
		System.out.println("Time taken to find matches: " + elapsedTime + " millieseconds");
		System.out.println("Number of matches: " + matches);
	}
}
