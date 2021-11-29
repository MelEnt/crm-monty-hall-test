package se.comhem.test.montyhall.enums;

public enum SimulationOutputFields {
	NUM_OF_SIMS("numberOfSimulations"),
	WILL_SWAP_DOOR("willSwapDoor");
	
	private String value;

	SimulationOutputFields(String value) {
		this.value = value;
	}

	public String getString() {
		return value;
	}	
	
}
