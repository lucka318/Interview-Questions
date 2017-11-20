package cracking.the.code.interview.trees_and_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Question4_7 {

	public static void main(String[] args) {

		String[] projects = new String[] { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = new String[][] { { "d", "a" }, { "b", "f" },
				{ "d", "b" }, { "a", "f" }, { "c", "d" } };

		Project[] order = createBuildOrder(projects, dependencies);

		if (order != null) {
			for (Project p : order) {
				System.out.println(p.getName() + " ");
			}
		}

	}

	public static Project[] createBuildOrder(String[] projects,
			String[][] dependencies) {
		/**
		 * Build a graph so that parent has references to children and child has
		 * a number of parents.
		 */
		Graph graph = buildGraph(projects, dependencies);

		/**
		 * We have to use array because it is more convenient with this
		 * algorithm. If we used list, we would have to swap elements adn that
		 * would require removing plus adding elements to list at an index which
		 * would result in O(n) time complexity.
		 * 
		 * Time complexity of this algorithm is O(n^2 + E) we could reduce time
		 * complexity if we used iterator in addNonDependantProjects and remove
		 * added project, but the big O would stay the same
		 */
		Project[] order = new Project[projects.length];

		List<Project> projectList = new ArrayList<Project>(graph.getProjects()
				.values());

		int endOfArray = addNonDependantProjects(order, projectList, 0);
		int nodesProcessed = 0;
		while (nodesProcessed < order.length) { // we loop through this exactly
												// n times
			Project current = order[nodesProcessed];

			if (current == null) {
				return null;
			}

			/**
			 * num of project * num of child depen. = num of edges in graph E
			 */
			for (Project child : current.getDependencies()) {
				child.decreaseNumberOfDependencies();
			}

			current.setProcessed();
			endOfArray++;

			endOfArray = addNonDependantProjects(order, projectList, endOfArray); // n^2
			nodesProcessed++;
		}

		return order;
	}

	private static int addNonDependantProjects(Project[] order,
			List<Project> projectList, int endOfArray) {
		for (Project project : projectList) {
			if (project.getNumOfDenendencies() == 0 && !project.isProcessed()) {
				order[endOfArray] = project;
			}

		}
		return endOfArray;
	}

	/**
	 * time complexity N^2*e = N*E
	 * 
	 * @param projects
	 * @param dependencies
	 * @return
	 */
	public static List<String> createBuildOrder2(String[] projects,
			String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);

		List<String> order = new ArrayList<String>();

		List<Project> projectList = new ArrayList<Project>(graph.getProjects()
				.values());

		while (!projectList.isEmpty()) { // it will pass through all n projects
											// in worst case
			int size = projectList.size();
			Iterator<Project> projectIterator = projectList.iterator();
			while (projectIterator.hasNext()) { // it will explore remaining
												// nodes
				Project project = projectIterator.next();
				if (project.getNumOfDenendencies() == 0) {
					order.add(project.getName());
					for (Project child : project.getDependencies()) { // for
																		// each
																		// edge
						child.decreaseNumberOfDependencies();
					}
					projectIterator.remove();
				}
			}
			if (projectList.size() == size) {
				return null;
			}
		}

		return order;
	}

	private static Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		// add projects
		for (String name : projects) {
			Project project = new Project(name);
			graph.addProject(project);
		}

		// add edges
		for (String[] dependency : dependencies) {
			Project child = graph.getProject(dependency[0]);
			Project parent = graph.getProject(dependency[1]);
			child.increaseNumberOfDependencies();
			parent.addDependency(child);
		}

		return graph;
	}
}

class Project {

	private String name;
	private List<Project> dependencies = new ArrayList<Project>();
	private int numOfDependencies = 0;
	private boolean processed;

	public Project(String name) {
		this.name = name;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed() {
		this.processed = true;
	}

	public void addDependency(Project project) {
		dependencies.add(project);
	}

	public void increaseNumberOfDependencies() {
		numOfDependencies++;
	}

	public void decreaseNumberOfDependencies() {
		numOfDependencies--;
	}

	public String getName() {
		return name;
	}

	public int getNumOfDenendencies() {
		return numOfDependencies;
	}

	public List<Project> getDependencies() {
		return dependencies;
	}

	@Override
	public String toString() {
		return name + " ";
	}
}

class Graph {

	private Map<String, Project> projects = new HashMap<String, Project>();

	public Graph() {
	}

	public void addProject(Project project) {
		if (!projects.containsKey(project.getName())) {
			projects.put(project.getName(), project);
		}
	}

	public Project getProject(String name) {
		return projects.get(name);
	}

	public Map<String, Project> getProjects() {
		return projects;
	}
}
