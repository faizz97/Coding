package advanced;
/*
 * Range Sum Using Segment Tree
 * 
 * Time Complexity:
 * 1.	Tree Construction: O(4 * N) = O(N)
 * 2.	Range Query: O(4 * logN) = O(logN)
 * 
 * Space complexity: O(4 * N) = O(N)
 * */

/* Explanation: https://www.youtube.com/watch?v=ZBHKZF5w4YU */

import java.util.Arrays;

public class SegmentTree {
	
	long[] segmentTree;
	long[] in;
	int tree_size;
	int input_size;
	
	public SegmentTree(long[] input) {
		in = input;
		tree_size = (nextPowerOfTwo(input.length) * 2) - 1;
		segmentTree = new long[tree_size];
		input_size = input.length;
		createTree(input, segmentTree, 0, input.length - 1, 0);
	}	
	
	private void createTree(long[] input, long[] segmentTree, int low, int high, int root) {
		if (low == high) {
			segmentTree[root] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		createTree(input, segmentTree, low, mid, 2 * root + 1);
		createTree(input, segmentTree, mid + 1, high, 2 * root + 2);
		segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root  + 2];
	}
	
	public long rangeSum(int l, int r) {
		return calculateRangeSum(segmentTree, 0, input_size - 1, l, r, 0);
	}
	
	private long calculateRangeSum(long[] tree, int low, int high, int l, int r, int root) {
		if (low >= l && high <= r) {
			return tree[root];
		}
		if (high < l || low > r) {
			return 0;
		}
		int mid = (high + low) / 2;
		return calculateRangeSum(tree, low, mid, l, r, 2 * root + 1) + calculateRangeSum(tree, mid + 1, high, l, r, 2 * root + 2); 
	}
	
	private int nextPowerOfTwo(long n) {
		int pow = (int) Math.ceil(Math.log10(n) / Math.log10(2));
		return 1 << pow;
	}
	
	public String toString() {
		return "Input Array: " + Arrays.toString(in) + "\nSegment Tree: " + Arrays.toString(segmentTree) + "\nTree Nodes: " + tree_size;
	}
	
	public static void main(String args[]) {
		long[] in = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		SegmentTree st = new SegmentTree(in);
		System.out.println(st.rangeSum(4, 7));
		System.out.println(st);
	}
}
