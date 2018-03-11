package linkedList;

public class CheckPalindrome {
	
	public static void main(String args[]) {
		List list = new List();
		list.add('m');
		list.add('a');
		list.add('d');
		list.add('a');
		list.add('m');
		System.out.println(list.isPalindrome(list));
	}
}
class List {
	class NodeX {
		char data;
		NodeX next;
		public NodeX(char data) {
			this.data = data;
			this.next = null;
		}
	}
	class Result {
		NodeX node;
		boolean res;
		public Result() { }
		public Result(NodeX node, boolean res) {
			this.node = node;
			this.res = res;
		}
	}
	NodeX head = null;
	void add(char data) {
		NodeX n = new NodeX(data);
		n.next = this.head;
		this.head = n;
	}
	public boolean isPalindrome(List list) {
		return checkPalindrome(list.head);
	}
	private boolean checkPalindrome(NodeX head) {
		int length = getLength(head);
		return isPalindrome(head, length).res;
	}
	private Result isPalindrome(NodeX head, int length) {
		if (head == null || length == 0) {
			return new Result(head, true);
		}
		else if (length == 1) {
			return new Result(head.next, true);
		}
		boolean res = false;
		Result result = isPalindrome(head.next, length - 2);
		if (result.res && result.node.data == head.data)
				res = true;
		
		Result r = new Result(result.node.next, res);
		
		return r;
	}
	private int getLength(NodeX head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
