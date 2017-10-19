package cracking.the.code.interview.utilitiles;

public class GraphNode {
	
	private int value;
	private GraphNode[] neighbours;
	
	public GraphNode(int value, GraphNode[] neighbours) {
		this.value = value;
		this.neighbours = neighbours;
	}

	public int getValue() {
		return value;
	}

	public GraphNode[] getNeighbours() {
		return neighbours;
	}
	

}
