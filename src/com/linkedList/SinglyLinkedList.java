package com.linkedList;

public class SinglyLinkedList {
	Node head;
	Node tail;

	class Node {
		Object data;
		Node next;

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}

	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public Node insertNodeAtHead(Object data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = node;
			return head;
		} else {
			node.next = head;
			head = node;
			return head;
		}
	}

	public Node insertNodeAtEnd(Object data) {
		Node node = new Node(data);
		if (head == null) {
			return this.insertNodeAtHead(data);
		} else {
			tail.next = node;
			tail = node;
			return head;
		}
	}

	public Node insertNodeAtIndex(int pos, Object data) {
		Node temp = head;
		Node node = new Node(data);
		if (pos == 0) {
			return this.insertNodeAtHead(data);
		} else {
			while (pos > 1 && temp != null) {
				temp = temp.next;
				pos--;
			}
			if (temp == null) {
				System.out.println("There is no such posiion");
				return head;
			}
			if (pos == 1 && temp.next != null) {
				node.next = temp.next;
				temp.next = node;
				System.out.println("Inserted in the middle");
				return head;
			}
			if (pos == 1 && temp.next == null) {
				return this.insertNodeAtEnd(data);
			}
			System.out.println("Something Unexpected occured");
			return head;
		}
	}

	public Node deleteNodeAtHead() {
		if (head == null) {
			System.out.println("your list is empty");
			return null;
		} else {
			if (head == tail) {
				head = null;
				tail = null;
				return null;
			} else {
				head = head.next;
				return head;
			}
		}
	}

	public void printLinkedList() {
		Node temp = head;
		int n = 0;
		while (temp != null) {
			System.out.println(n + " th Element is =>" + temp.data);
			temp=temp.next;
			n++;
		}

	}
}
