/*
 * O(N*logN)
 * */

package linkedList;

public class MergeSort {
	public static void main(String args[]) {
		MyLinkedList1 list = new MyLinkedList1(9);
		list.add(7);
		list.add(6);
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(3);
		list.printList(list.sort(list.head));
	}
}
class MyLinkedList1 {
	
	ListNode head = null;
	
	public MyLinkedList1(int data) {
		ListNode n = new ListNode(data);
		this.head = n;
	}
	
	class ListNode {
		int data;
		ListNode next;
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void add(int data) {
		ListNode node = new ListNode(data);
		if (this.head == null) {
			this.head = node;
		}
		else {
			ListNode p = this.head;
			while (p.next != null)
				p = p.next;
			p.next = node;
		}
	}
	
	public void printList(ListNode head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public ListNode sort(ListNode n) {
		if (n == null || n.next == null)
			return n;
		ListNode middle = getMiddle(n);
		ListNode nextOfMiddle = middle.next;
		middle.next = null;
		ListNode left = sort(n);
		ListNode right = sort(nextOfMiddle);
		ListNode sortedList = merge(left, right);
		return sortedList;
	}
	
	private ListNode merge(ListNode h1, ListNode h2) {
		if (h1 == null)
			return h2;
		if (h2 == null)
			return h1;
		ListNode result = null;
		if (h1.data <= h2.data) {
			result = h1;
			result.next = merge(h1.next, h2);
		}
		else {
			result = h2;
			result.next = merge(h1, h2.next);
		}
		return result;
	}
	
	private ListNode getMiddle(ListNode n) {
		if (n == null)
			return n;
		ListNode p = n.next;
		while (p != null) {
			p = p.next;
			if (p != null) {
				n = n.next;
				p = p.next;
			}
		}
		return n;
	}
}
