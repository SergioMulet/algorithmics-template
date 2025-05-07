package algstudent.s6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NullPath {

    private static final int MAX_WEIGHT = 99;
    private static final int MIN_WEIGHT = -99;
    private static final int TOLERANCE = 99;
    private static final double WEIGHT_PROBABILITY = 0.5;
    int n;
    int[][] weights;
    boolean[] visited;
    int cost = 0;
    List<Integer> nullPath = new ArrayList<>();

    public NullPath(int n) {
        weights = new int[n][n];
        this.n = n;
    }

    public void fillInWeights() {
        Random random = new Random();
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (random.nextDouble() < WEIGHT_PROBABILITY) {
                    weights[i][j] = -(random.nextInt(MAX_WEIGHT - MIN_WEIGHT + 1) + MIN_WEIGHT);
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
        if (backtrack(0)) {
            return nullPath;
        }
        return null;
    }

    private boolean backtrack(int currentNode) {
        if (nullPath.size() == n && currentNode == n - 1) {
            return Math.abs(cost) <= TOLERANCE;
        }

        for (int next = 0; next < n; next++) {
            int weight = weights[currentNode][next];

            if (!visited[next] && isPossibleToReachASolution(weight)) {
                cost += weight;
                visited[next] = true;
                nullPath.add(next);

                if (backtrack(next)) {
                    return true;
                }
                cost -= weight;
                visited[next] = false;
                nullPath.removeLast();
            }
        }
        return false;
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

    private boolean isPossibleToReachASolution(int weight) {
        int remaining = n - nullPath.size();
        int maxPossible = cost + weight + (remaining * MAX_WEIGHT);
        int minPossible = cost + weight + (remaining * -MAX_WEIGHT);

        return maxPossible >= -TOLERANCE || minPossible <= TOLERANCE;
    }
}
