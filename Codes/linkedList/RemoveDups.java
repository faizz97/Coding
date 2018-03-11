/*
 * Remove duplicate elements from linked-list
 * */

package linkedList;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDups {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		new RemoveDups();
	}
	
	public RemoveDups() {
		begin();
	}
	
	void begin() {
		Node list = createList();
		printList(resultList(list));
	}
	
	Node resultList(Node list) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node p = list, q = null;
		while (p != null) {
			if (set.contains(p.data)) {
				q.next = p.next;
			}
			else {
				set.add(p.data);
				q = p;
			}
			p = p.next;
		}
		return list;
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
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node() {	}
		
		void addAtEnd(int data) {
			Node n = this;
			if (n.data != -1) {
				Node node = new Node(data);
				while (n.next != null) {
					n = n.next;
				}
				n.next = node;
			}
			else {
				this.data = data;
			}
		}
		
		void addAtBegin(int data) {
			Node n = this;
			if (n.data != -1) {
				Node node = new Node(n.data);
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
