package algorithms;

/* Kadane's Algorithm for finding out Maximum Sum of SubArray */

public class KadanesAlgorithm {
	public static void main(String args[]) {
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Max Sum: " + maxSum(arr));
	}
	static int maxSum(int input[]) {
		int max = input[0];
		int currMax = input[0], start = 0, end = 0, s = 0;
		
		for (int i = 1; i < input.length; i++) {
			currMax += input[i];
			if (currMax > max) {
				start = s;
				end = i;
				max = currMax;
			}
			if (currMax < 0) {
				currMax = 0;
				s = i + 1;
			}
		}
		System.out.println("Index: " + start + " to " + end);
		
		return max;
	}
}
