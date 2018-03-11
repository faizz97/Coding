package sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String args[]) {
		long[] arr = { 9 ,8, 1, 6, 5, 4 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	static void quickSort(long input[], int first, int last) {
		int low = first;
		int high = last;
		int pivot = first;
		while (low < high) {
			while (low <= last && input[low] <= input[pivot])
				low++;
			while (high >= first && input[high] > input[pivot])
				high--;
			if (low < high) {
				long temp = input[low];
				input[low] = input[high];
				input[high] = temp;
			}
		}
		if (pivot < high) {
			long temp = input[high];
			input[high] = input[pivot];
			input[pivot] = temp;
			quickSort(input, first, high - 1);
			quickSort(input, high + 1, last);
		}
	}
}
