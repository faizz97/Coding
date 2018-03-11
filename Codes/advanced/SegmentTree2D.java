package advanced;

/* Calculate sum of sub-matrix using 2D Segment Tree. */
/* Query Format: 
 * Query 1: Sum of Sub-Matrix: (r1, c1) -> Coordinate of top-left of sub-matrix, (r2, c2) ->  Coordinate of bottom-right of sub-matrix 
 * Query 2: Update element at index matrix[row][col]
 * */

/* 
 * Time Complexity:
 * Creating 2D Segment Tree: O (4 * M * N) 
 * Query 1: log(M) * log(N)
 * Query 2: log(M) * log(N)
 * 
 * Space Complexity: O(4 * M * N)
 *  */

/* Explanation: https://www.youtube.com/watch?v=kKlZ9B3cS14 */

public class SegmentTree2D {
	
	private long tree[][];
	private long input[][];
	private int rows, cols, input_cols, input_rows;
	
	public SegmentTree2D(long input[][]) {
		this.input = input;
		input_cols = input[0].length;
		input_rows = input.length;
		rows = (2 * nextPowerOfTwo(input.length)) - 1;
		cols = (2 * nextPowerOfTwo(input[0].length)) - 1;
		tree = new long[rows][cols];
		create2DTree(input, tree);
		//printMatrix(tree);
	}
	
	private void create2DTree(long input[][], long tree[][]) {
		int i = rows - 1, j = input.length - 1, k = 0;
		while (k < input.length) {
			tree[i] = createSegmentTree(input[j], cols);
			i--; j--;
			k++;
		}
		for (int x = (tree.length - input.length - 1); x >= 0 ; x--) {
			tree[x] = addArrayElements(tree[(2 * x) + 1], tree[(2 * x) + 2]);
		}
	}
	
	private long[] createSegmentTree(long input[], int n) {
		long resultTree[] = new long[n];
		createTree(input, resultTree, 0, input.length - 1, 0);
		return resultTree;
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
	
	public long subMatrixSum(int r1, int c1, int r2, int c2)  {
		int row1 = r1 < r2 ? r1 : r2;
		int row2 = r1 < r2 ? r2 : r1;
		int col1 = (row1 == r1) ? c1 : c2;
		int col2 = (row2 == r2) ? c2 : c1;
		return subMatrixSumUtil(0, input_rows - 1, 0, row1, col1, row2, col2);
	}
	
	private long subMatrixSumUtil(int low, int high, int root, int r1, int c1, int r2, int c2)  {
		if (r1 <= low && r2 >= high) {
			return rangeSum(tree[root], c1, c2);
		}
		else if (r1 > high || r2 < low) {
			return 0;
		}
		int mid = (low + high) / 2;
		return subMatrixSumUtil(low, mid, (2 * root) + 1, r1, c1, r2, c2) + subMatrixSumUtil(mid + 1, high, (2 * root) + 2, r1, c1, r2, c2); 
	}
	
	private long rangeSum(long segmentTree[], int l, int r) {
		return calculateRangeSum(segmentTree, 0, input_cols - 1, l, r, 0);
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
	
	public void updateElement(int row, int col, int val) {
		int tree_row = rows - input_rows + row;
		int tree_col = cols - input_cols + col;
		long diff = val - input[row][col];
		int i = tree_row, j;
		while (i > 0) {
			j = tree_col;
			while (j > 0) {
				tree[i][j] += diff;
				j = (j - 1) / 2;
			}
			tree[i][0] += diff;
			i = (i - 1) / 2;
		}
		j = tree_col;
		while (j > 0) {
			tree[0][j] += diff;
			j = (j - 1) / 2;
		}
		tree[0][0] += diff;
	}
	
	private int nextPowerOfTwo(int n) {
		int pow = (int) Math.ceil(Math.log10(n) / Math.log10(2));
		return 1 << pow;
	}
	
	private long[] addArrayElements(long in1[], long in2[]) {
		long result[] = new long[in1.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = in1[i] + in2[i];
		}
		return result;
	}
	
	public static void main(String args[]) {
		long matrix[][] = {
				{2, 1, 7, 3},
				{0, 4, -6, 4},
				{14, 8, 12, 7},
				{9, 2, 0, 4}
		};
		SegmentTree2D st2 = new SegmentTree2D(matrix);
		System.out.println(st2.subMatrixSum(1, 1, 2, 2));
		st2.updateElement(1, 1, 6);
		System.out.println(st2.subMatrixSum(1, 1, 2, 2));
		System.out.println(st2.subMatrixSum(1, 0, 2, 3));
		System.out.println(st2.subMatrixSum(0, 0, 0, 3));
	}
}
