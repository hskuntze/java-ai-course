package simulated_annealing;

/**
 * Neste exemplo de algoritmo vamos considerar um intervalo
 * entre -2 e 2 no plano cartesiano.
 */
public class Constants {
	public static final double MIN_COORDINATE_X = -2;
	public static final double MAX_COORDINATE_X = 2;
	
	/**
	 * Controla quais estados considerar e aceitar
	 */
	public static final double MIN_TEMPERATURE = 1;
	public static final double MAX_TEMPERATURE = 100;
	
	
	/**
	 * Quando o cooling rate é grande então poucos estados 
	 * são considerados dentro do espaço de pesquisa
	 */
	public static final double COOLING_RATE = 0.02;
	
	private Constants() {
	}
}
