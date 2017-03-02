package cracking.the.code.interview.arrays_and_strings;

import java.util.Scanner;

/**
 * We need to determine if string has all unique characters
 * 
 * @author Lucija Megla
 *
 */
public class Question1_1 {

	public final static int size = 256;
	public final static int sizeArrBitVector = 8; // 256/32
	public final static int sizeofVector = 32; // integer has 32 bits

	/**
	 * Possible solutions:
	 * 
	 * 1. Use a HashMap, store all characters and see if there exists one
	 * character that repeats itself (there could be more, but we need to find
	 * only one); memory: O(n), time O(n)
	 * 
	 * 2. If we know how many characters there are (for example ASCII has 256
	 * characters), we can use an array of integers(or better yet booleans)
	 * where each index represents one character. During iteration over string
	 * we increment an integer on index of each character in the string (or just
	 * set flag true, if array of booleans). Everytime before setting a flag to
	 * true or before incrementing an integer we check if flag is already true
	 * or integer is already 1. If so, string doesn't have all unique
	 * characters; memory O(1), time O(1)
	 * 
	 * 3. Instead of an array, we use bit vector. If we use ascii characters we
	 * need 8 integers that will serve us as bit vectors
	 * 
	 * 4. If we can't use extra memory, that is, we cannot use data structures,
	 * we can iterate over string with two pointers (compare every char of the
	 * string to every other char of the string). One pointer will have a
	 * reference to a character, and the other pointer will iterate from that
	 * character to the end of the string. If two pointers at some time point to
	 * the same characters, string doesn't have all unique characters; memory
	 * O(1), time O(n^2)
	 * 
	 * 
	 * Possible questions: 1. Can string have spaces, fullstops, etc? If yes, do
	 * we treat their occurrences as we would treat letters? Example: if we have
	 * two spaces in a string, is that a reason to claim string doesn't have
	 * unique characters?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Enter a string");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		scan.close();

		boolean flag = allUniqueCharactersBooleanArray(s);

		if (flag) {
			System.out.println("String has unique characters");
		} else {
			System.out.println("String doesn't have unique characters");
		}

		flag = allUniqueCharactersBitVector(s);

		if (flag) {
			System.out.println("String has unique characters");
		} else {
			System.out.println("String doesn't have unique characters");
		}

	}

	private static boolean allUniqueCharactersBitVector(String s) {
		int[] bitVector = new int[sizeArrBitVector];

		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i);
			int arrayIndex = index / sizeofVector;
			int vectorIndex = index - arrayIndex * sizeArrBitVector;
			if ((bitVector[arrayIndex] & (1 << vectorIndex)) > 0) {
				return false;
			} else {
				bitVector[arrayIndex] |= (1 << vectorIndex);
			}
		}
		return true;
	}

	/**
	 * Solution two - using 256 ascii characters
	 * 
	 * @param characters
	 * @param s
	 */
	private static boolean allUniqueCharactersBooleanArray(String s) {

		boolean[] characters = new boolean[size];

		if (s.length() > size) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			int index = (int) s.charAt(i);
			if (!characters[index]) {
				characters[index] = true;
			} else {
				return false;
			}
		}
		return true;
	}
}
