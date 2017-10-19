package cracking.the.code.interview.utilitiles;

public class List {

	private Node head;
	private Node tail;

	public List() {
	}

	public void addToSingleLinkedList(int element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public void deleteFromSingleLinkedList(int element) {
		if (head == null) {
			return;
		}
		
		while (head.getElement() == element) {
			head = head.getNext();
			if (head == null) {
				tail = null;
				return;
			}
		}

		Node n = head;
		while (n.getNext() != null) {
			if (n.getNext().getElement() == element) {
				n.setNext(n.getNext());
			} else {
				n = n.getNext();
			}
		}

		if (n.getNext().getElement() == element) {
			n.setNext(null);
			tail = n;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node n = head;
		while (n != null) {
			sb.append(n.getElement() + " ");
			n = n.getNext();
		}
		return sb.toString();
	}

	public Node getHead() {
		return head;
	}
}
