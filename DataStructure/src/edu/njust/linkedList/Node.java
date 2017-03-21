package edu.njust.linkedList;

public class Node {
	Node next=null;
	int data;
	public  Node(int data1) {
		this.data=data1;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node node) {
		next=node;
	}
	public int getData() {
		return data;
	}
}
