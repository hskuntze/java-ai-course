package br.com.kuntzedevprojects.dfs;

import java.util.Stack;

public class IDDFS {

	/**
	 * Elemento pelo o qual estamos procurando
	 */
	private Node target;
	
	/**
	 * Para rastrear se o nodo já foi encontrado.
	 * Usado como medida de impedir o algoritmo de seguir indefinidamente.
	 */
	private boolean isTargetFound;
	
	private int maxLength;
	
	public IDDFS(Node target) {
		this.target = target;
	}
	
	public void run(Node root) {
		int depth = 0;
		
		while(!isTargetFound) {
				
			if(depth > maxLength) {
				System.out.println("Node is not found...");
				break;
			}
			
			System.out.println();
			dfs(root, depth);
			depth++;
		}
	}

	private void dfs(Node root, int depthLevel) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node actual = stack.pop();
			System.out.println(actual);
			
			/**
			 * Verifica se o nodo foi encontrado
			 */
			if(actual.getName().equals(target.getName())) {
				System.out.println("Node has been found...");
				isTargetFound = true;
				return;
			}
			
			if(actual.getNeighbors() != null) {
				maxLength = actual.getDepthLevel() + 1;
			}
			
			/**
			 * Aqui é que o IDDFS entra. Isso garante que o
			 * algoritmo não visite os vizinhos do nodo atual,
			 * visitando apenas os nodos do mesmo nível!
			 */
			if(actual.getDepthLevel() >= depthLevel) {
				continue;
			}
			
			/**
			 * E aqui está o DFS padrão
			 */
			for(Node n : actual.getNeighbors()) {
				n.setDepthLevel(actual.getDepthLevel() + 1);
				stack.push(n);
			}
		}
	}
}
