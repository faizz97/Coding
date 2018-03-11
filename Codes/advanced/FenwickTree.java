/*
 * Range Sum and Point Updates
 * Time Complexity : O (log n)
 * Space Complexity : O (N)
 * */

/*	Explanation: https://www.youtube.com/watch?v=CWDQJGaN1gY	*/

package advanced;

import java.util.Arrays;

public class FenwickTree {
	
	int[] tree;
	int[] input;
	
	public FenwickTree(int[] input) {
		this.tree = new int[input.length + 1];
		this.input = input;
		createTree();
	}
	
	private int getParent(int node) {
		return node - (node & -node);
	}
	
	private int getNext(int node) {
		return node + (node & -node);
	}
	
	private void createTree() {
		int next;
		for (int i = 0; i < input.length; i++) {
			next = i + 1;
			while (next < tree.length) {
				tree[next] += input[i];
				next = getNext(next);
			}
		}
	}
	
	private long sumTillIndex(int index) {
		long sum = 0;
		int node = index + 1;
		while (node > 0) {
			sum += tree[node];
			node = getParent(node);
		}
		return sum;
	}
	
	public long rangeSum(int left, int right) {
		return sumTillIndex(right) - sumTillIndex(left - 1);
	}
	
	public void updateElement(int loc, int value) {
		input[loc] += value;
		int node = loc + 1;
		while (node <= input.length) {
			tree[node] += value;
			node = getNext(node);
		}
	}
	
	public void replaceElement(int loc, int value) {
		int diff = value - input[loc];
		input[loc] = value;
		int node = loc + 1, next;
		tree[node] += diff;
		while ((next = getNext(node)) <= (input.length + 1)) {
			tree[next] += diff;
			node = next;
		}
	}
	
	public String toString() {
		String str = "\nInput: " + Arrays.toString(input) + "\nTree: " + Arrays.toString(tree);
		return str;
	}
	
	public static void main(String args[]) {
		int arr[] = { 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };
		FenwickTree ft = new FenwickTree(arr);
		System.out.println(ft);
		System.out.println(ft.rangeSum(2, 4));
		ft.updateElement(3, 3);
		System.out.println(ft);
		System.out.println(ft.rangeSum(2, 4));
		ft.updateElement(6, 2);
		System.out.println(ft);
		System.out.println(ft.rangeSum(5, 7));
		ft.replaceElement(6, 2);
		System.out.println(ft);
	}
}