/*
 * Calculate Nth Fibonacci Number in log(N) time.
 * Method: Matrix Exponentiation.
 * */

/* Link to explanation: https://www.youtube.com/watch?v=EEb6JP3NXBI */

package advanced;

public class MatrixExponentiation {
	public static void main(String args[]) {
		System.out.println(NthFibonacci(14));
	}
	static long NthFibonacci(long n) {
		// Base cases
		if (n == 1)
			return 1;
		if (n == 0)
			return 0;
		// Converting the recursive Fibonacci formula into 2D-matrix
		long matrix[][] = {{1, 1}, {1, 0}};
		long base[][] = {{1}, {0}};
		matrix = multiplyMatrices(fastPower(matrix, (n - 1)), base);
		return matrix[0][0];
	}
	static long[][] fastPower(long x[][], long y) {				// Matrix Exponentiation logic
		long result[][] = new long[x.length][x[0].length];
		if (y == 0) {			// If y == 0, return identity matrix
			for (int i = 0; i < result.length; i++) {
				result[i][i] = 1;
			}
			return result;
		}
		if (y == 1)				// If y == 1, return x[]
			return x;
		
		result = x;
		y--;
		
		while (y > 0) {			// Fast Exponentiation Logic
			if (y % 2 == 1) {
				result = multiplyMatrices(result, x);
				y--;
			}
			x = multiplyMatrices(x, x);
			y /= 2;
		}
		return result;
	}
	static long[][] multiplyMatrices(long[][] m1, long[][] m2) {		// For multiplying two matrices
		long[][] result = new long[m1.length][m2[0].length];
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					result[i][j] += (m1[i][k] * m2[k][j]);
				}
			}
		}
		return result;
	}
	static void printMatrix(long[][] m) {			// For printing out any given matrix
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
