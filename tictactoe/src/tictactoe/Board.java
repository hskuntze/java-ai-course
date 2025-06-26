package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {

	private List<Cell> emptyCells;
	private Scanner scanner;
	private CellState[][] board;
	private List<Cell> rootValues;
	
	public Board() {
		initializeBoard();
	}

	private void initializeBoard() {
		this.rootValues = new ArrayList<Cell>();
		this.scanner = new Scanner(System.in);
		this.board = new CellState[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
	}
	
	public boolean isRunning() {
		if(isWinning(CellState.COMPUTER)) return false;
		if(isWinning(CellState.USER)) return false;
		if(getEmptyCells().isEmpty()) return false;
		
		return true;
	}

	public boolean isWinning(CellState player) {
		//Diagonal
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		
		//Diagonal
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		
		//Verifica as linhas e colunas
		for(int i = 0; i < Constants.BOARD_SIZE; ++i) {
			if(board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			}
			
			if(board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			}
		}
		
		return false;
	}

	private List<Cell> getEmptyCells() {
		emptyCells = new ArrayList<>();
		
		for(int i = 0; i < Constants.BOARD_SIZE; ++i) {
			for(int j = 0; j < Constants.BOARD_SIZE; ++j) {
				if(this.board[i][j] == CellState.EMPTY) {
					emptyCells.add(new Cell(i,j));
				}
			}
		}
		
		return emptyCells;
	}

	public void move(Cell cell, CellState player) {
		this.board[cell.getX()][cell.getY()] = player;
	}

	public void displayBoard() {
		System.out.println();
		
		for(int i = 0; i < Constants.BOARD_SIZE; ++i) {
			for(int j = 0; j < Constants.BOARD_SIZE; ++j) {
				System.out.print(this.board[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	public Cell getBestMove() {
		int max = Integer.MIN_VALUE;
		int best = Integer.MIN_VALUE;
		
		for(int i = 0; i < rootValues.size(); ++i) {
			if(max < rootValues.get(i).getMinimaxValue()) {
				max = rootValues.get(i).getMinimaxValue();
				best = i;
			}
		}
		
		return rootValues.get(best);
	}
	
	public void makeUserInput() {
		System.out.println("User's move: ");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		Cell cell = new Cell(x, y);
		
		move(cell, CellState.USER);
	}
	
	public void setupBoard() {
		for(int i = 0; i < Constants.BOARD_SIZE; ++i) {
			for(int j = 0; j < Constants.BOARD_SIZE; ++j) {
				board[i][j] = CellState.EMPTY;
			}
		}
	}
	
	/**
	 * Encontra o menor valor dentro de uma lista (Parte "max" do algoritmo minimax)
	 */
	public int returnMin(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		int index = Integer.MIN_VALUE;
		
		for(int i = 0; i < list.size(); ++i) {
			if(list.get(i) < min) {
				min = list.get(i);
				index = i;
			}
		}
		
		return list.get(index);
	}
	
	/**
	 * Encontra o maior valor dentro de uma lista (Parte "max" do algoritmo minimax)
	 */
	public int returnMax(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		int index = Integer.MIN_VALUE;
		
		for(int i = 0; i < list.size(); ++i) {
			if(list.get(i) > max) {
				max = list.get(i);
				index = i;
			}
		}
		
		return list.get(index);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public List<Cell> getRootValues() {
		return rootValues;
	}

	public void setRootValues(List<Cell> rootValues) {
		this.rootValues = rootValues;
	}

	public void setEmptyCells(List<Cell> emptyCells) {
		this.emptyCells = emptyCells;
	}

	public void callMinimax(int depth, CellState player) {
		rootValues.clear();
		
		minimax(depth, player);
	}

	private int minimax(int depth, CellState player) {
		/**
		 * Casos base: (são os nodos-folha da árvore de jogo)
		 * 
		 * if(isWinning(CellState.COMPUTER)) return 1;
		 * if(isWinning(CellState.USER)) return -1;
		 * if(availableCells.isEmpty()) return 0;
		 * 
		 */
		if(isWinning(CellState.COMPUTER)) return 1;
		if(isWinning(CellState.USER)) return -1;
		
		List<Cell> availableCells = getEmptyCells();
		
		if(availableCells.isEmpty()) return 0;
		
		/**
		 * É a pontuação do minimax em uma dada linha da árvore (row) que pertença a um mesmo parente
		 */
		List<Integer> scores = new ArrayList<Integer>();
		
		for(int i = 0; i < availableCells.size(); i++) {
			Cell point = availableCells.get(i);
			
			/**
			 * A rodada do computador seleciona a maior pontuação da chamada da função minimax()
			 */
			if(player == CellState.COMPUTER) {
				move(point, CellState.COMPUTER);
				int currentScore = minimax(depth + 1, CellState.USER);
				scores.add(currentScore);
				
				/**
				 * Esse é o nodo raíz da árvore de jogo: estamos atrás desse valor
				 * +1 -> significa que o computador fará esse movimento (e pode vencer)
				 * -1 -> o computador deve evitar realizar esse movimento (situação de perda)
				 */
				if(depth == 0) {
					point.setMinimaxValue(currentScore);
					rootValues.add(point);
				}
			} else if(player == CellState.USER) { //A rodada do jogador seleciona a menor pontuação da chamada da função minimax()
				move(point, CellState.USER);
				scores.add(minimax(depth + 1, CellState.COMPUTER));
			}
			
			/**
			 * O algoritmo "joga" o jogo (realiza os movimentos e preenche as células) e
			 * portanto o tabuleiro deve ser resetado para não ter nada preenchido, 
			 * para que o jogador possa realizar os movimentos.
			 */
			board[point.getX()][point.getY()] = CellState.EMPTY;
		}
		
		
		/**
		 * Esses são os valores de retorno quando lidamos com os nodos internos da árvore de jogo.
		 * Temos que encontrar o valor MÁXIMO para a rodada do computador, e o valor MÍNIMO para a rodada do jogador.
		 */
		if(player == CellState.COMPUTER) {
			return returnMax(scores);
		}
		
		return returnMin(scores);
	}
}
