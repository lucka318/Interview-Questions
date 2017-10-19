package cracking.the.code.interview.linked_lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cracking.the.code.interview.utilitiles.List;
import cracking.the.code.interview.utilitiles.Node;

public class Question2_1 {

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
		list = removeDuplicates(list);
	}

	private static List removeDuplicates(List list) {
		Set<Integer> set = new HashSet<Integer>();
		Node n = list.getHead();
		if (set.contains(n.getElement())) { // contains
			// delete node
		} else { // doesn't contain
			// go to the next node
		}
		return null;
	}
}
