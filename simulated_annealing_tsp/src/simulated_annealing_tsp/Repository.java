package simulated_annealing_tsp;

import java.util.ArrayList;
import java.util.List;

public class Repository {

	public static List<City> cities = new ArrayList<City>();
	
	public static void addCity(City city) {
		cities.add(city);
	}
	
	public static City getCity(int i) {
		return cities.get(i);
	}
	
	public static int getNumberOfCities() {
		return cities.size();
	}
}
