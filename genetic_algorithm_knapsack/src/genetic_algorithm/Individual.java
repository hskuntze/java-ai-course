package genetic_algorithm;

import java.util.Random;

/**
 * Isso é um cromossomo
 */
public class Individual {

	private int[] genes;
	private int[] weights;
	private int[] values;
	private Random random;
	
	public Individual(int[] weights, int [] values) {
		this.weights = weights;
		this.values = values;
		this.genes = new int[values.length];
		this.random = new Random();
	}
	
	public void generateIndividual() {
		for(int i = 0; i < genes.length; ++i) {
			genes[i] = random.nextInt(2);
		}
	}

	public int getGene(int index) {
		return genes[index];
	}

	public void setGene(int index, int value) {
		this.genes[index] = value;
	}
	
	/**
	 * Temos de somar os itens da mochila (knapsack) e considerar o valor.
	 * Quanto maior o valor, melhor.
	 */
	public int getFitness() {
		int weight = 0;
		int value = 0;
		
		for(int i = 0; i < genes.length; ++i) {
			if(genes[i] == 1) {
				weight += weights[i];
				value += values[i];
			}
		}
		
		if(weight <= Constants.KNAPSACK_CAPACITY) {
			return value;
		}
		
		return Integer.MIN_VALUE;
	}

	@Override
	public String toString() {
		String s = "";
		
		for(int i = 0; i < genes.length; ++i) {
			s += genes[i] + "-";
		}
		
		return s;
	}
}