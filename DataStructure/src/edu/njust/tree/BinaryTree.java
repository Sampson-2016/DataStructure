package edu.njust.tree;

import javax.swing.text.Position.Bias;

public class BinaryTree {
	private Node root;
	private int maxlen=0;
	public BinaryTree() {
		// TODO Auto-generated constructor stub
		this.root=null;
	}
	public Node getRoot() {
		return root;
	}
	
	public void insert(int data) {
		Node newNode=new Node(data);
		if (root==null) {
			root=newNode;
		}else {
			Node current = root;
			Node parent;
			while (true) {
				parent=current;
				if(data<current.data){
					current=current.left;
					if(current==null){
						parent.left=newNode;
						return;
					}
				}else {
					current=current.right;
					if(current==null){
						parent.right=newNode;
						return;
					}
				}
				
			}
		}	
	}
	
	public void buildTree(int [] data) {
		for (int i = 0; i < data.length; i++) {
			insert(data[i]);
		}
	}
	
	public void preOrder(Node node) {
		if(node!=null){
			System.out.print(node.data+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
		
	}
	
	public void inOrder(Node node) {
		if(node!=null){
			inOrder(node.left);
			System.out.print(node.data+" ");
			inOrder(node.right);
		}
		
	}
	
	public void postOrder(Node node) {
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data+" ");
		}
		
	}
	/**
	 * 已知中序和先序，求后序
	 * @param preOrder
	 * @param inOrder
	 * @return
	 */
	public Node initTree(int[] preOrder,int []inOrder) {
		this.root=this.initTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
		return root;
	}
	
	public Node initTree(int []preOrder,int start1,int end1,int []inOrder,int start2,int end2) {
		if(start1>end1||start2>end2){
			return null;
		}
		int rootData=preOrder[start1];
		Node head=new  Node(rootData);
		
		int rootIndex=findIndexInArray(inOrder, rootData, start2, end2);
		
		int offSet=rootIndex - start2 -1;
		
		Node leftNode=initTree(preOrder, start1+1, start1+1+offSet, inOrder, start2, start2+offSet);
		Node rightNode=initTree(preOrder, start1+2+offSet, end1, inOrder, rootIndex+1, end2);
		head.left=leftNode;
		head.right=rightNode;
		return head;
	}
	
	public int  findIndexInArray(int []a,int x,int begin,int end) {
		for(int i = begin;i<=end;i++){
			if(x==a[i]){
				return i;
			}
		}
		return -1;
	}
	
	
	private int max(int a,int b){
		return a>b?a:b;
	}
	
	public void findMaxDistance(Node node) {
		if(node==null){
			return ;
		}
		if(node.left==null){
			node.leftDis=0;
		}else{
			findMaxDistance(node.left);
			node.leftDis=max(node.left.leftDis, node.left.rightDis)+1;
		}
		
		if(node.right==null){
			node.rightDis=0;
		}else {
			findMaxDistance(node.right);
			node.rightDis=max(node.right.leftDis,node.right.rightDis)+1;
		}
		if(node.leftDis+node.rightDis>maxlen){
			maxlen=node.leftDis+node.rightDis;
		}

	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree=new BinaryTree();
/*		int [] data={3,4,7,1,8,6,2};
		binaryTree.buildTree(data);
		System.out.println("先序遍历");
		binaryTree.inOrder(binaryTree.getRoot());
		System.out.println();
		System.out.println("中序遍历");
		binaryTree.preOrder(binaryTree.getRoot());
		System.out.println();
		System.out.println("后序遍历");
		binaryTree.postOrder(binaryTree.getRoot());*/
		
		int pre[]={1,2,4,8,9,5,10,3,6,7};
		int in[]={8,4,9,2,10,5,1,6,3,7};
		binaryTree.initTree(pre, in);
		binaryTree.postOrder(binaryTree.getRoot());
		
		binaryTree.findMaxDistance(binaryTree.getRoot());
		System.out.println();
		System.out.println(binaryTree.maxlen);
		
	}
}
