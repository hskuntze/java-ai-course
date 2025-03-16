package simulated_annealing_tsp;

/**
 * No Travelling Salesman Problem os vértices são as cidades
 */
public class City {

	private int x;
	private int y;
	
	public City() {
		this.x = (int) (Math.random() * 100);
		this.y = (int) (Math.random() * 100);
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
	
	/**
	 * Usando a distância Euclidiana
	 * @param city
	 * @return
	 */
	public double distanceTo(City city) {
		int distX = Math.abs(getX() - city.getX());
		int distY = Math.abs(getY() - city.getY());
		
		return Math.sqrt((distX * distX) + (distY * distY));
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
}
