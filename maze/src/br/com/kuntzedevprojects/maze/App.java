package br.com.kuntzedevprojects.maze;

public class App {

	public static void main(String[] args) {
		int[][] matrix = {
			{1,1,1,1,1,1},
			{2,1,0,0,0,1},
			{0,1,0,1,0,1},
			{0,1,0,1,0,1},
			{0,1,0,1,0,0},
			{0,1,0,1,1,0},
			{0,0,0,1,0,0},
		};
		
		MazeSolver mazeSolver = new MazeSolver(matrix, 1, 0);
		mazeSolver.findWay();
	}
}
