package edu.njust.stack;

/**
 * 数组实现栈 min取最小元素
 * @author sampson
 *
 * @param <E>
 */
public class MyNewStack {
	MyStack<Integer> myStack;
	MyStack<Integer> minStack;
	
	public MyNewStack() {
		// TODO Auto-generated constructor stub
		myStack=new MyStack<Integer>();
		minStack=new MyStack<Integer>();
	}
	public void push(int data) {
		myStack.push(data);
		if(minStack.isEmpty()){
			minStack.push(data);
		}else if(minStack.peek()>=data){
			minStack.push(data);
		}
	}
	
	public int pop() {
		int my=myStack.pop();
		if(min()==my){
			minStack.pop();
		}
		return my;
	}
	
	public int min() {
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}else {
			return minStack.peek();
		}
	}
	
	
	public static void main(String[] args) {
		MyNewStack myNewStack=new MyNewStack();
		
		int[] a={5,4,2,7,1,9};
		for(int i=0;i<a.length;i++){
			myNewStack.push(a[i]);
			System.out.println("当前最小"+myNewStack.min());
		}
		System.out.println("出栈后");
		for(int i=0;i<a.length;i++){
			myNewStack.pop();
			System.out.println("当前最小"+myNewStack.min());
		}
	}
}
