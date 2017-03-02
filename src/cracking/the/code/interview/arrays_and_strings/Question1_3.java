package cracking.the.code.interview.arrays_and_strings;

import java.util.Scanner;

/**
 * Replace all spaces in a string wih %20
 * 
 * @author Lu
 *
 */
public class Question1_3 {

	/**
	 * Possible solutions:
	 * 
	 * 1. We need to pointers: one to track a position in "new" array and the
	 * one to track a position in the old array. We iterate over the original
	 * array backwards. If the current characters is not space, we just move it
	 * to an index of the second pointer. Otherwise, we insert %20, and move
	 * pointer for 3 spots. Time complexity: O(n), memory: O(1) (if we assume we
	 * already have char array with enough space)
	 * 
	 * Possible problems: if you are going through solutions in the book, you'll
	 * see a line str[lenght]='\0'. I suppose it determines the end of char
	 * array, but! in Java it DOESN'T do anything. Java keeps size of an array
	 * to manipulate with arrays. On the other hand, if you are using C, you
	 * should use '\0', because there is no other way to know the end of a char
	 * array.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Enter the first string:");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();

		// using approach two with sorting
		String newString = insertion(str);

		System.out.println("New string:");
		System.out.println(newString);
	}

	private static String insertion(String str) {

		// we have to count how many spaces we have so we could determine the
		// size of char array
		int spaceFrequency = countSpaceFrequency(str);
		int sizeStr = str.length();

		char[] arr = new char[sizeStr + spaceFrequency * 2];
		// since we have a string and new char array, we could just iterate over
		// string and insert characters in the array, but we are going to
		// pretend like we can't do that so we could pratice in-place operations
		for (int i = 0; i < sizeStr; i++) {
			arr[i] = str.charAt(i);
		}
		int pointerNewString = sizeStr + spaceFrequency * 2 - 1;

		for (int i = sizeStr - 1; i >= 0; i--) {
			if (arr[i] == ' ') {
				arr[pointerNewString] = '0';
				pointerNewString--;
				arr[pointerNewString] = '2';
				pointerNewString--;
				arr[pointerNewString] = '%';
				pointerNewString--;
			} else {
				arr[pointerNewString] = arr[i];
				pointerNewString--;
			}
		}
		return new String(arr);
	}

	private static int countSpaceFrequency(String str) {
		int spaceFrequency = 0;
		int sizeStr = str.length();
		for (int i = 0; i < sizeStr; i++) {
			if (str.charAt(i) == ' ') {
				spaceFrequency++;
			}
		}
		return spaceFrequency;
	}

}
