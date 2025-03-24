package algstudent.s5;

import java.util.Random;

public class MinimumPaths {

	private static final int MAX_WEIGHT = 99;
	private static final int MIN_WEIGHT = 10;
	private static final int INF = 10000000;
	private static final double EDGE_PROBABILITY = 0.5; // p1

	static String[] v; // node vector
	static int[][] weights; // weight matrix
	static int[][] costs; // Floyd's paths cost matrix
	static int[][] p; // predecessor matrix (steps) in Floyd paths

	public void calculateMinimumPaths(int size) {
		int n = size;
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;

		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];

		fillInWeights(weights); // weights for the example
		floyd(weights, costs, p);

		for (int source = 0; source <= n - 1; source++)
			for (int target = 0; target <= n - 1; target++)
				if (source != target) {
					minimumPath(v, weights, costs, p, source, target);
				}
	}

	/* ITERATIVE WITH CUBIC COMPLEXITY O(n^3) */
	static void floyd(int[][] weights, int[][] costs, int[][] p) {
		int n = weights.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				costs[i][j] = weights[i][j]; // initialize costs
				if (weights[i][j] != INF) { // initialize steps
					p[i][j] = i;
				} else {
					p[i][j] = -1;
				}
				for (int k = 0; k < n; k++) {

				}
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (costs[i][k] < INF && costs[k][j] < INF) {
						if (costs[i][j] > costs[i][k] + costs[k][j]) {
							costs[i][j] = costs[i][k] + costs[k][j];
							p[i][j] = p[k][j];
						}
					}
				}
			}
		}
	}

	static void minimumPath(String[] v, int[][] weights, int[][] costs, int[][] steps, int source, int target) {
		if (costs[source][target] == INF) {
			return;
		} else if (steps[source][target] == source) {
			return;
		} else {
			path(v, steps, source, target);
		}
	}

	/* IT IS RECURSIVE and WORST CASE is O(n), IT IS O(n) if you write all nodes */
	static void path(String[] v, int[][] steps, int i, int j) {
		if (steps[i][j] == i) {
			return;
		}
		path(v, steps, i, steps[i][j]);
	}

	/* load the example cost matrix */
	static void fillInWeights(int[][] w) {
		Random random = new Random();
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w.length; j++) {
				if (i == j) {
					w[i][j] = INF;
				}
				if (random.nextDouble() < EDGE_PROBABILITY) {
					w[i][j] = INF;
				} else {
					w[i][j] = random.nextInt(MAX_WEIGHT - MIN_WEIGHT + 1) + MIN_WEIGHT;
				}
			}
		}
	}

	/* print the cost matrix */
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%10s", a[i][j]));
			System.out.println();
		}
		System.out.println();
	}

}
