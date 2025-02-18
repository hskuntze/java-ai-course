package br.com.kuntzedevprojects.dfs;

import java.util.List;

public class DepthFirstSearchRecursion {
	public void dfs(List<Vertex> vertexList) {
		/**
		 * Podem existir clusters (grafos) independentes,
		 * e por esse motivo um método auxiliar pode ser
		 * interessante para considerar diferentes pontos iniciais.
		 */
		for(Vertex v : vertexList) {
			if(!v.isVisited()) {
				v.setVisited(true);
				dfsHelper(v);
			}
		}
	}

	private void dfsHelper(Vertex root) {
		System.out.println("Recursion - Actual vertex: " + root);
		
		for(Vertex v : root.getNeighbors()) {
			if(!v.isVisited()) {
				v.setVisited(true);
				dfsHelper(v);
			}
		}
	}
}