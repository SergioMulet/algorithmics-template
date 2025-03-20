package algstudent.s4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphColouring {

	private static String[] colours = { "red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta",
			"lime" };
	private static Map<String, String> graphColoured = new HashMap<>();

	public static Map<String, String> greedy(Map<String, List<String>> graph) {
		List<String> sortedNodes = graph.keySet().stream()
				.sorted
				((a, b) -> Integer.compare(graph.get(b).size(), graph.get(a).size()))
				.toList();

		for (String node : sortedNodes) {
			for (String color : colours) {
				if (isNotUsed(color, graph.get(node))) {
					graphColoured.put(node, color);
					break;
				}
			}
		}
		return graphColoured;
	}

	private static boolean isNotUsed(String color, List<String> list) {
		for (String node : list) {
			if (graphColoured.containsKey(node)) {
				if (graphColoured.get(node.toString()).equals(color)) {
					return false;
				}
			}
		}
		return true;
	}
}
