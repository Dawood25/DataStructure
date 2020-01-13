package com.linkedList;

import java.util.Scanner;

public class TestClass {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);		
		
		
		SinglyLinkedList linkedList=new SinglyLinkedList();
		SinglyLinkedList linkedList2=new SinglyLinkedList();
		linkedList.insertNodeAtHead(30);
		linkedList2.insertNodeAtHead(300);
		linkedList.insertNodeAtHead(20);
		linkedList2.insertNodeAtHead(200);
		linkedList.insertNodeAtEnd(40);
		linkedList2.insertNodeAtEnd(400);
		linkedList.insertNodeAtEnd(50);
		linkedList2.insertNodeAtEnd(500);
		linkedList.insertNodeAtIndex(2, 35);
		linkedList2.insertNodeAtIndex(2,350);
		linkedList.insertNodeAtIndex(5, 55);
		linkedList2.insertNodeAtIndex(5, 550);
		linkedList.insertNodeAtIndex(0, 10);
		linkedList2.printLinkedList();
		linkedList.printLinkedList();
		sc.close();
	}
}
