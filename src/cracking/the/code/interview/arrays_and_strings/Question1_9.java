package cracking.the.code.interview.arrays_and_strings;

import java.util.Scanner;

/**
 * Check string rotation
 * 
 * @author Lucija Megla
 *
 */
public class Question1_9 {

	/**
	 * Concatenating two string creates new string, so we have additional
	 * memory: O(m+n), where m and n are size of strings one and two
	 * respectively. Time complexity: depends on contains() runtime, O(m*n).
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

		boolean flag = isRotation(str1, str2);

		if (flag) {
			System.out.println("String two is a rotation of first string");
		} else {
			System.out.println("String two is not a rotation of first string");
		}
	}

	private static boolean isRotation(String str1, String str2) {
		if (str2.length() != str1.length() || str1.isEmpty()) {
			return false;
		}
		return isSubstring(str1 + str1, str2);
	}

	private static boolean isSubstring(String string, String str2) {
		return string.contains(str2);
	}
}
