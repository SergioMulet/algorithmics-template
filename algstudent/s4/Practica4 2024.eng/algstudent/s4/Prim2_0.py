import heapq
import Helper

def complete_graph_from_triangular(matrix):
    """Convert a triangular matrix to a complete graph representation."""
    number_of_nodes = len(matrix)
    for i in range(number_of_nodes):
        for j in range(i+1, number_of_nodes):
            matrix[j][i] = matrix[i][j]
    return matrix

def prim_algorithm(graph):
    """Implements Prim's algorithm on a given graph represented as a complete matrix."""
    number_of_nodes = len(graph)
    mst_edges = []

    # Initialize priority queue (heap) and visited set
    priority_queue = [(0, 0, None)]  # (weight, node, parent)
    visited = set()

    while priority_queue:
        weight, node, parent = heapq.heappop(priority_queue)

        if node in visited:
            continue

        visited.add(node)

        if parent is not None:
            mst_edges.append((parent, node, weight))

        for adjacent_node, weight in enumerate(graph[node]):
            if adjacent_node not in visited and weight > 0:
                heapq.heappush(priority_queue, (weight, adjacent_node, node))

    return mst_edges

def print_mst(mst):
    """Prints the edges and total cost of the MST."""
    total_cost = sum([edge[2] for edge in mst])
    print("Total Cost of MST:", total_cost)
    for edge in mst:
        print(f"Edge from {edge[0]} to {edge[1]} with weight {edge[2]}")

def main(filename):
    graph = Helper.triangularMatrixFromFile(filename)
    complete_graph = complete_graph_from_triangular(graph)
    mst = prim_algorithm(complete_graph)
    print_mst(mst)

if __name__ == "__main__":
    filename = input("Enter the filename: ")
    main(filename)