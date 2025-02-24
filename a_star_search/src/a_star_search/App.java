package a_star_search;

public class App {

	public static void main(String[] args) {
		Node n1 = new Node("A", 0, 0);
		Node n2 = new Node("B", 10, 20);
		Node n3 = new Node("C", 20, 40);
		Node n4 = new Node("D", 30, 10);
		Node n5 = new Node("E", 40, 30);
		Node n6 = new Node("F", 50, 10);
		Node n7 = new Node("G", 50, 40);
		
		n1.addNeighbor(new Edge(n2, 10));
		n1.addNeighbor(new Edge(n4, 50));
		
		n2.addNeighbor(new Edge(n3, 10));
		n2.addNeighbor(new Edge(n4, 20));
		
		n3.addNeighbor(new Edge(n5, 10));
		n3.addNeighbor(new Edge(n7, 30));
		
		n4.addNeighbor(new Edge(n6, 80));
		
		n5.addNeighbor(new Edge(n6, 50));
		n5.addNeighbor(new Edge(n7, 10));
		
		n7.addNeighbor(new Edge(n6, 10));
		
		AStarSearch search = new AStarSearch(n1, n6);
		search.run();
		search.printSolutionPath();
	}
}