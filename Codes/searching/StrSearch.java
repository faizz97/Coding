package searching;

import java.util.Arrays;

public class StrSearch {
	public static void main(String args[]) {
		String arr[] = { "abc", "", "bcd", "", "", "xyz", "" };
		System.out.println(Arrays.binarySearch(arr, "xyz"));
	}
}
