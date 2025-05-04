package algstudent.s7;

public class NullPathBB {

	private Node root;
	private BranchAndBound branchAndBound;
	public NullPathBB(int n) {
		root = new BBNode(n);
		branchAndBound = new BranchAndBound();	
	}
	
	public void branchAndBound() {
		branchAndBound.branchAndBound(root);
	}
	
	public void printSolution() {
		branchAndBound.printSolutionTrace();
	}
}
