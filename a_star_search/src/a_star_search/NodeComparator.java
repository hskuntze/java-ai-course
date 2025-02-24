package a_star_search;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
	/**
	 * É nesta classe que o algoritmo de A* começa a fazer sentido.
	 * A base de comparação será o valor de custo f(x) = g(x) + h(x),
	 * ou seja, o algoritmo, a cada iteração, compara os valores mais
	 * apropriados (menor custo).
	 */
	
	@Override
	public int compare(Node o1, Node o2) {
		return Double.compare(o1.getF(), o2.getF());
	}
}