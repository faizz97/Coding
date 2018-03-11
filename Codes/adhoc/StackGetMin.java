package adhoc;

import java.util.Stack;

/* Push, Pop, getMin in O(1) with O(1) extra space */

public class StackGetMin {
	public static void main(String args[]) {
		MyStack stack = new MyStack();
		stack.push(5);
		System.out.println("5 Pushed.");
		System.out.println("Min: " + stack.getMin());
		stack.push(3);
		System.out.println("3 Pushed.");
		System.out.println("Min: " + stack.getMin());
		stack.push(10);
		System.out.println("10 Pushed.");
		System.out.println("Min: " + stack.getMin());
		stack.push(8);
		System.out.println("8 Pushed.");
		System.out.println("Min: " + stack.getMin());
		stack.push(2);
		System.out.println("2 Pushed.");
		System.out.println("Min: " + stack.getMin());
		stack.push(1);
		System.out.println("1 Pushed.");
		System.out.println("Min: " + stack.getMin());
		stack.pop();
		System.out.println(stack.peek());
		System.out.println("Min: " + stack.getMin());
	}
}
class MyStack {
	Stack<Integer> stack = new Stack<Integer>();
	int min;
	public void push(int data) {
		if (stack.isEmpty()) {
			min = data;
			stack.push(data);
		}
		else if (data < min) {
			stack.push(2 * data - min);
			min = data;
		}
		else
			stack.push(data);
	}
	public int pop() {
		int temp = stack.pop();
		int result;
		if (temp < min) {
			result = min;
			min = 2 * min - temp;
			return result;
		}
		else
			return temp;
	}
	public int peek() {
		if (stack.peek() < min)
			return min;
		else
			return stack.peek();
	}
	public int getMin() {
		return min;
	}
}
