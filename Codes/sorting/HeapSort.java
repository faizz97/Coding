package sorting;

import java.util.Arrays;

public class HeapSort {
	public static void main(String args[]) {
		long[] arr = { 9 ,8, 1, 6, 5, 4 };
		heapSort(arr);
		//System.out.println(Arrays.toString(arr));
	}
	static void heapSort(long input[]) {
		createHeap(input);
		System.out.println("Heap: " + Arrays.toString(input));
		for (int i = input.length - 1; i >= 0 ; i--) {
			deleteHeap(input, i);
		}
	}
	static void createHeap(long input[]) {
		for (int i = 0; i < input.length; i++) {
			heapInsert(input, i, input[i]);
		}
	}
	static void heapInsert(long input[], int index, long key) {
		input[index] = key;
		while (index > 0 && input[index] < input[(int) (Math.ceil(index / 2.0) - 1)]) {
			input[index] = input[(int) (Math.ceil(index / 2.0) - 1)];
			index = (int) (Math.ceil(index / 2.0) - 1);
			input[index] = key;
		}
	}
	static void deleteHeap(long input[], int N) {
		System.out.print(input[0] + " ");
		input[0] = input[N];
		int i = 0;
		int j = 2 * i + 1;		// left child
		while (j <= N) {
			if ((j + 1) <= N && input[j] > input[j + 1])		// check left and right child
				j += 1;
			if (input[i] < input[j])
				break;
			long temp = input[i]; 
			input[i] = input[j];
			input[j] = temp;
			i = j;
			j = 2 * j + 1;
		}
	}
}
