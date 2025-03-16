package genetic_algorithm;

import java.util.Random;

/**
 * Isso é um cromossomo
 */
public class Individual {

	/**
	 * Neste exemplo os genes não são valores binários
	 */
	private int[] genes;
	private int fitness;
	private Random random;
	
	public Individual() {
		this.genes = new int[Constants.CHROMOSOME_LENGTH];
		this.random = new Random();
	}
	
	public void generateIndividual() {
		for(int i = 0; i < genes.length; ++i) {
			/**
			 * A função "nextInt" cria um valor inteiro entre um intervalo
			 * de 0 (inclusivo) e o valor especificado (exclusivo), ou seja,
			 * como "CHROMOSOME_LENGTH" é 10, vai criar entre 0 e 9. Esses 
			 * são exatamente os valores dentro da sequência de solução.
			 */
			genes[i] = random.nextInt(Constants.CHROMOSOME_LENGTH);
		}
	}

	public int getGene(int index) {
		return genes[index];
	}

	public void setGene(int index, int value) {
		this.genes[index] = value;
		fitness = 0;
	}
	
	public int getFitness() {
		if(fitness == 0) {
			for(int i = 0; i < genes.length; ++i) {
				if(genes[i] == Constants.SOLUTION_SEQUENCE[i]) {
					fitness++;
				}
			}
		}
		
		return fitness;
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