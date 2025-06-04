package genetic_algorithm;

import java.util.Random;

public class GeneticAlgorithm {

	private Random random;
	private int[] weights;
	private int[] values;
	
	public GeneticAlgorithm(int[] weights, int [] values) {
		this.random = new Random();
		this.weights = weights;
		this.values = values;
	}
	
	public Population evolvePopulation(Population population) {
		Population newPopulation = new Population(population.size(), this.weights, this.values);
		
		for(int i = 0; i < population.size(); ++i) {
			Individual first = randomSelection(population);
			Individual second = randomSelection(population);
			
			Individual child = crossover(first, second, this.weights, this.values);
			newPopulation.saveIndividual(i, child);
		}
		
		for(int i = 0; i < newPopulation.size(); ++i) {
			mutate(newPopulation.getIndividual(i));
		}
		
		return newPopulation;
	}
	
	private Individual crossover(Individual parent1, Individual parent2, int[] weights, int [] values) {
		Individual child = new Individual(weights, values);
		
		/**
		 * Considera os genes um a um
		 */
		for(int i = 0; i < values.length; ++i) {
			if(Math.random() <= Constants.CROSSOVER_RATE) {
				child.setGene(i, parent1.getGene(i));
			} else {
				child.setGene(i, parent2.getGene(i));
			}
		}
		
		return child;
	} 
	
	private void mutate(Individual individual) {
		for(int i = 0; i < values.length; ++i) {
			if(Math.random() <= Constants.MUTATION_RATE) {
				int gene = random.nextInt(2);
				individual.setGene(i, gene);
			}
		}
	}
	
	/**
	 * Selecionará randomicamente 5 indivíduos (baseado na constante definida) da população
	 * @param population
	 * @return
	 */
	private Individual randomSelection(Population population) {
		Population newPopulation = new Population(Constants.TOURNAMENT_SIZE, this.weights, this.values);
		
		for(int i = 0; i < Constants.TOURNAMENT_SIZE; ++i) {
			int randomIndex = (int) (Math.random() * population.size());
			newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
		}
		
		Individual fittest = newPopulation.getFittest();
		return fittest;
	}
}
