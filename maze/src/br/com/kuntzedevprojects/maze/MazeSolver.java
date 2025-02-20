package br.com.kuntzedevprojects.maze;

public class MazeSolver {

	private int[][] maze;
	private boolean[][] visited;
	private int startRow;
	private int startCol;
	
	public MazeSolver(int[][] maze, int startRow, int startCol) {
		this.maze = maze;
		this.visited = new boolean[maze.length][maze.length];
		this.startRow = startRow;
		this.startCol = startCol;
	}
	
	public void findWay() {
		if(dfs(startRow, startCol)) {
			System.out.println("Solution exists!");
		} else {
			System.out.println("No possible solution");
		}
	}
	
	/**
	 * Verifica se determinado estado pode ser considerado
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isPossible(int x, int y) {
		/**
		 * Verifica a dimensão vertical
		 */
		if(x < 0 || x > maze.length - 1) {
			return false;
		}
		
		/**
		 * Verifica a dimensão horizontal
		 */
		if(y < 0 || y > maze.length - 1) {
			return false;
		}
		
		/**
		 * Verifica se esse estado já foi considerado
		 */
		if(visited[x][y]) {
			return false;
		}
		
		/**
		 * 1 = Obstáculo
		 */
		if(maze[x][y] == 1) {
			return false;
		}
		
		return true;
	}

	private boolean dfs(int x, int y) {
		
		/**
		 * Verifica se as posições estão na última coluna e linha,
		 * ou seja, dentro dos limites do labirinto.
		 */
		if(x == maze.length - 1 && y == maze.length - 1) {
			return true;
		}
		
		if(isPossible(x, y)) {
			visited[x][y] = true;
			
			/**
			 * Vai para "baixo"
			 */
			if(dfs(x + 1, y)) {
				return true;
			}
			
			/**
			 * Vai para "cima"
			 */
			if(dfs(x - 1, y)) {
				return true;
			}
			
			/**
			 * Vai para "direita"
			 */
			if(dfs(x, y + 1)) {
				return true;
			}
			
			/**
			 * Vai para "esquerda"
			 */
			if(dfs(x, y - 1)) {
				return true;
			}
		}
		
		return false;
	}
}
