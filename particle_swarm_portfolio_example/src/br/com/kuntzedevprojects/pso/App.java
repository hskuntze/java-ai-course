package br.com.kuntzedevprojects.pso;

public class App {
	public static void main(String[] args) {
		ParticleSwarmOptimization pso = new ParticleSwarmOptimization();
		pso.solve();
		pso.showSolution();
	}
}