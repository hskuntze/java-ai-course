package br.com.kuntzedevprojects.dfs;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		DepthFirstSearch dfs = new DepthFirstSearch();
		
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		
		List<Vertex> list = new ArrayList<Vertex>();
		
		a.addNeighbor(b);
		a.addNeighbor(f);
		a.addNeighbor(g);
		
		b.addNeighbor(c);
		b.addNeighbor(d);
		
		d.addNeighbor(e);
		
		g.addNeighbor(h);
		
		list.add(a);
		
		dfs.dfs(list);
	}
}