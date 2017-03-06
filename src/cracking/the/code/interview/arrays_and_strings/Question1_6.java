package cracking.the.code.interview.arrays_and_strings;

import java.util.Scanner;

/**
 * String compression
 * 
 * @author Lucija Megla
 *
 */
public class Question1_6 {

	/**
	 * We should iterate over string and count repeats of each consecutive
	 * characters. To build a new String we should use StringBuilder because it
	 * is the most efficient way of building a string.
	 * 
	 * Time complexity: O(n), memory: O(n)
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Enter string:");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();

		// using approach two with sorting
		String compressedString = compressString(str);

		System.out.println("String after compression: " + compressedString);

	}

	private static String compressString(String str) {
		StringBuilder sb = new StringBuilder();

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				sb.append(str.charAt(i));
				sb.append(String.valueOf(count));
				count = 0;
			}
		}

		String compressedString = sb.toString();

		String s = compressedString.length() >= str.length() ? str
				: compressedString;
		return s;
	}

}
