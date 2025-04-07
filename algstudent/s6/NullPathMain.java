package algstudent.s6;

public class NullPathMain {

	public static void main(String[] args) {
		NullPath path = new NullPath(20);
		path.fillInWeights();
		System.out.println(path.findNullPath());
		System.out.println(path.getCost());
		path.printMatrix();
	}

}
