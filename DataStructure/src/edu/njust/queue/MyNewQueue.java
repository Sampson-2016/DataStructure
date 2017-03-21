package edu.njust.queue;

import java.util.LinkedList;

/**
 * ����ʵ�ֶ���
 * @author sampson
 * @param <E>
 *
 */
public class MyNewQueue<E> {
	private int size;
	private LinkedList<E>list;
	MyNewQueue(){
		size=0;
		list=new LinkedList<E>();
	}
	
	public synchronized void put(E e) {
		list.add(e);
		size++;
	}
	public synchronized E pop() {
		size--;
		return list.removeFirst();
	}
	public synchronized boolean empty() {
		return size==0;
	}
	
	public synchronized int size() {
		return size;
	}
	
	public static void main(String[] args) {
		MyNewQueue<Integer> myNewQueue=new MyNewQueue<Integer>();
		System.out.println("���д�С��"+myNewQueue.size);
		for(int i=0;i<10;i++){
			myNewQueue.put(i);
		}
		System.out.println("���д�С��"+myNewQueue.size);
		for(int i=0;i<10;i++){
			myNewQueue.pop();
		}
		myNewQueue.pop();
		System.out.println("���д�С��"+myNewQueue.size);
	}
}
