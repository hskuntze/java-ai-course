package br.com.kuntzedevprojects.dfs;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

	private Stack<Vertex> stack;
	
	public DepthFirstSearch() {
		this.stack = new Stack<>();
	}
	
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
		/**
		 * Estrutura LIFO
		 */
		stack.add(root);
		root.setVisited(true);
		
		while(!stack.isEmpty()) {
			Vertex actual = stack.pop();
			System.out.println("Actual vertex: " + actual);

			/**
			 * Verifica os vizinhos do nodo atual
			 */
			for(Vertex v : actual.getNeighbors()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					stack.add(v);
				}
			}
		}
	}
}