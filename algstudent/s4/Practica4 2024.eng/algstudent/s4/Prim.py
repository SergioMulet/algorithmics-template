#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      uo296503
#
# Created:     14/03/2024
# Copyright:   (c) uo296503 2024
# Licence:     <your licence>
#-------------------------------------------------------------------------------
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
    visited = [False] * number_of_nodes
    number_of_edges = 0
    visited[0] = True
    mst_edges = []

    while number_of_edges < number_of_nodes - 1:
        minimum = float('inf')
        x = 0
        y = 0
        for i in range(number_of_nodes):
            if visited[i]:
                for j in range(number_of_nodes):
                    if not visited[j] and graph[i][j]:
                        if minimum > graph[i][j]:
                            minimum = graph[i][j]
                            x = i
                            y = j
        mst_edges.append((x, y, graph[x][y]))
        visited[y] = True
        number_of_edges += 1

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

