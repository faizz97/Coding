package adhoc;

/* Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. */
/* Link: https://www.geeksforgeeks.org/find-number-of-islands/ */

public class IslandCount {
	
	static int nextRow[] = {-1, -1, -1,  0, 0,  1, 1, 1};
    static int nextCol[] = {-1,  0,  1, -1, 1, -1, 0, 1};
    
	public static void main(String args[]) {
		int input[][] = { 	{1, 1, 0, 0, 0},
			                {0, 1, 0, 0, 1},
			                {1, 0, 0, 1, 1},
			                {0, 0, 0, 0, 0},
			                {1, 0, 1, 0, 1}
						};
		System.out.println(count(input));
	}
	static public int count(int input[][]) {
		int totalCount = 0;
		boolean visited[][] = new boolean[input.length][input[0].length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == 1 && !visited[i][j]) {
					DFS(i, j, input, visited);
					totalCount++;
				}
			}
		}
		return totalCount;
	}
	static void DFS(int row, int col, int input[][], boolean visited[][]) {
		visited[row][col] = true;
		for (int i = 0; i < 8; i++) {
			int newRow = row + nextRow[i];
			int newCol = col + nextCol[i];
			if (isValid(newRow, newCol, input.length, input[0].length, input, visited))
				DFS(newRow, newCol, input, visited);
		}
	}
	static boolean isValid(int i, int j, int row, int col, int input[][], boolean visited[][]) {
		return ((i >= 0 && i < row) && (j >= 0 && j < col) && !visited[i][j] && input[i][j] == 1);
	}
}
