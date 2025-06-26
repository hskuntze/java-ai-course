package br.com.kuntzedevprojects.pso;

public class Constants {

	private Constants() {}

	public final static int NUM_DIMENSIONS = 3; // 3 ativos
	public final static int NUM_PARTICLES = 30;
	public final static double MIN = 0; // Sem venda a descoberto
	public final static double MAX = 1; // Máximo 100% em um ativo

	public static final double w = 0.7298;
	public static final double c1 = 1.7;
	public static final double c2 = 1.7;
	public static final int MAX_ITERATIONS = 1000;

	// Retorno esperado de cada ativo
	public static final double[] EXPECTED_RETURNS = { 0.12, 0.18, 0.10 };

	// Matriz de covariância (simples)
	public static final double[][] COVARIANCE_MATRIX = {
		{ 0.10, 0.02, 0.04 },
		{ 0.02, 0.08, 0.01 },
		{ 0.04, 0.01, 0.07 }
	};

	public static final double RISK_FREE_RATE = 0.03;

	// Retorna o índice de Sharpe do portfólio representado por um vetor de pesos
	public static double f(double[] weights) {
		double expectedReturn = 0;
		for (int i = 0; i < NUM_DIMENSIONS; i++) {
			expectedReturn += weights[i] * EXPECTED_RETURNS[i];
		}

		double variance = 0;
		for (int i = 0; i < NUM_DIMENSIONS; i++) {
			for (int j = 0; j < NUM_DIMENSIONS; j++) {
				variance += weights[i] * weights[j] * COVARIANCE_MATRIX[i][j];
			}
		}
		double stdDev = Math.sqrt(variance);

		// Evita divisão por zero
		if (stdDev == 0) return -Double.MAX_VALUE;

		// Maximizar Sharpe Ratio
		return (expectedReturn - RISK_FREE_RATE) / stdDev;
	}
}
