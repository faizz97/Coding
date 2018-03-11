package linkedList;

import java.util.Scanner;

public class ListAddition {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		new ListAddition();
	}
	
	public ListAddition() {
		begin();
	}
	
	void begin() {
		Node list1 = createList();
		Node list2 = createList();
		printList(result(list1, list2));
	}
	
	Node result(Node list1, Node list2) {
		Node result = new Node();
		
		int carry = 0;
		
		Node p = list1, q = list2, r = result;
		long len1 = getLength(list1);
		long len2 = getLength(list2);
		if (len1 != len2) {
			if (len1 > len2)
				list2 = addPadding(list2, len1 - len2);
			else
				list1 = addPadding(list1, len2 - len1);
		}
		
		while (p != null) {
			
			int sum = p.data + q.data + carry;
			r.addAtEnd(sum % 10);
			carry = sum > 9 ? 1 : 0;
			
			p = p.next;
			q = q.next;
		}
		if (carry == 1) {
			r.addAtEnd(1);
		}
		return result;
	}
	
	Node addPadding(Node list, long n) {
		while (n-- > 0) {
			list.addAtEnd(0);
		}
		return list;
	}
	
	long getLength(Node list) {
		Node p = list;
		long cnt = 0;
		while (p != null) {
			cnt++;
			p = p.next;
		}
		return cnt;
	}
	
	Node createList() {
		Node list = new Node();
		while (true) {
			int data = sc.nextInt();
			if (data == -1)
				break;
			list.addAtEnd(data);
		}
		return list;
	}
	
	void printList(Node list) {
		Node p = list;
		System.out.print("\nList: ");
		while (p != null) {
			System.out.print(p.data + " --> ");
			p = p.next;
		}
		System.out.println("NULL");
	}
	
	class Node {
		int data = -1;
		Node next = null;
		
		void addAtEnd(int data) {
			Node n = this;
			if (n.data != -1) {
				Node node = new Node();
				node.data = data;
				while (n.next != null) {
					n = n.next;
				}
				n.next = node;
			}
			else {
				n.data = data;
			}
		}
		
		void addAtBegin(int data) {
			Node n = this;
			if (n.data != -1) {
				Node node = new Node();
				node.data = n.data;
				node.next = n.next;
				n.data = data;
				n.next = node;
			}
			else {
				n.data = data;
			}
		}
	}
}
