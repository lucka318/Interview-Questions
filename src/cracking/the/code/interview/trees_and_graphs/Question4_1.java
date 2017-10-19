package cracking.the.code.interview.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

import cracking.the.code.interview.utilitiles.Graph;
import cracking.the.code.interview.utilitiles.GraphNode;

public class Question4_1 {

	public static void main(String[] args) {
		Graph graph = mockGraph();
		List<GraphNode> route = routeBetweenNodes(graph, null, null); // add proper nodes!

		for (GraphNode node : route) {
			System.out.println(node.getValue());
		}
	}

	/**
	 * Nodes are compared based on their integer values. The assumption is that
	 * there are no duplicated values. If there were, maybe we could compare
	 * nodes based on their address.
	 * 
	 * @param graph
	 * @param nodeOne
	 * @param nodeTwo
	 * @return
	 */
	public static List<GraphNode> routeBetweenNodes(Graph graph,
			GraphNode nodeOne, GraphNode nodeTwo) {
		List<GraphNode> route = new ArrayList<GraphNode>();

		return null;
	}

	public static Graph mockGraph() {
		GraphNode node2 = new GraphNode(2, null);
		GraphNode node7 = new GraphNode(7, null);
		GraphNode node6 = new GraphNode(6, new GraphNode[] { node7 });
		GraphNode node5 = new GraphNode(5, new GraphNode[] { node6 });
		GraphNode node4 = new GraphNode(4, new GraphNode[] { node5, node7 });
		GraphNode node3 = new GraphNode(3, new GraphNode[] { node4 });
		GraphNode node1 = new GraphNode(1, new GraphNode[] { node2, node3 });
		Graph graph = new Graph(new GraphNode[] { node1 });
		return graph;
	}
}
