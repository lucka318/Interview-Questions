package cracking.the.code.interview.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question4_7 {

	public static void main(String[] args) {

		String[] projects = new String[] { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = new String[][] { { "d", "a" }, { "b", "f" },
				{ "d", "b" }, { "a", "f" }, { "c", "d" } };

		List<String> order = createBuildOrder(projects, dependencies);

	}

	private static List<String> createBuildOrder(String[] projects,
			String[][] dependencies) {

		Graph graph = createGraph(projects, dependencies);

		List<String> buildOrder = new ArrayList<String>();

		Map<String, Project> graphProjects = graph.getProjectMap();

		while (buildOrder.size() < graphProjects.size()) {
			for (Map.Entry<String, Project> entry : graphProjects.entrySet()) {

				if (entry.getValue().getDependencies() == 0) {
					buildOrder.add(entry.getKey());
				}

			}
		}

		return null;
	}

	public static Graph createGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String name : projects) {
			graph.createNode(name);
		}

		for (String[] dependency : dependencies) {
			String parent = dependency[0];
			String child = dependency[1];
			graph.createEdge(parent, child);
		}

		return graph;
	}

}

class Graph {
	/*
	 * Why using an extra list when we can return map.getValues() ???
	 */
	// List<Project> projects = new ArrayList<Project>();
	private Map<String, Project> projects = new HashMap<String, Project>();

	public void createNode(String name) {
		Project project = new Project(name);
		if (!projects.containsKey(name))
			projects.put(name, project);
	}

	public void createEdge(String parent, String child) {
		Project par = projects.get(parent);
		Project chi = projects.get(child);

		par.addChild(chi);
		par.setDependencies();

	}

	public List<Project> getProjectValues() {
		return new ArrayList<>(projects.values());
	}

	public Map<String, Project> getProjectMap() {
		return projects;
	}
}

class Project {

	private String name = "";
	private Map<String, Project> children = new HashMap<String, Project>();
	private int dependencies = 0;

	public Project(String name) {
		this.name = name;
	}

	public void addChild(Project child) {
		if (!children.containsKey(child.name)) {
			children.put(child.name, child);
		}
		return;

	}

	public String getName() {
		return name;
	}

	public Map<String, Project> getChildren() {
		return children;
	}

	public List<Project> getChildrenList() {
		return new ArrayList<>(children.values());
	}

	public int getDependencies() {
		return dependencies;
	}

	public int setDependencies() {
		return dependencies++;
	}
}
