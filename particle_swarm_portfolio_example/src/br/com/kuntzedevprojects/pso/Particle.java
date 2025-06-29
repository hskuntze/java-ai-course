package br.com.kuntzedevprojects.pso;

public class Particle {

	private double[] position; //Xi -> (x, y)
	private double[] velocity;
	private double[] bestPosition;
	
	public Particle(double[] position, double[] velocity) {
		this.position = new double[Constants.NUM_DIMENSIONS];
		this.velocity = new double[Constants.NUM_DIMENSIONS];
		this.bestPosition = new double[Constants.NUM_DIMENSIONS];
		
		System.arraycopy(position, 0, this.position, 0, position.length);
		System.arraycopy(velocity, 0, this.velocity, 0, velocity.length);
		//System.arraycopy(bestPosition, 0, this.bestPosition, 0, bestPosition.length);
	}

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	public double[] getVelocity() {
		return velocity;
	}

	public void setVelocity(double[] velocity) {
		this.velocity = velocity;
	}

	public double[] getBestPosition() {
		return bestPosition;
	}

	public void setBestPosition(double[] bestPosition) {
		this.bestPosition = bestPosition;
	}
	
	public void checkBestSolution(double[] globalBestSolution) {
		if(Constants.f(this.bestPosition) < Constants.f(globalBestSolution)) {
			globalBestSolution = this.bestPosition;
		}
	}

	@Override
	public String toString() {
		return "Best position so far: " + this.bestPosition[0] + " - " + this.position[1];
	}
}