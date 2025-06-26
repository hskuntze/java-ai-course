package tictactoe;

public class Cell {

	private int x; //row
	private int y; //column
	private int minimaxValue; //+1, 0 ou -1
	
	public Cell() {
	}

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMinimaxValue() {
		return minimaxValue;
	}

	public void setMinimaxValue(int minimaxValue) {
		this.minimaxValue = minimaxValue;
	}

	@Override
	public String toString() {
		return "X: " + this.x + ", Y: " + this.y;
	}
}
