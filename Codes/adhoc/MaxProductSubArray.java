package adhoc;

/* https://www.geeksforgeeks.org/maximum-product-subarray/ */

public class MaxProductSubArray {
	public static void main(String args[]) {
		int input[] = {1, -2, -3, 0, 7, -8, -2};
		System.out.println(maxProductSubArray(input));
	}
	static long maxProductSubArray(int input[]) {
		long max = 1, curr_max = 1, curr_min = 1;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 0) {
				curr_max = 1;
				curr_min = 1;
			}
			else if (input[i] > 0) {
				curr_max = curr_max * input[i];
				curr_min = Math.min(curr_min * input[i], 1);
			}
			else {
				long temp = curr_max;
				curr_max = Math.max(1, curr_min * input[i]);
				curr_min = temp * input[i];
			}
			System.out.println("curr_max: " + curr_max + "\ncurr_min: " + curr_min);
			if (max < curr_max)
				max = curr_max;
		}
		return max;
	}
}
