package cracking.the.code.interview.trees_and_graphs;

import cracking.the.code.interview.utilities.TreeNode;

public class Question4_6 {

	public static void main(String[] args) {
		TreeNode root = createBinaryTree();
		TreeNode node = root.getLeft();
		
		System.out.println(getNextInOrderSuccessor(node));
	}

	public static TreeNode getNextInOrderSuccessor(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.getRight() != null) {
			return leftMostChild(node.getRight());
		} else {
			TreeNode child = node;
			TreeNode parent = node.getParent();
			while (parent != null
					&& parent.getLeft().getValue() != child.getValue()) {
				child = parent;
				parent = parent.getParent();
			}
			return parent;
		}
	}

	private static TreeNode leftMostChild(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode leftMostChild = node;
		while (leftMostChild.getLeft() != null) {
			leftMostChild = leftMostChild.getLeft();
		}
		return leftMostChild;
	}
	
	private static TreeNode createBinaryTree() {
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node5 = new TreeNode(5, node3, node7);
		node3.setParent(node5);
		node7.setParent(node5);
		TreeNode node17 = new TreeNode(17, null, null);
		TreeNode node15 = new TreeNode(15, null, node17);
		node17.setParent(node15);
		TreeNode node10 = new TreeNode(10, node5, node15);
		node15.setParent(node10);
		node5.setParent(node10);
		TreeNode node30 = new TreeNode(30, null, null);
		TreeNode node20 = new TreeNode(6, node10, node30);
		node10.setParent(node20);
		node30.setParent(node20);
		return node20;
	}

}
