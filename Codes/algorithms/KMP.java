package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class KMP {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		String str = sc.next();
		String pattern = sc.next();
		System.out.println(patternCount(str, pattern));
	}
	static int patternCount(String input, String pattern) {
		char[] arr = pattern.toCharArray();
		int[] a = createPatternArray(arr);
		System.out.println(Arrays.toString(a));
		return count(input, a, pattern);
	}
	static int count(String input, int array[], String pattern) {
		int j = 0;
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					count++;
					j = 0;
				}
				else
					j++;
			}
			else {
				/*while (j > 0 && pattern.charAt(array[j - 1]) != input.charAt(i))
					j = array[j - 1];*/
				if (j > 0) {
					j = array[j - 1];
				}
				/*else
					i++;*/
			}
		}
		return count;
	}
	static int[] createPatternArray(char inputPattern[]) {
		int[] result = new int[inputPattern.length];
		result[0] = 0;
		int i = 1, j = 0;
		while (i < inputPattern.length) {
			if (inputPattern[i] == inputPattern[j]) {
				result[i] = j + 1;
				j++;
			}
			else {
				while (j - 1 >= 0) {
					if (inputPattern[i] == inputPattern[result[j - 1]]) {
						j = result[j - 1];
						result[i] = j + 1;
						break;
					}
					j = result[j - 1];
				}
			}
			i++;
		}
		return result;
	}
}
