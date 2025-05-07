package algstudent.s6;

import java.util.Arrays;

public class NullPathMain {

	public static void main(String[] args) {

		NullPath path = new NullPath(20);
		path.fillInWeights();
		System.out.println(path.findNullPath());
		System.out.println(path.getCost());

		Exam path2 = new Exam(20);
		path2.fillInWeights();
		System.out.println(path2.findNullPath());
		System.out.println(path2.getCost());

	}

}
