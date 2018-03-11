package dp;
/*
 * You are given a grid with 3 rows and N columns. Each cell in the grid contains the value 0 initially. 
 * You perform several operations of the following type on the grid
 * Pick a row, say r. Pick a start column and end column, say s and e. Of course 1 = s = e = N. 
 * Now, set all values in the grid in row r, from column s to column e to 1.
 * After you perform all the operations, you wish to find subgrids in this grid (or rectangles, if you please) 
 * which contain only 1s. Most importantly, you wish to find the rectangle that has the largest area. 
 * Print the area of this rectangle.
 * 
 * Solution Complexity: O(3 * N) = O(N)
 * 
 */

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangleArea {

	static final int row = 3;
	
	static int maxHistogramArea(int[] data, int N) {							// Maximum area of a histogram
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int tmp, area = Integer.MIN_VALUE, maxArea = Integer.MIN_VALUE;
		
		int i = 0;
		
		while (i < N) {	
			
			if (stack.isEmpty() || data[i] >= data[stack.peek()])
				stack.add(i++);
			
			else {
				tmp = stack.peek();
				stack.pop();
				area = data[tmp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				
				if (maxArea < area)
					maxArea = area;
			}
		}
		while (!stack.isEmpty()) {
			tmp = stack.peek();
			stack.pop();
			area = data[tmp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			
			if (maxArea < area)
				maxArea = area;
		}
		return maxArea;
	}
	
	void printMatrix(int[][] matrix, int N) {
		System.out.println("\nMatrix: ");
		for (int i = 1; i < row + 1; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int matrix[][];
		
		int T, N, M, r, s, e;
		
		T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			matrix = new int[row + 1][N + 1];
			M = sc.nextInt();
			for (int j = 0; j < M; j++) {
				r = sc.nextInt();
				s = sc.nextInt();
				e = sc.nextInt();
				for (int j2 = s; j2 <= e; j2++) {
					matrix[r][j2] = 1;
				}
			}
			
			//printMatrix(matrix, N);
			
			int temp[] = new int[row + 1];
			int max = Integer.MIN_VALUE, max2;

			for (int j = 1; j < N + 1; j++) {
				
				if (j == 1) {
					
					for (int j2 = 1; j2 < row + 1; j2++) {
						temp[j2] = matrix[j2][j];
					}
					
					max = maxHistogramArea(temp, temp.length);
				}
				
				else {
					for (int j2 = 1; j2 < row + 1; j2++) {
						if (matrix[j2][j] == 0)
							temp[j2] = 0;
						else
							temp[j2] += matrix[j2][j];
					}
					
					max2 = maxHistogramArea(temp, temp.length);
					max = max > max2 ? max : max2;
					
				}
			}
			System.out.print("\n" + max);
		}
	}
}
