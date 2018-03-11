package sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String args[]) {
		long[] arr = { 9 ,8, 1, 6, 5, 4 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	static void mergeSort(long input[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(input, low, mid);
			mergeSort(input, mid+1, high);
			merge(input, low, mid, high);
		}
	}
	static void merge(long input[], int low, int mid, int high) {
		int p = low;
		int q = mid + 1;
		int k = 0, j = 0;
		long[] temp = new long[input.length];
		while (p <= mid && q <= high) {
			if (input[p] < input[q]) {
				temp[k] = input[p];
				p++;
			}
			else {
				temp[k] = input[q];
				q++;
			}
			k++;
		}
		while (p <= mid) {
			temp[k] = input[p];
			p++;
			k++;
		}
		while (q <= high) {
			temp[k] = input[q];
			q++;
			k++;
		}
		for (int i = low; i < low + k; i++) {
			input[i] = temp[j];
			j++;
		}
	}
}
