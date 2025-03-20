package algstudent.s4;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Greedy {
	public static Map<String, List<String>> getGraph(String filename) {
		JSONParser parser = new JSONParser();
		try (FileReader reader = new FileReader(filename)) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			@SuppressWarnings("unchecked")
			Map<String, List<Long>> tempGraph = (Map<String, List<Long>>) jsonObject.get("graph");
			Map<String, List<String>> graph = new HashMap<>();
			for (Map.Entry<String, List<Long>> entry : tempGraph.entrySet()) {
			    String node = entry.getKey();
			    List<String> neighbors = entry.getValue().stream().map(String::valueOf).toList();
			    graph.put(node, neighbors);
			}
			return graph;
			/*
			Map<String, String> solution = GraphColouring.greedy(graph);
			try (FileWriter file = new FileWriter("solution"+n)) {
				file.write(new JSONObject(solution).toJSONString());
			}
			if (solution != null) {
				System.out.println("Solution found: "); //+ solution);
			} else {
				System.out.println("Solution not found.");
			}*/
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
