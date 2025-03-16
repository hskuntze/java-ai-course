package simulated_annealing_tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTour {

	private List<City> tour;
	
	/**
	 * A distância é soma do peso das arestas
	 */
	private int distance;
	
	public SingleTour() {
		this.tour = new ArrayList<City>();
		
		for(int i = 0; i < Repository.getNumberOfCities(); ++i) {
			tour.add(null);
		}
	}
	
	public SingleTour(List<City> cities) {
		tour = new ArrayList<>();
		
		for(City city : cities) {
			tour.add(city);
		}
	}
	
	/**
	 * Gera um tour randomico.
	 * 
	 * É basicamente assim que um Hamiltonian Cycle é gerado
	 * @return
	 */
	public void generateIndividual() {
		for(int cityIndex = 0; cityIndex < Repository.getNumberOfCities(); ++cityIndex) {
			setCity(cityIndex, Repository.getCity(cityIndex));
		}
		
		/**
		 * Randomiza a ordem dos elementos
		 */
		Collections.shuffle(tour);
	}
	
	public double getDistance() {
		if(distance == 0) {
			int tourDistance = 0;
			
			for(int cityIndex = 0; cityIndex < tour.size(); ++cityIndex) {
				City from = tour.get(cityIndex);
				City destination = null;
				
				if(cityIndex + 1 < tour.size()) {
					destination = tour.get(cityIndex);
				} else {
					destination = tour.get(0);
				}
				
				tourDistance += from.distanceTo(destination);
			}
			
			distance = tourDistance;
		}
		
		return distance;
	}

	public List<City> getTour() {
		return tour;
	}
	
	public City getCity(int i) {
		return tour.get(i);
	}
	
	public void setCity(int i, City c) {
		tour.set(i, c);
	}
	
	public int getTourSize() {
		return tour.size();
	}

	@Override
	public String toString() {
		String s = "";
		
		for(City c : tour) {
			s += c.toString() + " - ";
		}
		
		return s;
	}
}
