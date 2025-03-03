package br.com.kuntzedevprojects.bfs;

public class App {
	public static void main(String[] args) {
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		
		c.addNeighbor(d);
		c.addNeighbor(e);
		c.addNeighbor(b);
		
		e.addNeighbor(d);
		e.addNeighbor(h);
		
		h.addNeighbor(f);
		h.addNeighbor(e);
		h.addNeighbor(g);
		
		f.addNeighbor(d);
		
		d.addNeighbor(a);
		d.addNeighbor(h);
		
		a.addNeighbor(b);
		a.addNeighbor(g);
		
		g.addNeighbor(f);
		
		bfs.traverse(c);
	}
}