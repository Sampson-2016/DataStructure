package edu.njust.stack;

import java.util.Arrays;

/**
 * 数组实现栈
 * @author sampson
 *
 * @param <E>
 */
public class MyStack <E>{
	private int size;
	private Object[] stack;
	public MyStack() {
		// TODO Auto-generated constructor stub
	   stack=new Object[5];
	}
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty() {
		if(size==0)
			return true;
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if(isEmpty())
			return null;
		else {
			return (E) stack[size-1];
		}
	}
	/**
	 * 出栈
	 * @return
	 */
	public E pop() {
		if(isEmpty()){
			System.out.println("空栈");
			return null;
		}else {
			E e=peek();
			stack[size-1]=null;
			size--;
			return e;
		}
	}
	/**
	 * 保证栈是否满，满了加空间
	 * @param size
	 */
	private void ensureCapacity(int size){
		int len=stack.length;
		if(len<size){
			int newLen=5+len;
			stack=Arrays.copyOf(stack, newLen);
		}
	}
	/**
	 * 入栈
	 * @param e
	 * @return
	 */
	public E push(E e) {
		ensureCapacity(size+1);
		stack[size++]=e;
		return e;
	}
	
	public static void main(String[] args) {
		MyStack<Integer> stack=new MyStack<Integer>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		stack.push(6);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
}
