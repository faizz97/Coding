package dp;
import java.util.Scanner;
import java.util.Stack;

public class MaxHistogramArea {
	
	Scanner sc = new Scanner(System.in);
	
	public MaxHistogramArea() {
		begin();
	}
	
	void begin() {
		
		int N = sc.nextInt();
		
		int[] data = new int[N];
		
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		
		System.out.println(maxHistogramArea(data, N));
		
	}
	
	int maxHistogramArea(int[] data, int N) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int tmp, area = Integer.MIN_VALUE, maxArea = Integer.MIN_VALUE;
		
		int i = 0;
		
		while (i < N) {
			
			if (stack.isEmpty() || data[i] >= data[stack.peek()])
				stack.add(i++);
			
			else {
				tmp = stack.peek();
				stack.pop();
				area = data[tmp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				
				if (maxArea < area)
					maxArea = area;
			}
		}
		
		while (!stack.isEmpty()) {
			tmp = stack.peek();
			stack.pop();
			area = data[tmp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			
			if (maxArea < area)
				maxArea = area;
		}
		
		return maxArea;
	}

	public static void main(String args[]) {
		new MaxHistogramArea();
	}
	
}
