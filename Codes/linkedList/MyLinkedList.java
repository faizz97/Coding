package linkedList;

public class MyLinkedList<T> {
	Node<T> head = null;
	public void addToEnd(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		if (this.head != null) {
			Node<T> p = head;
			while (p.next != null)
				p = p.next;
			p.next = node;
		}
		else {
			this.head = node;
		}
	}
	public void addToBegin(T data) {
		Node<T> node = new Node<T>();
		if (this.head != null) {
			node.data = this.head.data;
			node.next = this.head.next;
			this.head.data = data;
			this.head.next = node;
		}
		else {
			node.data = data;
			this.head = node;
		}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<T> p = this.head;
		while (p != null) {
			sb.append(p.data + (p.next == null ? "" : ", "));
			p = p.next;
		}
		sb.append("]");
		return sb.toString();
	}
}
class Node<T> {
	T data = null;
	Node<T> next = null;
}
