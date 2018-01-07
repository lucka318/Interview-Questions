package cracking.the.code.interview.linked_lists;

import cracking.the.code.interview.utilities.List;
import cracking.the.code.interview.utilities.Node;

public class Question2_3 {

	public static void main(String[] args) {
		List list = new List();
		list.addToSingleLinkedList(5);
		list.addToSingleLinkedList(7);
		list.addToSingleLinkedList(3);
		list.addToSingleLinkedList(4);
		list.addToSingleLinkedList(4);
		list.addToSingleLinkedList(5);
		list.addToSingleLinkedList(5);
		list.addToSingleLinkedList(10);
		list.addToSingleLinkedList(1);
		list.addToSingleLinkedList(4);
		list.addToSingleLinkedList(3);
		list.addToSingleLinkedList(5);
		list.addToSingleLinkedList(2);
		list.addToSingleLinkedList(1);
		Node n = list.getHead().getNext().getNext().getNext();
		System.out.println(list.toString());
		deleteNode(n);
		System.out.println(list.toString());
	}

	//Time compexity O(1)
	public static boolean deleteNode(Node n) {
		if (n == null || n.getNext() == null) { // always think of base cases!!
			return false;
		}
		n.setElement(n.getNext().getElement());
		n.setNext(n.getNext().getNext());
		return true;
	}
}
