package genetic_algorithm;

import java.util.Random;

/**
 * Isso é um cromossomo
 */
public class Individual {
	
	/**
	 * Neste exemplo os valores de gene são binários
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
			genes[i] = random.nextInt(2);
		}
	}

	public int getGene(int index) {
		return genes[index];
	}

	public void setGene(int index, int value) {
		this.genes[index] = value;
		fitness = 0;
	}
	
	/**
	 * A função neste exemplo é de um plano cartesiano, e a função
	 * em si varia de acordo com o contexto da aplicação, de acordo
	 * com o problema que se quer solucionar.
	 * @param x
	 * @return
	 */
	public double f(double x) {
		return Math.sin(x) * ((x-2) * (x-2)) + 3;
	}
	
	public double getFitness() {
		double genesToDouble = genesToDoubles();
		return f(genesToDouble);
	}
	
	public double genesToDoubles() {
		int base = 1;
		double geneInDouble = 0;
		
		for(int i = 0; i < Constants.GENE_LENGTH; ++i) {
			if(this.genes[i] == 1) {
				geneInDouble += base;
			}
			
			base = base * 2;
		}
		
		// Para encontrar o valor no intervalo [0, 10] -> 2 (base binária) ^ 10 (base decimal) = 1024 / 10 (máx. intervalo)
		geneInDouble = geneInDouble / 102.4f;
		return geneInDouble;
	}

	@Override
	public String toString() {
		String s = "";
		
		for(int i = 0; i < genes.length; ++i) {
			s += genes[i];
		}
		
		return s;
	}
}