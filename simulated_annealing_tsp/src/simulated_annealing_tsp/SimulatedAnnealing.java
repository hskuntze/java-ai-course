package simulated_annealing_tsp;

public class SimulatedAnnealing {

	private SingleTour actualState;
	private SingleTour nextState;
	private SingleTour bestState;
	
	public void simulate() {
		double temp = Constants.MAX_TEMPERATURE;
		
		actualState = new SingleTour();
		actualState.generateIndividual();
		bestState = new SingleTour(actualState.getTour());
		
		System.out.println("Initial solution distance: " + actualState.getDistance());
		
		while(temp > Constants.MIN_TEMPERATURE) {
			nextState = generateNeighborState(actualState);
			
			double currentEnergy = actualState.getDistance();
			double neighborEnergy = nextState.getDistance();
			
			if(acceptanceProbability(currentEnergy, neighborEnergy, temp) > Math.random()) {
				actualState = new SingleTour(nextState.getTour());
			}
			
			if(actualState.getDistance() < bestState.getDistance()) {
				bestState = new SingleTour(actualState.getTour());
			}
			
			temp *= 1 - Constants.COOLING_RATE;
		}
	}

	/**
	 * Troca duas cidades de forma randomica.
	 * 
	 * <p>
	 * 
	 * <b>Isso é necessário para gerar o próximo estado a ser pesquisado
	 * tendo em vista que para avaliar o melhor caminho, precisamos
	 * avaliar todas as possibilidades.</b>
	 * 
	 * <p>
	 * 
	 * Ao trocar a ordem de duas cidades, baseado no estado original,
	 * temos uma nova possibilidade de caminho.
	 * 
	 * <p>
	 * 
	 * Aqui podemos selecionar duas cidades de forma randomica pois
	 * estamos lidando com um ciclo Hamiltoniano.
	 */
	private SingleTour generateNeighborState(SingleTour actualState) {
		SingleTour newState = new SingleTour(actualState.getTour());
		
		int randomIndex1 = (int) (Math.random() * newState.getTourSize());
		int randomIndex2 = (int) (Math.random() * newState.getTourSize());
		
		City c1 = newState.getCity(randomIndex1);
		City c2 = newState.getCity(randomIndex2);
		
		newState.setCity(randomIndex1, c2);
		newState.setCity(randomIndex2, c1);
		
		return newState;
	}
	
	public SingleTour getBestState() {
		return bestState;
	}

	/**
	 * Função de Metrópolis
	 * @param currentEnergy
	 * @param neighbourEnergy
	 * @param temp
	 * @return
	 */
	private double acceptanceProbability(double currentEnergy, double neighbourEnergy, double temp) {
		if(neighbourEnergy < currentEnergy) {
			return 1.0;
		}
		
		return Math.exp((currentEnergy - neighbourEnergy) / temp);
	}
}
