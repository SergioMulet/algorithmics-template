package algstudent.s7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BBNode extends Node {
	private static final int MAX_WEIGHT = 99;
	private static final int MIN_WEIGHT = 10;
	private static final int TOLERANCE = 99;
	private static final double WEIGHT_PROBABILITY = 0.5;
	private static final int TARGET = 0;
    private static int[][] weights;
    private static int n;

    private int currentNode;
    private boolean[] visited;
    private ArrayList<Integer> path;
    private int cost;

    //for root
    public BBNode(int size) {
        n = size;
        weights= new int[n][n];
        fillInWeights();
        this.currentNode = 0;
        this.visited = new boolean[n];
        this.visited[0] = true;
        this.path = new ArrayList<>();
        this.path.add(0);
        this.cost = 0;
        calculateHeuristicValue();
    }
    
    //for child
    private BBNode(BBNode parent, int nextNode) {
        this.currentNode = nextNode;
        this.visited = Arrays.copyOf(parent.visited, n);
        this.visited[nextNode] = true;
        this.path = new ArrayList<>(parent.path);
        this.path.add(nextNode);
        this.cost = parent.cost + weights[parent.currentNode][nextNode];
        this.depth = parent.depth + 1;
        this.parentID = parent.getID();
        calculateHeuristicValue();
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

    @Override
    public void calculateHeuristicValue() {
        heuristicValue = Math.abs(TARGET - cost) + (n - path.size());
    }

    //Complex version not able to make it work
    /*
    @Override
    public ArrayList<Node> expand() {
        ArrayList<Node> children = new ArrayList<>();
        for (int next = 0; next < n; next++) {
            if (!visited[next]) {
                BBNode child = new BBNode(this, next);

                int remaining = n - child.path.size();
                int minPossibleCost = child.cost + remaining * (-MAX_WEIGHT);
                if (minPossibleCost > TARGET + TOLERANCE) {
                    continue; //prune 
                }

                children.add(child);
            }
        }

        // Sort so nodes closer to target cost (0) are first
        children.sort((a, b) -> {
            int diffA = Math.abs(((BBNode)a).getCost() - TARGET);
            int diffB = Math.abs(((BBNode)b).getCost() - TARGET);
            return Integer.compare(diffA, diffB);
        });

        return children;
    }*/
    
    //simpler version    
    @Override
    public ArrayList<Node> expand() {
        ArrayList<Node> children = new ArrayList<>();
        for (int next = 0; next < n; next++) {
            if (!visited[next]) {
                children.add(new BBNode(this, next));
            }
        }
        return children;
    }

    @Override
    public boolean isSolution() {
        return path.size() == n && currentNode == n - 1 && Math.abs(cost - TARGET) <= TOLERANCE;
    }

    @Override
    public String toString() {
        return "Path: " + path.toString() + " | Cost: " + cost + " | Heuristic: " + heuristicValue;
    }
    
    //This implementation is too aggressive, I was just trying and at the end I kept the default solution implemented by Node
    /*
    @Override
    public int initialValuePruneLimit() {
        int pruneLimit = Integer.MAX_VALUE; // we set prune limit to a high value      
        
        if (this.getCost() == 0) { // root?
            ArrayList<Node> children = this.expand();          
            // If the child cost is lower, we set the prune limit to its value
            for (Node child : children) {
                int bestChildCost = child.getCost() + child.getHeuristicValue();
                pruneLimit = Math.min(pruneLimit, bestChildCost);
            }
        } 
        else {
            pruneLimit = this.getCost();
        }
        return pruneLimit;
    }*/

    public static int[][] getWeightMatrix() {
        return weights;
    }
    
    public int getCost() {
    	return this.cost;
    }
}
