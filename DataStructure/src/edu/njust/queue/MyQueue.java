package edu.njust.queue;


import edu.njust.linkedList.Node;


/**
 * 链表实现队列
 * @author sampson
 *
 */
public class MyQueue {
	private Node head=null;
	private Node tail=null;
	
	public boolean isEmpty() {
		return head==tail;
	}
	
	public void put(int data) {
		Node node=new Node(data);
		if(head==null&&tail==null){
			head=node;
			tail=node;
		}else {
			tail.setNext(node);
			tail=node;
		}
	}
	
	public int pop() {
		try {
			int data=head.getData();
			head=head.getNext();
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;

	}
	
	public int size() {
		int n=0;
		Node temp=head;
		while (temp!=null) {
			n++;
			temp=temp.getNext();
		}
		return n;
	}
	
	public static void main(String[] args) {
		MyQueue myQueue=new MyQueue();
		myQueue.put(1);
		myQueue.put(2);
		myQueue.put(3);
		System.out.println("队列长度："+myQueue.size());
		for(int i=0;i<4;i++){
			System.out.println(myQueue.pop());
		}
		System.out.println("队列长度："+myQueue.size());
	}
}
