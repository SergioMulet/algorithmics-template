package algstudent.s6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exam {

	private static final int MAX_WEIGHT = 99;
	private static final int MIN_WEIGHT = 10;
	private static final int MIN_TOLERANCE = -75;
	private static final int MAX_TOLERANCE = 50;
	private static final double WEIGHT_PROBABILITY = 0.5;
	int n;
	int[][] weights;
	boolean[] visited;
	int cost = 0;
	List<Integer> nullPath = new ArrayList<>();
	
	public Exam(int n) {
		weights = new int[n][n];
		this.n=n;
	}
	
	
	
	public List<Integer> getNullPath() {
		return nullPath;
	}



	public void setNullPath(List<Integer> nullPath) {
		this.nullPath = nullPath;
	}



	public static int getMaxWeight() {
		return MAX_WEIGHT;
	}



	public static int getMinWeight() {
		return MIN_WEIGHT;
	}



	public static int getMinTolerance() {
		return MIN_TOLERANCE;
	}



	public static int getMaxTolerance() {
		return MAX_TOLERANCE;
	}



	public static double getWeightProbability() {
		return WEIGHT_PROBABILITY;
	}



	public int getN() {
		return n;
	}



	public int[][] getWeights() {
		return weights;
	}



	public boolean[] getVisited() {
		return visited;
	}



	public void fillInWeights() {
		Random random = new Random();
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				if (random.nextDouble() < WEIGHT_PROBABILITY) {
					weights[i][j] = - (random.nextInt(MAX_WEIGHT - MIN_WEIGHT + 1) + MIN_WEIGHT);
				} else {
					weights[i][j] = random.nextInt(MAX_WEIGHT - MIN_WEIGHT + 1) + MIN_WEIGHT;
				}
			}
		}
	}
	
	public List<Integer> findNullPath() {
		visited = new boolean[n];
		nullPath = new ArrayList<>();
		visited[0] = true;
		nullPath.add(0);
		if (backtrack(0, 0)) {
			return nullPath;
		}
		return null;
	}

	private boolean backtrack(int currentNode, int lastWeight) {
		if (nullPath.size() == n && currentNode == n - 1) {
			return cost <= MAX_TOLERANCE && cost >= MIN_TOLERANCE;
		}

		for (int next = 0; next < n; next++) {
			int weight = weights[currentNode][next];

			if (!visited[next] && isPossibleToReachASolution(weight) && areOpposites(weight, lastWeight)) {
				cost += weight;
				visited[next] = true;
				nullPath.add(next);

				if (backtrack(next, weight)) {
					return true;
				}
				cost -= weight;
				visited[next] = false;
				nullPath.removeLast();
			}
		}
		return false;
	}
	
	private boolean areOpposites(int newWeight, int oldWeight) {
		if(newWeight >= 0 && oldWeight <= 0) {
			return true;
		}
		else return oldWeight >= 0 && newWeight <= 0;
    }
	private boolean isPossibleToReachASolution(int weight) {
		int remaining = n - nullPath.size();
		int maxPossible = cost + weight + (remaining * MAX_WEIGHT);
		int minPossible = cost + weight + (remaining * -MAX_WEIGHT);

		return maxPossible >= MIN_TOLERANCE && minPossible <= MAX_TOLERANCE;
	}

	
	public int getCost() {
		return cost;
	}
	
	public void printMatrix() {
        for (int[] row : weights) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
}
