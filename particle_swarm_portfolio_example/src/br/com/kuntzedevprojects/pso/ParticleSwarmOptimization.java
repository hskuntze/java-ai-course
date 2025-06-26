package br.com.kuntzedevprojects.pso;

public class ParticleSwarmOptimization {

	private double[] globalBestSolutions;
	private Particle[] particleSwarm;
	private int epochs;

	public ParticleSwarmOptimization() {
		this.globalBestSolutions = new double[Constants.NUM_DIMENSIONS];
		this.particleSwarm = new Particle[Constants.NUM_PARTICLES];

		// Inicializa com uma solução aleatória
		for (int i = 0; i < Constants.NUM_DIMENSIONS; ++i) {
			globalBestSolutions[i] = random(Constants.MIN, Constants.MAX);
		}
	}

	private double random(double min, double max) {
		return min + (max - min) * Math.random();
	}

	private double[] normalize(double[] weights) {
		double sum = 0.0;
		for (double w : weights) sum += w;

		double[] normalized = new double[weights.length];
		if (sum == 0) sum = 1; // evitar divisão por zero
		for (int i = 0; i < weights.length; i++) {
			normalized[i] = weights[i] / sum;
		}
		return normalized;
	}

	private double[] initializeLocation() {
		double[] location = new double[Constants.NUM_DIMENSIONS];
		for (int i = 0; i < Constants.NUM_DIMENSIONS; i++) {
			location[i] = random(Constants.MIN, Constants.MAX);
		}
		return location;
	}

	private double[] initializeVelocity() {
		double[] velocity = new double[Constants.NUM_DIMENSIONS];
		for (int i = 0; i < Constants.NUM_DIMENSIONS; i++) {
			velocity[i] = random(-(Constants.MAX - Constants.MIN), Constants.MAX - Constants.MIN);
		}
		return velocity;
	}

	public void solve() {
		// Inicialização das partículas
		for (int i = 0; i < Constants.NUM_PARTICLES; i++) {
			double[] loc = initializeLocation();
			double[] vel = initializeVelocity();
			particleSwarm[i] = new Particle(loc, vel);
		}

		while (epochs < Constants.MAX_ITERATIONS) {
			for (Particle p : particleSwarm) {
				double[] velocity = p.getVelocity();
				double[] position = p.getPosition();
				double[] best = p.getBestPosition();

				// Atualiza velocidade
				for (int i = 0; i < Constants.NUM_DIMENSIONS; i++) {
					double rp = Math.random();
					double rg = Math.random();
					velocity[i] = Constants.w * velocity[i]
							+ Constants.c1 * rp * (best[i] - position[i])
							+ Constants.c2 * rg * (globalBestSolutions[i] - position[i]);
				}

				// Atualiza posição
				for (int i = 0; i < Constants.NUM_DIMENSIONS; i++) {
					position[i] += velocity[i];
					if (position[i] < Constants.MIN) position[i] = Constants.MIN;
					if (position[i] > Constants.MAX) position[i] = Constants.MAX;
				}

				// Normaliza para garantir soma 1
				double[] normalized = normalize(position);

				// Atualiza melhor posição da partícula
				if (Constants.f(normalized) > Constants.f(best)) {
					p.setBestPosition(normalized.clone());
				}

				// Atualiza melhor posição global
				if (Constants.f(p.getBestPosition()) > Constants.f(globalBestSolutions)) {
					System.arraycopy(p.getBestPosition(), 0, globalBestSolutions, 0, Constants.NUM_DIMENSIONS);
				}
			}
			epochs++;
		}
	}

	public void showSolution() {
		double[] normalizedSolution = normalize(globalBestSolutions);
		System.out.println("Melhor solução encontrada:");
		for (int i = 0; i < normalizedSolution.length; i++) {
			System.out.printf("Ativo %d: %.4f%%\n", i + 1, normalizedSolution[i] * 100);
		}
		System.out.printf("Sharpe Ratio: %.4f\n", Constants.f(normalizedSolution));
	}
}
