package com.dsa.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author abhishekmittal
 *
 */

public class SinglyLinkedList {

	Node head;

	static class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
			this.next = null;

		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}
	}
	
	void insertAtFirst(Node node){
		if(head ==null){
			head = node;
			return;
		}
		System.out.println("Inserting "+node.value+" Node At First ");
		node.next = head.next;
		head.next = node;
	}
	
	void deleteAtMiddle(int value){
		if(head ==null){
			return;
		}
		Node tempNode = head;
		Node preNode = null;
		System.out.println("Deleting Node "+value);
		while(tempNode !=null){
			if(tempNode.value == value){
				preNode.next = tempNode.next;
			}
			preNode = tempNode;
			tempNode = tempNode.next;
		}
	}
	
	
	
	void insertAfter(int data,Node node){
		if(head ==null){
			head = node;
			return;
		}
		System.out.println("Inserting "+node.value+" Node After "+data);
		Node tempNode = head;
		while(tempNode !=null){
			if(tempNode.value == data){
				node.next = tempNode.next;
				tempNode.next = node;
			}
			tempNode = tempNode.next;
		}
	}
	

	
	void removeDuplicate() {
		if (head == null) {
			return;
		}
		System.out.println("Removing Duplicates");
		Set<Integer> s = new HashSet<>();
		Node node = head;
		while (node != null) {
			if (!s.add(node.value)) {
				deleteAtMiddle(node.value);
			}
			node = node.next;
		}
	}
	
	void traversal() {
		System.out.println("Travesing Node");
		Node node = head;
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
		System.out.println("END");
	}

	public static void main(String[] args) {
		System.out.println("--------SinglyLinkedList Program---------");
		
		SinglyLinkedList sLinkedlist = new SinglyLinkedList();
		sLinkedlist.head = new Node(1);
		sLinkedlist.head.next= new Node(2);
		sLinkedlist.head.next.next = new Node(3);
		sLinkedlist.head.next.next.next = new Node(4);
		sLinkedlist.head.next.next.next.next = new Node(4);
		sLinkedlist.head.next.next.next.next.next = new Node(2);

		sLinkedlist.traversal();
		
		Node newNode = new Node(5);
		sLinkedlist.insertAtFirst(newNode);
		sLinkedlist.traversal();
		
		Node newNode2 = new Node(15);
		sLinkedlist.insertAfter(3, newNode2);
		sLinkedlist.traversal();

		
		sLinkedlist.deleteAtMiddle(3);
		sLinkedlist.traversal();
		
		sLinkedlist.removeDuplicate();
		sLinkedlist.traversal();
		
		
	}

}
