package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		System.out.print("\nEnter vertices: ");
		int vertices = sc.nextInt();
		@SuppressWarnings("unchecked")
		LinkedList<Integer> graph[] = new LinkedList[vertices];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		System.out.print("\nEnter edges: ");
		int edges = sc.nextInt();
		while (edges-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			insert(graph, u, v);
		}
		System.out.println("Graph:");
		for (int i = 0; i < graph.length; i++) {
			System.out.println(graph[i]);
		}
		System.out.print("\nEnter element to find: ");
		int f = sc.nextInt();
		printDFS(graph, vertices, 0, f);
		printBFS(graph, vertices, 0);
	}
	static void insert(LinkedList<Integer> graph[], int u, int v) {
		graph[u].add(v);
		graph[v].add(u);
	}
	static void printDFS(LinkedList<Integer> graph[], int vertices, int root, int find) {
		boolean visited[] = new boolean[vertices];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root);
		visited[root] = true;
		boolean found = false;
		while (!stack.isEmpty()) {
			int x = stack.pop();
			Iterator<Integer> iterator = graph[x].iterator();
			if (x == find) {
				found = true;
				break;
			}
			//System.out.print(x + " ");
			while (iterator.hasNext()) {
				int tmp = iterator.next();
				if (!visited[tmp]) {
					visited[tmp] = true;
					stack.push(tmp);
				}
			}
		}
		if (found)
			System.out.println(find + " Found !");
		else
			System.out.println(find + " Not Found !");
	}
	static void printBFS(LinkedList<Integer> graph[], int vertices, int root) {
		boolean visited[] = new boolean[vertices];
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(root);
		visited[root] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.get(0);
			System.out.print(x + " ");
			queue.remove(0);
			Iterator<Integer> iterator = graph[x].iterator();
			while (iterator.hasNext()) {
				int tmp = iterator.next();
				if (visited[tmp] == false) {
					visited[tmp] = true;
					queue.add(tmp);
				}
			}
		}
	}
}
