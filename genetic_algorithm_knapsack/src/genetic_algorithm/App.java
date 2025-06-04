package genetic_algorithm;

public class App {

	public static void main(String[] args) {
		
		int[] weights = {5, 7, 9, 2};
		int[] values = {10, 13, 19, 4};
		
		GeneticAlgorithm ga = new GeneticAlgorithm(weights, values);

		Population population = new Population(100, weights, values);
		population.initializePopulation();
		
		int generationCounter = 0;
		
		while(generationCounter < 10) {
			++generationCounter;
			
			System.out.println("Generation; " + generationCounter + ", fittest is: " + population.getFittest().getFitness());
			System.out.println(population.getFittest());
			System.out.println();
			
			population = ga.evolvePopulation(population);
		}
		
		System.out.println("Solution found.");
		System.out.println(population.getFittest());
	}

}
