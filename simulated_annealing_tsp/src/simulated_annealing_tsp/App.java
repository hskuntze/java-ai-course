package simulated_annealing_tsp;

public class App {
	public static void main(String[] args) {
		SimulatedAnnealing sa = new SimulatedAnnealing();
		
		for(int i = 0; i < 5; i++) {
			City c = new City();
			Repository.addCity(c);
		}
		
		sa.simulate();
		
		System.out.println("The best solution: " + sa.getBestState().getDistance());
		System.out.println(sa.getBestState());
	}
}