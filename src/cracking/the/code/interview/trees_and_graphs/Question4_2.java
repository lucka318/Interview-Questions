package cracking.the.code.interview.trees_and_graphs;

import cracking.the.code.interview.utilitiles.TreeNode;

public class Question4_2 {

	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String[] args) {

		TreeNode root = createMinBST(arr, 0, arr.length - 1);

		printBST(root);

	}

	// extra memory because of recursion
	// time complexity O(n) - 
	public static TreeNode createMinBST(int[] arr, int startIndex, int endIndex) {
		if (startIndex > endIndex) { // base case
			return null;
		}
		int rootIndex = (endIndex + startIndex) / 2;
		TreeNode left = createMinBST(arr, startIndex, rootIndex - 1); // with
																		// each
																		// recursion
																		// we
																		// send
																		// half
																		// of
																		// the
																		// leftover
																		// array
		TreeNode right = createMinBST(arr, rootIndex + 1, endIndex);
		TreeNode root = new TreeNode(arr[rootIndex], left, right);
		return root;
	}

	public static void printBST(TreeNode root) {
		if (root == null) {
			return;
		}
		printBST(root.getLeft());
		System.out.println(root.getValue());
		printBST(root.getRight());
	}
}
