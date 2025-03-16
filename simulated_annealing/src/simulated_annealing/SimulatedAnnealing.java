package simulated_annealing;

import java.util.Random;

public class SimulatedAnnealing {

	private Random randomGenerator;
	/**
	 * Estado atual (estado = X)
	 */
	private double currentCoordinateX;
	private double nextCoordinateX;
	private double bestCoordinateX;

	public SimulatedAnnealing() {
		this.randomGenerator = new Random();
	}

	public void findOptimum() {
		double temperature = Constants.MAX_TEMPERATURE;

		while (temperature > Constants.MIN_TEMPERATURE) {
			/**
			 * Gera um estado vizinho randômico
			 */
			nextCoordinateX = getRandomX();
			
			/**
			 * Calcula o valor das energias
			 */
			double currentEnergy = getEnergy(currentCoordinateX);
			double newEnergy = getEnergy(nextCoordinateX);
			
			if(acceptanceProbability(currentEnergy, newEnergy, temperature) > Math.random()) {
				currentCoordinateX = nextCoordinateX;
			}
			
			if(f(currentCoordinateX) < f(bestCoordinateX)) {
				bestCoordinateX = currentCoordinateX;
			}

			temperature = temperature * (1 - Constants.COOLING_RATE);
		}
		
		System.out.println("Global extremum is: x = " + bestCoordinateX + ", f(x) = " +f(bestCoordinateX));
	}

	/**
	 * Retorna um valor double dentro do intervalo 
	 * definido nas constantes [-2, 2]
	 * 
	 * @return
	 */
	private double getRandomX() {
		return randomGenerator.nextDouble() * (Constants.MAX_COORDINATE_X - Constants.MIN_COORDINATE_X)
				+ Constants.MIN_COORDINATE_X;
	}

	/**
	 * Será utilizado para a função de Metrópolis
	 * 
	 * @param x
	 * @return
	 */
	private double getEnergy(double x) {
		return f(x);
	}

	/**
	 * Exemplo de função de custo que pode variar de acordo com o contexto da
	 * aplicação.
	 * 
	 * @param x
	 * @return
	 */
	private double f(double x) {
		double param = (x - 0.3);
		return param * param * param - 5 * x + x * x - 2;
	}

	/**
	 * Função de Metrópolis
	 */
	private double acceptanceProbability(double actualEnergy, double newEnergy, double temperature) {

		/**
		 * Se o novo estado for melhor então vamos assumí-lo.
		 * 
		 * Se retornarmos o valor 1.0 ele será maior que o valor randômico gerado (que
		 * deve ser gerado entre o range de 0 e 1).
		 * 
		 * Quando a verificação é "-" então: MÍNIMO
		 * Quando a verificação é "+" então: MÁXIMO
		 */
		if (newEnergy < actualEnergy) {
			return 1.0;
		}

		/**
		 * Se a nova solução for pior, então calculamos a probabilidade. Quanto menor
		 * for a temperatura, menor a probabilidade de soluções ruins serem aceitas.
		 */
		return Math.exp((actualEnergy - newEnergy) / temperature);
	}
}
