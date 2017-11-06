package cracking.the.code.interview.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cracking.the.code.interview.utilitiles.TreeNode;


/*
 * 
 * Create linked list of all nodes at each depth
 *
 */
public class Question4_3 {

	public static void main(String[] args) {
		List<List<TreeNode>> levelLists = new ArrayList<List<TreeNode>>();
		TreeNode root = createBinaryTree();
		createLevelLists(levelLists, 0, root);
		System.out.println(levelLists);
		
	}
	
	private static TreeNode createBinaryTree() {
		TreeNode node2 = new TreeNode(2, null, null);
		TreeNode node1 = new TreeNode(1, null, null);
		TreeNode node3 = new TreeNode(3, null, null );
		TreeNode node4 = new TreeNode(4, null, null );
		TreeNode node5 = new TreeNode(5, node1, node2);
		TreeNode node6 = new TreeNode(6, node3, node4);
		TreeNode node7 = new TreeNode(7, node5, node6);
		return node7;
	}

	/**
	 * Time complexity is O(n), because we need to traverse each node.
	 * @return list of all lists with nodes at each level
	 */
	public static void createLevelLists(List<List<TreeNode>> levelLists, int level, TreeNode root) {
		if(root == null) { // base case
			return;
		}
		
		/**
		 * if levelLists.get(level) == null could cause IndexOutOfBoundsException exception.
		 */
		if(levelLists.size() == level) {
			LinkedList<TreeNode> levelList = new LinkedList<TreeNode>();
			levelList.add(root);
			levelLists.add(level, levelList);
		} else {
			levelLists.get(level).add(root);
		}
		createLevelLists(levelLists, level + 1, root.getLeft());
		createLevelLists(levelLists, level + 1, root.getRight());
		return;
	}

}
