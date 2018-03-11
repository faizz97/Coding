package advanced;
/*
 * Used for answering Range Minimum Queries.
 * 
 * Time Complexity for building table: O(N * log(N))
 * Time Complexity for answering each query: O(1)
 * Overall Time Complexity: O(N * log(N))
 * 
 * Space Complexity: O(N * log(N))
 * */

/* Explanation: https://www.youtube.com/watch?v=c5O7E_PDO4U */

public class SparseTable {
	
	long input[];
	int table[][];
	int n, m;
	
	public static void main(String args[]) {
		long arr[] = { 5, 6, 2, 8, 15, 8, 9, 10, 6, 7, 1, 98, 53 };
		SparseTable st = new SparseTable(arr);
		System.out.println("Minimum number in the range (0, 14): " + st.rangeMinimum(0, 12));
		System.out.println("Minimum number in the range (5, 7): " + st.rangeMinimum(5, 7));
		System.out.println("Minimum number in the range (0, 3): " + st.rangeMinimum(0, 3));
	}
	
	public SparseTable(long input[]) {
		this.input = input;
		n = input.length;
		m = (int) (Math.floor(Math.log(n)) + 1);
		table = new int[n][m + 1];
		createSparseTable();
	}
	
	void createSparseTable() {
		
		for (int i = 0; i < n; i++)
			table[i][0] = i;
		
		for (int j = 1; (1 << j) <= n; j++) {
			for (int i = 0; (i + (1<<j) - 1) < n; i++) {
				if (input[table[i][j - 1]] < input[table[(int) (i + (1<<(j-1)))][j - 1]])
					table[i][j] = table[i][j - 1];
				else
					table[i][j] = table[(int) (i + (1<<(j-1)))][j - 1];
			}
		}
	}
	
	long rangeMinimum(int l, int r) {
		int len = r - l + 1;
		int k = (int) ( (Math.log(len) - (int) Math.log(len) >= 0.5) ? (int) Math.log(len) + 1 : (int) Math.log(len));
		if (input[table[l][k]] <= input[table[r - (int)Math.pow(2, k) + 1][k]])
			return input[table[l][k]];
		else 
			return input[table[r - (int) Math.pow(2, k) + 1][k]];
	}
	
	void printTable() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
}
