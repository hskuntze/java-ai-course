package hill_climbing;

public class App {

	public static void main(String[] agrs) {
		/**
		 * Intervalo de pesquisa
		 */
		double dx = 0.01;
		double actualX = -5;
		
		double maxX = actualX;
		
		while(f(actualX + dx) >= f(maxX)) {
			maxX = actualX + dx;
			System.out.println("x: " + actualX + ", f(x): " + f(actualX));
			actualX += dx;
		}
		
		System.out.println("Max w/ hill climbing -> x = " + maxX + ", f(x): " + f(maxX));
	}
	
	/**
	 * A função de custo pode variar de acordo 
	 * com o contexto da aplicação. Aqui será um
	 * plano não convexo.
	 * 
	 * @param x
	 * @return
	 */
	public static double f(double x) {
		return -0.09 * Math.pow(x - 0.1, 4) + 3 * Math.pow(x - 0.4, 2) + 12;
	}
}
