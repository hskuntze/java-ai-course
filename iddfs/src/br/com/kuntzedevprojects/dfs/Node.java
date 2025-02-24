package br.com.kuntzedevprojects.dfs;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String name;
	private int depthLevel;
	private boolean visited;
	private List<Node> neighbors;
	
	public Node(String name) {
		this.name = name;
		this.neighbors = new ArrayList<Node>();
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Node adjacent) {
		this.neighbors.add(adjacent);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepthLevel() {
		return depthLevel;
	}

	public void setDepthLevel(int depthLevel) {
		this.depthLevel = depthLevel;
	}

	@Override
	public String toString() {
		return name;
	}
}