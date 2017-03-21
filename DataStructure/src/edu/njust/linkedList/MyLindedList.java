package edu.njust.linkedList;

public class MyLindedList {
	Node head = null;

	/**
	 * add data to List @ param data:���������
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
	 * ɾ������
	 * 
	 * @param num
	 *            :ɾ����num���ڵ�,��1��ʼ
	 * */
	public boolean delete(int num) {
		if (num < 1 || num > length()) {
			System.out.println("ɾ��λ�ò�����");
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

	/** ��ȡ������ */
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
	 * ���������� ��С����
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
	 *            ��������ڼ����ڵ�
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

	/** ��ӡ�������� */
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	/**
	 * ɾ���ظ��ڵ�
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
	 * ������
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
 * �������
 * @param node
 */
	public void printListReverse(Node node) {
		if (node != null) {
			printListReverse(node.next);
			System.out.print(node.data + " ");
		}
	}
	
	/**
	 * ��ѯ�м�ڵ�
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
		System.out.println("��ת");
		myLindedList.reverse();
		myLindedList.printList();

		System.out.println();
		System.out.println("�����ӡ");
		myLindedList.printListReverse(myLindedList.head);

		System.out.println();
		System.out.println("�������ȣ�" + myLindedList.length());

		myLindedList.orderList();
		System.out.println("�����");
		myLindedList.printList();
		System.out.println();
		
		System.out.println("�м�ڵ㣺"+myLindedList.SearchMid().data);
		
		
		System.out.println("������4��");
		try {
			System.out.println(myLindedList.findElem(4).data);
		} catch (Exception e) {
			System.out.println("�������ֲ��ڷ�Χ��");
		}

		myLindedList.deleteDuplecate();
		System.out.println("ɾ���ظ��ڵ��");
		myLindedList.printList();

		System.out.println();
		System.out.println("�������ȣ�" + myLindedList.length());

		myLindedList.orderList();
		System.out.println("�����");
		myLindedList.printList();
		System.out.println();

		myLindedList.delete(2);
		System.out.println("ɾ����");
		myLindedList.printList();

		System.out.println("�������ȣ�" + myLindedList.length());
	}
}
