package cracking.the.code.interview.trees_and_graphs;

import cracking.the.code.interview.utilities.TreeNode;

public class Question4_8 {

	public static void main(String[] args) {
		TreeNode root = createBinaryTree();
		TreeNode nodeOne = root.getLeft().getLeft().getLeft();
		TreeNode nodeTwo = root.getLeft().getRight();
		TreeNode node = findFirstCommonAncestor(root, nodeOne, nodeTwo);
		System.out.println(node.getValue());
		root = createBinaryTreeParentLinks();
		nodeOne = root.getLeft().getLeft().getLeft();
		nodeTwo = root.getLeft().getRight();
		node = findFirstCommonAncestorLinksToParent(root, nodeOne,
				nodeTwo);
		System.out.println(node.getValue());
	}

	private static TreeNode findFirstCommonAncestor(TreeNode root,
			TreeNode nodeOne, TreeNode nodeTwo) {
		if (!covers(root, nodeOne) || !covers(root, nodeTwo)) {
			return null;
		}

		boolean isLeftOne = covers(root.getLeft(), nodeOne);
		boolean isLeftTwo = covers(root.getLeft(), nodeTwo);
		if (isLeftOne != isLeftTwo) {
			return root;
		}
		TreeNode child = isLeftOne ? root.getLeft() : root.getRight();
		return findFirstCommonAncestor(child, nodeOne, nodeTwo);
	}

	private static boolean covers(TreeNode root, TreeNode nodeOne) {
		if (root == null) {
			return false;
		} else if (root == nodeOne) {
			return true;
		}
		return covers(root.getLeft(), nodeOne)
				|| covers(root.getRight(), nodeOne);
	}

	/**
	 * Time complexity is O(d) where d is the max of two depth
	 * 
	 * @param root
	 * @param nodeOne
	 * @param nodeTwo
	 * @return
	 */
	private static TreeNode findFirstCommonAncestorLinksToParent(TreeNode root,
			TreeNode nodeOne, TreeNode nodeTwo) {
		int depthNodeOne = depth(nodeOne);
		int depthNodeTwo = depth(nodeTwo);
		int delta = depthNodeOne - depthNodeTwo;
		if (delta < 0) {
			TreeNode pom = nodeOne;
			nodeOne = nodeTwo;
			nodeTwo = pom;
			delta *= -1;
		}

		while (delta > 0) {
			nodeOne = nodeOne.getParent();
			delta--;
		}

		while (nodeOne != null && nodeTwo != null && nodeOne != nodeTwo) {
			nodeOne = nodeOne.getParent();
			nodeTwo = nodeTwo.getParent();
		}

		return nodeOne;
	}

	private static int depth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.getParent();
			depth++;
		}
		return depth;
	}

	private static TreeNode createBinaryTree() {
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node5 = new TreeNode(3, node3, node7);
		TreeNode node17 = new TreeNode(17, null, null);
		TreeNode node15 = new TreeNode(15, null, node17);
		TreeNode node10 = new TreeNode(10, node5, node15);
		TreeNode node30 = new TreeNode(30, null, null);
		TreeNode node20 = new TreeNode(20, node10, node30);
		return node20;
	}

	private static TreeNode createBinaryTreeParentLinks() {
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node5 = new TreeNode(3, node3, node7);
		node3.setParent(node5);
		node7.setParent(node5);
		TreeNode node17 = new TreeNode(17, null, null);
		TreeNode node15 = new TreeNode(15, null, node17);
		node17.setParent(node15);
		TreeNode node10 = new TreeNode(10, node5, node15);
		node5.setParent(node10);
		node15.setParent(node10);
		TreeNode node30 = new TreeNode(30, null, null);
		TreeNode node20 = new TreeNode(20, node10, node30);
		node10.setParent(node20);
		node30.setParent(node20);
		return node20;
	}

}
