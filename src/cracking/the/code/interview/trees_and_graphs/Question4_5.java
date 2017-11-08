package cracking.the.code.interview.trees_and_graphs;

import cracking.the.code.interview.utilities.TreeNode;

/**
 * Check if binary tree is binary search tree.
 * 
 * @author Lu
 *
 */
public class Question4_5 {

	static Integer previousNode = null;

	public static void main(String[] args) {

		TreeNode root = createBinaryTree();
		System.out.println(isBSTInOrderTraversal(root));
		System.out.println(isBSTMinMaxTraversal(root, null, null));
	}

	/**
	 * Uses in order traversal. It won't work if there are duplicated values in
	 * the tree. Time complexity is O(n), memory complexity is O(h) where h is
	 * height of a tree. Even though we will call the function for each node,
	 * recursion functions end and that memory is reused for another function
	 * call. Hence we get memory complexity of O(h).
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBSTInOrderTraversal(TreeNode root) {
		if (root == null) {
			return true;
		}
		// in order traversal
		if (!isBSTInOrderTraversal(root.getLeft()))
			return false;
		if (previousNode != null && root.getValue() < previousNode.intValue())
			return false;
		previousNode = root.getValue();
		if (!isBSTInOrderTraversal(root.getRight()))
			return false;

		return true;
	}

	/**
	 * Time complexity is O(n), memory complexity is O(h) where h is
	 * height of a tree. Even though we will call the function for each node,
	 * recursion functions end and that memory is reused for another function
	 * call. Hence we get memory complexity of O(h). In balanced tree thats O(logn)
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBSTMinMaxTraversal(TreeNode root, Integer min,
			Integer max) {
		if (root == null) {
			return true;
		}

		// first part is for the right tree
		// second part is for the left tree
		if ((min != null && root.getValue() <= min) || (max != null && root.getValue() > max)) {
			return false;
		}
		
		if (!isBSTMinMaxTraversal(root.getLeft(), min, root.getValue()))
			return false;
		if (!isBSTMinMaxTraversal(root.getRight(), root.getValue(), max))
			return false;

		return true;
	}

	private static TreeNode createBinaryTree() {
		TreeNode node1 = new TreeNode(1, null, null);
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node2 = new TreeNode(2, node1, node3);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node6 = new TreeNode(6, node5, node7);
		TreeNode node4 = new TreeNode(4, node2, node6);
		return node4;
	}
}
