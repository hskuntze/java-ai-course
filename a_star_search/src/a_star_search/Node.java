package a_star_search;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name;
	
	/**
	 * Coordenadas do nodo em uma dimensão bidimensional
	 */
	private double x;
	private double y;
	
	/**
	 * Parâmetros para o algoritmo A*, onde:
	 * 
	 * G -> custo para mover do ponto inicial até um dado estado X
	 * H -> custo aproximado calculado pela função heurística, de um ponto X até o destino
	 * F -> a soma dos resultados das funções de G e H
	 */
	private double g;
	private double h;
	private double f;
	
	/**
	 * Lista de nodos adjacentes (vizinhos)
	 */
	private List<Edge> neighbors;
	
	/**
	 * Nodo anterior de caminho mais curto
	 */
	private Node parent;

	public Node(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.neighbors = new ArrayList<Edge>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Edge> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Edge n) {
		this.neighbors.add(n);
	}

	@Override
	public String toString() {
		return  name;
	}
	
}
