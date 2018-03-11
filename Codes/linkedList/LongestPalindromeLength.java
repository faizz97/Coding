package linkedList;

public class LongestPalindromeLength {
	public static void main(String args[]) {
		new LongestPalindromeLength();
	}
	public LongestPalindromeLength() {
		begin();
	}
	public void begin() {
		LinkedList list = new LinkedList();
		String input = "abaradarb";
		for (int i = 0; i < input.length(); i++)
			list.add(input.charAt(i));
		System.out.println(list.longestPalindrome());
	}
	class Node {
		Node next;
		char data;
		public Node(char data) {
			this.data = data;
			this.next = null;
		}
	}
	class LinkedList {
		Node head = null;
		public void add(char data) {
			if (head == null)
				head = new Node(data);
			else {
				Node n = new Node(data);
				n.next = head;
				head = n;
			}
		}
		public int longestPalindrome() {
			int result = 0;
			Node node = this.head;
			Node prev = null, curr = node, next;
			while (curr != null) {
				next = curr.next;
				curr.next = prev;
				result = Math.max(result, 2 * count(prev, next) + 1);		// for odd-length palindrome
				result = Math.max(result, 2 * count(curr, next));			// for even length palindrome
				prev = curr;
				curr = next;
			}
			return result;
		}
		private int count(Node n1, Node n2) {
			int count = 0;
			while (n1 != null && n2 != null && n1.data == n2.data) {
				count++;
				n1 = n1.next;
				n2 = n2.next;
			}
			return count;
		}
	}
}
