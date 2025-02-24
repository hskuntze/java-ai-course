package a_star_search;

public class Edge {

	/**
	 * Valor referente ao "peso" para atravessar
	 * esta aresta. O peso pode representar a 
	 * dificuldade ou a distância para percorrer
	 * esta aresta.
	 */
	private double weight;
	
	/**
	 * Toda aresta leva até algum ponto (nodo), 
	 * e aqui está representada pela variável "target".
	 */
	private Node target;
	
	public Edge(Node target, double weight) {
		this.target = target;
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public Node getTarget() {
		return target;
	}
}
