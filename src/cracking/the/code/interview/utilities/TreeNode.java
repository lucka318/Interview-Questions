package cracking.the.code.interview.utilities;

public class TreeNode {
	
	private int value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
	
}
