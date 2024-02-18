package algstudent.s11;

public class Vector5 {
	
	public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Vector5 <size_of_vector>");
            return;
        }
        
        int n = Integer.parseInt(args[0]);
        int[] v = new int[n];
        
        // Fill the vector with random values
        Vector1.fillIn(v);
        
        long startTime = System.currentTimeMillis();
        
        // Calculate the maximum value and its position
        int[] m = new int[2];
        Vector1.maximum(v, m);
        
        long endTime = System.currentTimeMillis();
        
        long elapsedTime = (endTime - startTime)*10;
        
        // Output the result
        System.out.println("Time taken to find maximum: " + elapsedTime + " miliseconds");
        System.out.println("Position of maximum: " + m[0]);
        System.out.println("Maximum value: " + m[1]);
    }
}
