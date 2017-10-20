package cracking.the.code.interview.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cracking.the.code.interview.utilitiles.Graph;
import cracking.the.code.interview.utilitiles.GraphNode;

public class Question4_1 {

	public static void main(String[] args) {
		
		// mock data
		GraphNode node2 = new GraphNode(2, null);
		GraphNode node7 = new GraphNode(7, null);
		GraphNode node6 = new GraphNode(6, new GraphNode[] { node7 });
		GraphNode node5 = new GraphNode(5, new GraphNode[] { node6 });
		GraphNode node4 = new GraphNode(4, new GraphNode[] { node5, node7 });
		GraphNode node3 = new GraphNode(3, new GraphNode[] { node4 });
		GraphNode node1 = new GraphNode(1, new GraphNode[] { node2, node3 });
		Graph graph = new Graph(new GraphNode[] { node1 });
		
		List<GraphNode> route = routeBetweenNodes(graph, node2, node7);
		if (route == null) {
			System.out.println("No route between nodes.");
		} else {
			for (GraphNode node : route) {
				System.out.println(node.getValue());
			}
		}

	}

	/**
	 * Nodes are compared based on their integer values. The assumption is that
	 * there are no duplicated values. If there were, maybe we could compare
	 * nodes based on their address.
	 * BFS version
	 * 
	 * @param graph
	 * @param nodeOne
	 * @param nodeTwo
	 * @return
	 */
	public static List<GraphNode> routeBetweenNodes(Graph graph, GraphNode nodeOne, GraphNode nodeTwo) {
		if (nodeOne.getValue() == nodeTwo.getValue()) { // base case - passed
														// nodes are the same
			return new ArrayList<>(); // return empty list (we could also return
										// list with one element)
		}
		List<GraphNode> route = new ArrayList<GraphNode>();

		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(nodeOne);
		while (!queue.isEmpty()) {
			GraphNode explore = queue.poll(); // is there a need to check for
												// null values? yes if we expect null values in queue, otherwise no, because we are checking if the queue is empty.
			route.add(explore);
			if (explore.getValue() == nodeTwo.getValue()) {
				return route;
			} else if (explore.getNeighbours() != null) {
				for (GraphNode n : explore.getNeighbours()) {
					queue.add(n);
				}
			}

		}
		return null; // if there is no path, return null, make a new empty list.
		// we could also only use boolean variable to mark if there is a path or
		// not, but wit list we can track the route
	}
}
