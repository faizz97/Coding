package advanced;
/* 
 * Time Complexity: O(sqrt(N))
 * Space Complexity: O(sqrt(N))
 */ 
 
/* Explanation: https://competitivecodingusingalgorithms.blogspot.in/2017/10/square-root-decomposition-technique.html */

import java.util.Arrays;
import java.util.Scanner;

public class SquareRootDecomposition {
	
	static Scanner sc = new Scanner(System.in);
	long[] array;
	long[] blockSum;
	int sqrt;
	
	public static void main(String args[]) {
		int N = sc.nextInt();
		long[] arr = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		SquareRootDecomposition sqrtd = new SquareRootDecomposition(arr);
		System.out.println("\n" + sqrtd.rangeSum(3, 7));
		System.out.println(sqrtd);
		sqrtd.update(4, 6);
		System.out.println(sqrtd);
	}
	
	public SquareRootDecomposition(long[] input) {
		this.sqrt = (int) Math.ceil(Math.sqrt(input.length));
		this.array = new long[sqrt * sqrt];
		this.blockSum = new long[sqrt];
		System.arraycopy(input, 0, array, 0, input.length);
		for (int i = 0; i < array.length; i++)
			blockSum[i / sqrt] += array[i];
	}
	
	void update(int loc, long newValue) {
		long oldValue = array[loc]; 
		array[loc] = newValue;
		int block = loc / sqrt;
		blockSum[block] = blockSum[block] - oldValue + newValue; 
	}
	
	long rangeSum(int startIndex, int endIndex) {
		long result = 0;
		int startBlock = startIndex / sqrt;
		int endBlock = endIndex / sqrt;
		System.out.println("\nStart Block: " + startBlock);
		System.out.println("End Block: " + endBlock);
		for (int i = startBlock + 1; i < endBlock; i++)
			result += blockSum[i];
		for (int i = startIndex; i < (startBlock + 1) * sqrt; i++)
			result += array[i];
		for (int i = endBlock * sqrt; i <= endIndex; i++)
			result += array[i];
		return result;
	}
	
	public String toString() {
		String str = "\nDetails: \nSquare Root: " + sqrt + "\nArray: " + Arrays.toString(array) + "\nBlock Sum: " 
						+ Arrays.toString(blockSum);
		return str;
	}
	
}