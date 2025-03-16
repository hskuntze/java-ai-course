package genetic_algorithm;

public class Constants {
	
	public static final int[] SOLUTION_SEQUENCE = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	/**
	 * Geralmente o valor de cruzamento é maior que o valor de mutação,
	 * ou seja, o cruzamento acontecerá com mais frequência que a mutação.
	 */
	public static final double CROSSOVER_RATE = 0.05;
	public static final double MUTATION_RATE = 0.015;
	public static final int TOURNAMENT_SIZE  = 5;
	
	/**
	 * A "aptidão máxima" seria igual ao número de valores presentes na sequência,
	 * que neste caso são 10. Isso será necessário para que no futuro seja possível
	 * determinar QUANTOS dos elementos da sequência de solução dada pelo algoritmo
	 * são iguais ao elementos da sequência de solução determinada.
	 */
	public static final int MAX_FITNESS = 10;
	public static final int CHROMOSOME_LENGTH = 10;

	private Constants() {
	}
}
