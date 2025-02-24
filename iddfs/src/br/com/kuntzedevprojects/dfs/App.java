package br.com.kuntzedevprojects.dfs;

public class App {
	public static void main(String[] args) {
		Node n0 = new Node("A");
		Node n1 = new Node("B");
		Node n2 = new Node("C");
		Node n3 = new Node("D");
		Node n4 = new Node("E");
		Node n23 = new Node("Z");
		
		n0.addNeighbor(n1);
		n0.addNeighbor(n2);
		n1.addNeighbor(n3);
		n3.addNeighbor(n4);
		
		/**
		 * Define o alvo no construtor
		 */
		IDDFS iddfs = new IDDFS(n0);
		
		/**
		 * Exemplo de um nodo que não está
		 * relacionado na árvore
		 */
//		IDDFS iddfs2 = new IDDFS(n23);
		
		/**
		 * Define o nodo raíz
		 */
		iddfs.run(n0);
	}
}