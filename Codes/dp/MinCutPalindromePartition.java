package dp;

/*
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
 * For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for 
 * palindrome partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are 
 * “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed. If a string of length n containing all different 
 * characters, then minimum n-1 cuts are needed.
 * */

/* This Problem is a variation of Matrix Chain Multiplication. */
/* Source: http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/ */

public class MinCutPalindromePartition {
	public static void main(String args[]) {
		System.out.println(minCut("ababbbabbababa"));
	}
	public static int minCut(String input) {
		int length = input.length();
		int cost[][] = new int[length][length];
		boolean status[][] = new boolean[length][length];
		
		for (int i = 0; i < length; i++)
			status[i][i] = true;
		
		for (int L = 2; L < length; L++) {
			for (int i = 0; i < length - L; i++) {
				int j = i + L;
				
				if (L == 2)
					status[i][j] = (input.charAt(i) == input.charAt(j));
				
				else
					status[i][j] = (input.charAt(i) == input.charAt(j)) && status[i + 1][j - 1];
				
				if (status[i][j] == true)
					cost[i][j] = 0;
				
				else {
					cost[i][j] = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int result = cost[i][k] + cost[k + 1][j] + 1;
						if (result < cost[i][j])
							cost[i][j] = result;
					}
				}
			}
		}
		return cost[0][length - 1];
	}
}
