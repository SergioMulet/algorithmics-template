package algstudent.s3.petanque;

import java.io.IOException;

public class CalendarTimes {

	public static void main(String arg[]) throws IOException {
		long t1, t2;
		for(int n=2; n < Integer.MAX_VALUE; n*=2) {
			Calendar calendar = new Calendar(generateNames(n));
			t1 = System.currentTimeMillis();
			calendar.organize(0, n);
			t2 = System.currentTimeMillis();
			System.out.println("n=" + calendar.getNumberOfParticipants() + " **TIME=" + (t2 - t1)); 
		}
	}
	
	/*public static void main(String arg[]) throws IOException {
		long t1, t2;
			Calendar calendar = new Calendar("src/algstudent/s3/petanque/participants.txt");
			t1 = System.currentTimeMillis();
			calendar.organize(0, calendar.getNumberOfParticipants());
			calendar.printMatches();
			t2 = System.currentTimeMillis();
			System.out.println("n=" + calendar.getNumberOfParticipants() + " **TIME=" + (t2 - t1)); 			
	}*/

	private static String[] generateNames(int n) {
		String[] names = new String[n];
		for(int i = 0; i < n; i++) {
			names[i] = "Participant" + i;
		}
		return names;
	} 
}
