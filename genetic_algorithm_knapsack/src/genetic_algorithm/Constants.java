package genetic_algorithm;

public class Constants {
	
	/**
	 * Geralmente o valor de cruzamento é maior que o valor de mutação,
	 * ou seja, o cruzamento acontecerá com mais frequência que a mutação.
	 */
	public static final double CROSSOVER_RATE = 0.05;
	public static final double MUTATION_RATE = 0.015;
	public static final int TOURNAMENT_SIZE  = 5;
	
	/**
	 * Capacidade máxima definida para a mochila (knapsack)
	 */
	public static final int KNAPSACK_CAPACITY = 10;

	private Constants() {
	}
}
