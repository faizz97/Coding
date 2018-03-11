package dp;
/*
 * Calculate binomial coefficient for given n and k
 * 
 * Binomial coefficient(n, k) = (n!/(k!*(n-k)!))
 * 
 * Note:
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
 * C(n, 0) = C(n, n) = 1
 * */

import java.util.Scanner;
public class BinomialCoefficient {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(binomialCoefficient(n, k));
	}
	static int binomialCoefficient(int n, int k) {
		int[][] table = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || i == j)
					table[i][j] = 1;
				else
					table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
			}
		}
		return table[n][k];
	}
}
