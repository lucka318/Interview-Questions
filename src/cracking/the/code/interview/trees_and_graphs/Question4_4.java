package cracking.the.code.interview.trees_and_graphs;

import cracking.the.code.interview.utilities.TreeNode;

/**
 * Determine if the tree is balanced. Tree is balanced if the heights of two
 * subtrees of any node never differ by more than one. So what we need to do:
 * determine the height of each subtree and determine the difference between
 * each subtree. By this definition we can divide the problem into two
 * subproblems, that is we can create two methods - one for subtree height and
 * one for determining if the subtrees are balanced, leading to the answer if
 * tree is balanced.
 * 
 * @author Lu
 *
 */
public class Question4_4 {

	public static void main(String[] args) {

		TreeNode root = createBinaryTree();
		System.out.println(isBalancedBad(root));
		System.out.println(isBalanced(root));
	}

	/**
	 * This method runs in O(nlogn) time, because for each node we check height
	 * of it's subtree. This is not an efficient way to do it, because we go
	 * through subtrees multiple times.
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBalancedBad(TreeNode root) {
		if (root == null) {
			return true;
		}

		int leftSubtreeHeight = treeHeightBad(root.getLeft());
		int rightSubtreeHeight = treeHeightBad(root.getRight());

		if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
			return false;
		} else {
			return isBalancedBad(root.getLeft())
					&& isBalancedBad(root.getRight());
		}
	}

	public static int treeHeightBad(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int leftSubtreeHeight = treeHeightBad(root.getLeft()) + 1; // incrementing
																	// tree
																	// height
		int rightSubtreeHeight = treeHeightBad(root.getRight()) + 1;
		return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1; // height is the
																// maximum of
																// subtree
																// heights
	}

	/**
	 * Time complexity is O(n)  because we touch each node once.
	 * Memory complexity is O(H) where H is height of the tree
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode root) {
		return treeHeight(root) != Integer.MIN_VALUE;
	}

	public static int treeHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}

		int leftSubtreeHeight = treeHeight(root.getLeft()) + 1;
		if (leftSubtreeHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightSubtreeHeight = treeHeight(root.getRight()) + 1;
		if (rightSubtreeHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
		}
	}

	private static TreeNode createBinaryTree() {
		TreeNode node2 = new TreeNode(2, null, null);
		TreeNode node1 = new TreeNode(1, null, null);
		TreeNode node3 = new TreeNode(3, node2, node1);
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode node6 = new TreeNode(6, node3, node4);
		TreeNode node7 = new TreeNode(7, node5, node6);
		return node7;
	}

}
