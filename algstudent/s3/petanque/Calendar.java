package algstudent.s3.petanque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calendar {

	private int numberOfParticipants;
	private String[] names;
	private int numberOfDays;
	private String[][] matches;
	
	//the first column of matches is reserved by the player who is going to play the matches of that row
	public Calendar(String filePath) throws IOException {
		readParticipants(filePath);
		numberOfDays = numberOfParticipants-1;
		matches = new String[numberOfParticipants][numberOfDays];
	}
	
	public Calendar(String[] names) {
        this.names = names;
        this.numberOfParticipants=names.length;
        int numberOfDays = names.length - 1;
        this.matches = new String[numberOfParticipants][numberOfDays];
    }

	private void readParticipants(String filePath) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			numberOfParticipants = Integer.parseInt(br.readLine().trim());
			names = new String[numberOfParticipants];
			for (int i = 0; i < numberOfParticipants; i++) {
				names[i] = br.readLine(); 
			}
		} catch (NumberFormatException e) {
			System.out.print("An error happened when reading the file");
		}
	}

	//D&C by division until we reach n=2
	public void organize(int start, int size) {
	    if (size == 2) {
	        matches[start][0] = names[start + 1];
	        matches[start + 1][0] = names[start];
	        return;
	    }

	    int mid = size / 2;
	    organize(start, mid);
	    organize(start + mid, mid);

	    for (int day = 0; day < mid; day++) {
	        for (int i = 0; i < mid; i++) {
	            int left = start + i;
	            int right = start + mid + ((i + day) % mid);  
	            matches[left][day + mid - 1] = names[right];
	            matches[right][day + mid - 1] = names[left];
	        }
	    }
	}

	public void printMatches() {
        System.out.println("PLAYER / OPPONENT");
        System.out.print("\t");
        for (int d = 1; d < numberOfParticipants; d++) {
            System.out.print("DAY " + d + "\t");
        }
        System.out.println();

        for (int i = 0; i < numberOfParticipants; i++) {
            System.out.print(names[i] + "\t");
            for (int d = 0; d < numberOfParticipants - 1; d++) {
                System.out.print(matches[i][d] + "\t");
            }
            System.out.println();
        }
    }

	public String[] getParticipants() {
		return names;
	}

	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}
	
	public String[][] getMatches() {
		return matches;
	}
}
