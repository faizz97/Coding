package dp;

public class MatrixChainMultiplication {
	public static void main(String args[]) {
		long input[] = {2, 3, 6, 4, 5};
		System.out.println(minCost(input));
	}
	public static long minCost(long input[]) {
		int length = input.length;
		long memory[][] = new long[length][length];
		for (int L = 2; L < length; L++) {
			for (int i = 0; i < length - L; i++) {
				int j = i + L;
				memory[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					long result = memory[i][k] + memory[k][j] + input[i] * input[k] * input[j];
					if (result < memory[i][j])
						memory[i][j] = result;
				}
			}
		}
		return memory[0][length - 1];
	}
}
