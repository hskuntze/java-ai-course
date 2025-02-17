package br.com.kuntzedevprojects.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public void traverse(Vertex root) {
		/**
		 * Queue é a classe abstrata (comportamento)
		 * LinkedList é a implementação concreta (implementação do comportamento)
		 */
		Queue<Vertex> queue = new LinkedList<Vertex>();
		
		root.setVisited(true);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Vertex actual = queue.remove(); //Remove o item e retorna ele
			
			System.out.println("Actual visited Vertex: " + actual);
			
			for(Vertex v : actual.getNeighbors()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
	}
}