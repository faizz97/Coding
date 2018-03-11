package dp;
/**
 * Given a number of dollars, n, and a list of dollar values for m distinct coins, C={c0, c1, c2,...., Cn}, 
 * find and print the number of different ways you can make change for n dollars if each coin is available in 
 * an infinite quantity.
 */

import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();					// total value
        int m = sc.nextInt();					// number of coins
        int coins[] = new int[m];				// coin values
        for(int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = sc.nextInt();
        }
        long solution = computeResult(n, m, coins);
        System.out.print(""+solution);
    }
    
    static long computeResult(int n, int m, int[] coins) {
    	long result = 0;
    	
    	long table[][] = new long[m][n+1];
    	
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n+1; j++) {
    			if(j == 0)
    				table[i][j] = 1;
    			else if(i == 0) {
    				if(j % coins[i] == 0)
    					table[i][j] = 1;
    				else
    					table[i][j] = 0;
    			}
    			else {
    				if(j >= coins[i]) {
    					table[i][j] = table[i - 1][j] + table[i][j - coins[i]];
    				}
    				else {
    					table[i][j] = table[i - 1][j];
    				}
    			}
    		}
    	}
    	/*System.out.println("\nTable:");
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n+1; j++) {
    			System.out.print(table[i][j] + " ");
    		}
    		System.out.println();
    	}*/
    	result = table[m - 1][n];
    	return result;
    }

}
