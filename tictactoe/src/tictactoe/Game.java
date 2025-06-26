package tictactoe;

import java.util.Random;

public class Game {

	private Board board;
	private Random random;
	
	public Game() {
		initializeGame();
		displayBoard();
		makeFirstMove();
		playGame();
		checkStatus();
	}

	private void initializeGame() {
		this.board = new Board();
		this.random = new Random();
		this.board.setupBoard();
	}

	private void displayBoard() {
		this.board.displayBoard();
	}

	private void makeFirstMove() {
		System.out.println("Who starts?");
		System.out.println("1 - Computer");
		System.out.println("2 - User");
		
		int choice = board.getScanner().nextInt();
		
		if(choice == 1) {
			Cell cell = new Cell(random.nextInt(Constants.BOARD_SIZE), random.nextInt(Constants.BOARD_SIZE));
		}
	}

	private void playGame() {
		while(board.isRunning()) {
			System.out.println("User move: ");
			Cell userCell = new Cell(board.getScanner().nextInt(), board.getScanner().nextInt());
			
			board.move(userCell, CellState.USER);
			board.displayBoard();
			
			if(!board.isRunning()) {
				break;
			}
			
			board.callMinimax(0, CellState.COMPUTER);
			
			for(Cell cell : board.getRootValues()) {
				System.out.println("Cell values: " + cell + ", minimaxValue: " + cell.getMinimaxValue());
			}
			
			board.move(board.getBestMove(), CellState.COMPUTER);
			board.displayBoard();
		}
	}

	private void checkStatus() {
		if(board.isWinning(CellState.COMPUTER)) {
			System.out.println("Computer wins!!!");
		} else if(board.isWinning(CellState.USER)) {
			System.out.println("User wins!!!");
		} else {
			System.out.println("Awww. It's a draw.");
		}
	}
}
