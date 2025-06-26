package br.com.kuntzedevprojects.pso;

public class Constants {

	private Constants() {
	}
	
	/**
	 * Número de dimensões
	 */
	public final static int NUM_DIMENSIONS = 2;
	
	/**
	 * Número de partículas
	 */
	public final static int NUM_PARTICLES = 20;
	
	/**
	 * Os "ranges" de busca
	 */
	public final static double MIN = -2;
	public final static double MAX = 2;
	
	/**
	 * Definido de forma randômica
	 */
	public final static double w = 0.729;
	
	/**
	 * Os pesos local e global geralmente são os mesmos
	 */
	public final static double c1 = 1.49;
	public final static double c2 = 1.49;

	public static final int MAX_ITERATIONS = 10000;
	
	/**
	 * Essa será a função que pretendemos otimizar.
	 * 
	 * Poderia ser qualquer outra função.
	 * @param data
	 * @return
	 */
	public final static double f(double[] data) {
		return Math.exp(-data[0]*data[0]-data[1]*data[1]) * Math.sin(data[0]);
	}
}