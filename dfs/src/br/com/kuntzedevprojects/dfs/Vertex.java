package br.com.kuntzedevprojects.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private String name;
	private boolean visited;
	private List<Vertex> neighbors;
	
	public Vertex(String name) {
		this.name = name;
		this.neighbors = new ArrayList<Vertex>();
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Vertex adjacent) {
		this.neighbors.add(adjacent);
	}

	@Override
	public String toString() {
		return this.name;
	}
}