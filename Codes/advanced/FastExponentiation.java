package advanced;

/*
 * Calculating x^y in log(y) time
 * 
 * Constraints:
 * x and y can be negative, positive or 0
 * 
 * */

/* Asked to me in Microsoft Interview */

public class FastExponentiation {
	public static void main(String args[]) {
		System.out.println(fastPower(2, 1000));
	}
	static double fastPower(long x, long y) {
		if (y == 0)
			return 1;
		if (x == 0)
			return 0;
		
		boolean negative = false;
		boolean inverse = false;
		
		if (y % 2 == 1 && x < 0) {
			x *= -1;
			negative = true;
		}
		if (y < 0) {
			y *= -1;
			inverse = true;
		}
		
		double result = 0;
		
		while (y > 0) {
			if (y % 2 == 1) {
				result += x;
				y--;
			}
			x = x * x;
			y /= 2;
		}
		
		if (negative)
			result *= -1;
		
		if (inverse)
			result = 1.0 / (result * 1.0);
		
		return result;
	}
}
