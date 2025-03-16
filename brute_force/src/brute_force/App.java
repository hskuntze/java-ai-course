package brute_force;

public class App {

	public static void main(String[] agrs) {
		
		/**
		 * Definindo um intervalo de -2 a 2, que varia de acordo
		 * com o contexto da aplicação
		 */
		double startX = -2;
		double endX = 2;
		
		/**
		 * O máximo varia de acordo com o contexto da aplicação
		 */
		double max = f(startX);
		
		/**
		 * O espaço de pesquisa precisa ser dividido
		 * em intervalos "dx" razoavelmente pequenos
		 * para que a busca faça sentido.
		 * 
		 * Como o Brute Force avalia todo estado possível
		 * dentro do intervalo determinado, e isso é muito custoso,
		 * esse espaço de pesquisa é divido para que esse 
		 * custo diminua.
		 * 
		 * Aqui o "dx" é o valor 0.1.
		 * 
		 * Ou seja, o que vai ocorrer é que partirá de -2 (startX)
		 * percorrendo -1.9, -1.8, -1.7 ... 1.7, 1.8, 1.9 e 2 (endX).
		 */
		for(double i = startX; i < endX; i += 0.1) {
			if(f(i) > max) {
				max = f(i);
			}
		}
		
		System.out.println("Max: " + max);
	}
	
	/**
	 * A função de custo pode variar de acordo 
	 * com o contexto da aplicação
	 * 
	 * @param x
	 * @return
	 */
	public static double f(double x) {
		return -(x*x);
	}
}
