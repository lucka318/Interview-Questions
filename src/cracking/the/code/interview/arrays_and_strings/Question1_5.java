package cracking.the.code.interview.arrays_and_strings;

import java.util.Scanner;

/**
 * Check if two strings are zero or one edit away
 * 
 * @author Lucija Megla
 *
 */
public class Question1_5 {

	/**
	 * We have three cases: delete character, insert character or replace a
	 * character. We build 2 cases out of it: insertion/deletion and replace
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Enter the first string:");
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		System.out.println("Enter the second string:");
		String str2 = scan.nextLine();
		scan.close();

		// using approach two with sorting
		boolean flag = checkEdits(str1, str2);

		if (!flag) {
			System.out.println("Strings are not zero/one edit away");
		} else {
			System.out.println("Strings are zero/one edit away");
		}

	}

	private static boolean checkEdits(String str1, String str2) {
		if (str1.equals(str2)) { // zero edits
			return true;
		}

		int sizeStr1 = str1.length();
		int sizeStr2 = str2.length();
		boolean changeHappened = false;
		if (sizeStr1 == sizeStr2) { // replacing
			changeHappened = oneReplaceAway(str1, str2);
		} else if (sizeStr1 == sizeStr2 + 1) { // deletion happened: second
												// string is smaller
			changeHappened = oneEditAway(str2, str1);
		} else if (sizeStr1 == sizeStr2 - 1) { // insertion happened second
												// string is bigger
			changeHappened = oneEditAway(str1, str2);
		}

		return changeHappened;
	}

	private static boolean oneEditAway(String str1, String str2) {
		int size1 = str1.length();
		int size2 = str2.length();

		int index1 = 0;
		int index2 = 0;

		while (index1 < size1 && index2 < size2) {
			if (str1.charAt(index1) != str2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	private static boolean oneReplaceAway(String str1, String str2) {
		boolean changeHappened = false;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (changeHappened) {
					return false;
				}
				changeHappened = true;
			}
		}
		return true;
	}
}
