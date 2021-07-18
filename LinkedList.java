package com.bridgelabz.stockmanagement;

public class LinkedList {
	Node head;

	public class Node {
		CompanyShare data;
		Node next;

		Node(CompanyShare data) {
			this.data = data;
		}
	}

	public void append(CompanyShare newData) {
		Node newNode = new Node(newData);
		if (head == null) {
			head = newNode;
			return;
		}
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = newNode;
	}
}
