package a_star_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSearch {

	/**
	 * Nodo raíz
	 */
	private Node source;	
	
	/**
	 * Nodo destino
	 */
	private Node destination;
	
	/**
	 * Itens que já foram visitados
	 */
	private Set<Node> explored;
	private PriorityQueue<Node> queue;
	
	public AStarSearch(Node source, Node destination) {
		this.source = source;
		this.destination = destination;
		this.explored = new HashSet<Node>();
		this.queue = new PriorityQueue<Node>(new NodeComparator());
	}
	
	public void run() {
		queue.add(source);
		
		while(!queue.isEmpty()) {
			/**
			 * Retira o primeiro elemento da fila com o 
			 * menor valor de F graças ao NodeComparator.
			 */
			Node current = queue.poll();
			explored.add(current);
			
			/**
			 * Se chegou ao destino o loop para
			 */
			if(current == destination) {
				break;
			}
			
			/**
			 * Considera os vizinhos do nodo atual
			 */
			for(Edge edge : current.getNeighbors()) {
				Node child = edge.getTarget();
				double cost = edge.getWeight();
				
				/**
				 * É o valor G do nodo atual + o valor de peso da aresta
				 */
				double tempG = current.getG() + cost;
				double tempF = tempG + heuristic(current, destination);
				
				/**
				 * Se não tivermos considerado o nodo filho e o valor de f(x) for maior
				 */
				if(explored.contains(child) && tempF >= child.getF()) {
					continue;
				}
				
				/**
				 * Se não tivermos considerado OU o valor de f(x) é menor
				 */
				else if (!queue.contains(child) || tempF < child.getF()) {
					/**
					 * É dessa forma que conseguimos rastrear o menor caminho (predecessor)
					 */
					child.setParent(current);
					child.setG(tempG);
					child.setF(tempF);
					
					if(queue.contains(child)) {
						queue.remove(child);
					}
					
					queue.add(child);
				}
			}
		}
	}
	
	public void printSolutionPath() {
		List<Node> path = new ArrayList<Node>();
		
		for(Node node = destination; node != null; node = node.getParent()) {
			path.add(node);
		}
		
		Collections.reverse(path);
		
		System.out.println(path);
	}

	private double heuristic(Node node1, Node node2) {
		/**
		 * Distância Euclidiana
		 */
		double squareX = (node1.getX() - node2.getX()) * (node1.getX() - node2.getX());
		double squareY = (node1.getY() - node2.getY()) * (node1.getY() - node2.getY());
		
		return Math.sqrt(squareX + squareY);
	}
}