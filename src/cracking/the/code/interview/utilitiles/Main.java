package cracking.the.code.interview.utilitiles;

public class Main {

	public static void main(String[] args) {
		List l = new List();
		
		System.out.println(l.toString());
		
		l.deleteFromSingleLinkedList(5);
		
		System.out.println(l.toString());
	}
}
