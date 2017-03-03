package cracking.the.code.interview.arrays_and_strings;

import java.util.Scanner;

/**
 * 
 * Check if a given string is a permutation of a palindrome
 * 
 * @author Lucija Megla
 *
 */
public class Question1_4 {

	/**
	 * It is important to know that we don't need to generate all palindromes to
	 * know if a given string is a permutation of a palindrome. In fact that is
	 * quite inefficient (factorial time complexity).
	 * 
	 * If string is a permutation of a palindrome then it has to have at most
	 * one character that has an odd count. Also, we need to discuss which
	 * characters we are taking into account: only letters, are number allowed,
	 * should we ignore spaces? Here, we are only going to take into account
	 * letters, English alphabet, case insensitive.
	 * 
	 * Possible solutions:
	 * 
	 * 1. We can count how many times each character appears and then iterate
	 * over all counts to see if there is at most one odd count. Time
	 * complexity: O(n), memory: O(n).
	 * 
	 * 2. We can use a bit vector for counting and just flip between 0 and 1 if
	 * count is even or odd. Then in the end we need to check if the vector is
	 * zero or has only one 1. For this we need to know with how many characters
	 * we are working with. Time complexity: O(n), memory: O(1)
	 * 
	 * 
	 * @param args
	 */

	// solution 2
	public static void main(String[] args) {

		System.out.println("Enter the first string:");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();

		// using approach two with sorting
		boolean flag = isPermutationPalindrome(str);

		if (!flag) {
			System.out.println("String is not a permutation of a palindrome");
		} else {
			System.out.println("String is a permutation of a palindrome");
		}

	}

	private static boolean isPermutationPalindrome(String str) {

		int bitVector = 0;
		bitVector = createBitVector(bitVector, str);

		boolean flag = checkBitVector(bitVector);

		return flag;
	}

	private static boolean checkBitVector(int bitVector) {

		if (bitVector == 0) {
			return true;
		}

		if ((bitVector & (bitVector - 1)) == 0) {
			return true;
		}

		return false;
	}

	/**
	 * Create bit vector like we discussed in solution 2
	 * 
	 * @param bitVector
	 * @return
	 */
	private static int createBitVector(int bitVector, String str) {
		int size = str.length();

		for (int i = 0; i < size; i++) {
			int index = Character.toLowerCase(str.charAt(i));
			if (index >= 'a' && index <= 'z') {
				int mask = 1 << index;

				if ((bitVector & mask) == 0) {
					bitVector |= mask;
				} else {
					bitVector &= ~mask;
				}
			}
		}
		return bitVector;
	}
}
