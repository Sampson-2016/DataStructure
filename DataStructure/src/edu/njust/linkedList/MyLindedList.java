package edu.njust.linkedList;

public class MyLindedList {
	Node head = null;

	/**
	 * add data to List @ param data:插入的数据
	 * */
	public void addNode(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param num
	 *            :删除第num个节点,从1开始
	 * */
	public boolean delete(int num) {
		if (num < 1 || num > length()) {
			System.out.println("删除位置不合理");
			return false;
		}

		if (num == 1) {
			head = head.next;
			return true;
		}
		Node temp = head;
		int i = 1;
		while (i < num - 1) {
			temp = temp.next;
			i++;
		}
		temp.next = temp.next.next;
		return true;

	}

	/** 获取链表长度 */
	public int length() {
		Node temp = head;
		int i = 0;
		while (temp != null) {
			i++;
			temp = temp.next;
		}
		return i;
	}

	/**
	 * 给链表排序 从小到大
	 */
	public void orderList() {
		Node curNode = head;
		if (curNode.next == null || curNode.next == null) {
			return;
		}
		int temp;
		while (curNode != null) {
			Node nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.data > nextNode.data) {
					temp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = temp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}

	}

	/**
	 * 
	 * @param k
	 *            输出倒数第几个节点
	 * @return
	 */
	public Node findElem(int k) {
		int all = length();
		if (k < 1 || k > all) {
			return null;
		}
		int i = 1, j = all - k + 1;
		Node node = head;
		while (i != j) {
			i++;
			node = node.next;
		}
		return node;
	}

	/** 打印链表数据 */
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	/**
	 * 删除重复节点
	 */
	public void deleteDuplecate() {
		Node curNode = head;

		while (curNode != null) {
			Node nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.data == nextNode.data) {
					curNode.next = nextNode.next;
				}
				nextNode = nextNode.next;

			}
			curNode = curNode.next;
		}
	}

	/**
	 * 链表倒序
	 */
	public void reverse() {
		Node pReverseHead = head;
		Node pNode = head;
		Node pPrev = null;
		while (pNode != null) {
			Node pNext = pNode.next;
			if (pNext == null) {
				pReverseHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		head = pReverseHead;

	}
/**
 * 倒序输出
 * @param node
 */
	public void printListReverse(Node node) {
		if (node != null) {
			printListReverse(node.next);
			System.out.print(node.data + " ");
		}
	}
	
	/**
	 * 查询中间节点
	 * @return
	 */
	public Node SearchMid() {
		Node one=head;
		Node two=head.next;
		while (two.next!=null&&two!=null&&two.next.next!=null) {
			one=one.next;
			two=two.next.next;
		}
		return one;
	}
	
	

	public static void main(String[] args) {

		MyLindedList myLindedList = new MyLindedList();

		myLindedList.addNode(5);
		myLindedList.addNode(2);
		myLindedList.addNode(11);
		myLindedList.addNode(3);
		myLindedList.addNode(3);
		myLindedList.addNode(4);
		myLindedList.addNode(11);
		myLindedList.printList();

		System.out.println();
		System.out.println("反转");
		myLindedList.reverse();
		myLindedList.printList();

		System.out.println();
		System.out.println("倒序打印");
		myLindedList.printListReverse(myLindedList.head);

		System.out.println();
		System.out.println("单链表长度：" + myLindedList.length());

		myLindedList.orderList();
		System.out.println("排序后");
		myLindedList.printList();
		System.out.println();
		
		System.out.println("中间节点："+myLindedList.SearchMid().data);
		
		
		System.out.println("倒数第4个");
		try {
			System.out.println(myLindedList.findElem(4).data);
		} catch (Exception e) {
			System.out.println("输入数字不在范围内");
		}

		myLindedList.deleteDuplecate();
		System.out.println("删除重复节点后");
		myLindedList.printList();

		System.out.println();
		System.out.println("单链表长度：" + myLindedList.length());

		myLindedList.orderList();
		System.out.println("排序后");
		myLindedList.printList();
		System.out.println();

		myLindedList.delete(2);
		System.out.println("删除后");
		myLindedList.printList();

		System.out.println("单链表长度：" + myLindedList.length());
	}
}
