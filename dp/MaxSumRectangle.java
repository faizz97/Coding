package dp;
/* Given a 2D matrix, find the maximum sum matrix/rectangle in it. */
/* https://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/ */

/* Time Complexity: O(rows * cols * cols) */

public class MaxSumRectangle {
	public static void main(String args[]) {
		int matrix[][] = new int[][] {
            			{1, 2, -1, -4, -20},
            			{-8, -3, 4, 2, 1},
            			{3, 8, 10, 1, 3},
            			{-4, -1, 1, 7, -6}
        };
        System.out.println("Max Area: " + maxSumRectangle(matrix));
	}
	public static int maxSumRectangle(int input[][]) {
		int maxSum = 0;
		int rows = input.length, cols = input[0].length;
		int top = 0, left = 0, bottom = 0, right = 0;
		for (int leftCol = 0; leftCol < cols; leftCol++) {
			int temp[] = new int[rows];
			for (int rightCol = leftCol; rightCol < cols; rightCol++) {
				for (int i = 0; i < rows; i++) {
					temp[i] += input[i][rightCol];
				}
				KResult result = kadane(temp);
				if (result.maxSum > maxSum) {
					maxSum = result.maxSum;
					top = result.start;
					left = leftCol;
					bottom = result.end;
					right = rightCol;
				}
			}
		}
		System.out.println("Co-ordinates of rectangle:\nTop-Left: (" + top + ", " + left + ")\nBottom-Right: (" + bottom + ", " + right + ")");
		return maxSum;
	}
	static KResult kadane(int input[]) {
		KResult result = new KResult();
		
		result.maxSum = 0;
		result.start = 0;
		result.end = -1;
		int currentSum = 0, start = 0;
		for (int i = 0; i < input.length; i++) {
			currentSum += input[i];
			if (currentSum < 0) {
				currentSum = 0;
				start = i + 1;
			}
			else {
				if (currentSum > result.maxSum) {
					result.maxSum = currentSum;
					result.start = start;
					result.end = i;
				}
			}
		}
		
		if (result.end == -1) {
			result.maxSum = Integer.MIN_VALUE;
			for (int i = 0; i < input.length; i++) {
				if (result.maxSum < input[i]) {
					result.maxSum = input[i];
					result.start = i;
					result.end = i;
				}
			}
		}
		
		return result;
	}
}
class KResult {
	int maxSum, start, end;
}
