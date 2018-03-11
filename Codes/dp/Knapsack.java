package dp;
/* 0-1 Knapsack Problem:
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 */

import java.util.Scanner;

public class Knapsack {
	
	static Scanner sc = new Scanner(System.in);
	
	static void printTable(int[][] table, int N, int B) {
		System.out.println("\n\nTable: ");
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < B + 1; k++) {
				System.out.print(table[j][k] + " ");
			}
			System.out.println();
		}
	}
	
	static int maxValue(int N, int maxWeight) {
		int value[] = new int[N];
		int weight[] = new int[N];
		int memory[][] = new int[N][maxWeight + 1];
		
		for (int j = 0; j < N; j++) {
			value[j] = sc.nextInt();
		}
		
		for (int j = 0; j < N; j++) {
			weight[j] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < maxWeight + 1; j++) {
				if (j < weight[i]) {
					if (i == 0)
						memory[i][j] = 0;
					else
						memory[i][j] = memory[i - 1][j];
				}
				else {
					if (i == 0)
						memory[i][j] = value[i];
					else
						memory[i][j] = Math.max(memory[i - 1][j], (value[i] + memory[i - 1][j - weight[i]]));
				}
			}
		}
		return memory[N - 1][maxWeight];
	}
	
	public static void main(String args[]) {
		
		int T, N, targetWeight;
		T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			targetWeight = sc.nextInt();
			System.out.println(maxValue(N, targetWeight));
		}
	}
}