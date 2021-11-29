package se.comhem.test.montyhall.model;

public class SimulationOutput {

	private long numberOfSimulations;
	private long wins;
	private double chanceToWin;
	private boolean willSwapDoor;
	
	public SimulationOutput(long numberOfSimulations, double chanceToWin, boolean willSwapDoor, long wins) {
		this.numberOfSimulations = numberOfSimulations;
		this.chanceToWin = chanceToWin;
		this.willSwapDoor = willSwapDoor;
		this.wins = wins;
	}


	public double getChanceToWin() {
		return chanceToWin;
	}
	public long getNumberOfSimulations() {
		return numberOfSimulations;
	}
	public boolean isWillSwapDoor() {
		return willSwapDoor;
	}
	public long getWins() {
		return wins;
	}
	
}
