package br.com.kuntzedevprojects.dfs;

import java.util.ArrayList;
import java.util.List;

public class AppRecursion {
	public static void main(String[] args) {
		DepthFirstSearchRecursion dfs = new DepthFirstSearchRecursion();
		
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		
		List<Vertex> list = new ArrayList<Vertex>();
		
		a.addNeighbor(g);
		a.addNeighbor(f);
		a.addNeighbor(b);
		
		b.addNeighbor(c);
		b.addNeighbor(d);
		
		d.addNeighbor(e);
		
		g.addNeighbor(h);
		
		list.add(a);
		
		dfs.dfs(list);
	}
}