package genetic_algorithm;

public class App {

	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm();

		Population population = new Population(100);
		population.initializePopulation();
		
		int generationCounter = 0;
		
		while(population.getFittest().getFitness() != Constants.MAX_FITNESS) {
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
