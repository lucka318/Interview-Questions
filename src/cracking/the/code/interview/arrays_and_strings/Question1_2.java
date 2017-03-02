package cracking.the.code.interview.arrays_and_strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two strings check if one string is a permutation of another
 * 
 * @author Lucija Megla
 *
 */
public class Question1_2 {

	/**
	 * Possible solutions:
	 * 
	 * 1. We can solve this using a HashMap. We can count characters that occur
	 * in str1. Then we go over str2 and decrease the frequency of characters in
	 * the HashMap. If we encounter a character in str2 that is not in the
	 * HashMAp or frequency of characters in the HashMap becomes less than zero,
	 * then str2 is not a permutation of str1. Memory: O(n), time: O(n)
	 * 
	 * 2. If we cannot use extra memory, we can sort both strings and then
	 * compare them. Time: O(nlogn). Also, some sorting algorithms use extra
	 * memory, so be careful!
	 * 
	 * - if we again work with ascii characters, or set of characters with known
	 * size, we could use an array and then count frequency of a character on
	 * index i when iterating over str1 and then subtract the frequency when
	 * iterating over str2. If frequency goes under zero, str2 is not a
	 * permutation of str1. Memory O(1), time O(n)
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
		boolean flag = isPermutation(str1, str2);

		if (!flag) {
			System.out.println("Strings are not permutations of each other");
		} else {
			System.out.println("Strings are a permutation of each other");
		}

	}

	private static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		String sorted1 = sort(str1);
		String sorted2 = sort(str2);

		if (sorted1.equals(sorted2)) {
			return true;
		}

		return false;
	}

	private static String sort(String s) {
		char[] sorted_arr = s.toCharArray();
		Arrays.sort(sorted_arr);
		return new String(sorted_arr);
	}

}
