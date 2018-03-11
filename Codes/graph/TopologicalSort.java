package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
	public static void main(String args[]) {
		new TopologicalSort();
	}
	public TopologicalSort() {
		begin();
	}
	void begin() {
		Graph graph = new Graph(8);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 7);
		graph.addEdge(4, 5);
		graph.addEdge(3, 5);
		graph.addEdge(5, 6);
		System.out.println("Topological Sort of entered graph: " + graph.topologicalSort());
	}
	class Graph {
		int vertices;
		LinkedList<Integer> adjacencyList[];
		int topologicalSortedOrder[];
		@SuppressWarnings("unchecked")
		public Graph(int vertices) {
			this.vertices = vertices;
			this.adjacencyList = new LinkedList[vertices];
			topologicalSortedOrder = new int[vertices];
			for (int i = 0; i < adjacencyList.length; i++) {
				adjacencyList[i] = new LinkedList<Integer>();
			}			
		}
		public void addEdge(int u, int v) {
			adjacencyList[u].add(v);
		}
		public String topologicalSort() {
			Stack<Integer> stack = new Stack<Integer>();
			boolean visited[] = new boolean[this.vertices];
			for (int i = 0; i < vertices; i++) {
				if (!visited[i])
					topologicalSortUtil(i, stack, visited);
			}
			for (int i = 0; i < vertices; i++) {
				topologicalSortedOrder[i] = stack.pop();
			}
			return Arrays.toString(topologicalSortedOrder);
		}
		public void topologicalSortUtil(int vertex, Stack<Integer> stack, boolean visited[]) {
			visited[vertex] = true;
			for (int v : getAdjacentVertices(vertex)) {
				if (!visited[v])
					topologicalSortUtil(v, stack, visited);
			}
			stack.push(vertex);
		}
		private LinkedList<Integer> getAdjacentVertices(int vertex) {
			return adjacencyList[vertex];
		}
	}
}
