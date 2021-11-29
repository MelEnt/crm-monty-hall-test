package se.comhem.test.montyhall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import se.comhem.test.montyhall.enums.SimulationOutputFields;
import se.comhem.test.montyhall.model.SimulationOutput;

@CrossOrigin(origins = "*")
@RestController
public class SimulatorController {
	private static long calculateWins(long numberOfSims, boolean willSwapDoor) {	
		int winCount = 0;
		
		// loop through each number of simulations
		for (long i = 0; i < numberOfSims; i++) {
			// user guesses between 1 to 3
			int chosenDoor = (int) Math.floor(1 + Math.random() * 3);
			
			// prize door
			int prizeDoor = (int) Math.floor(1 + Math.random() * 3);
			
			
			/*
			 * Game show host opens door that is not chosen and does not contain the prize.
			 * This leaves us with two doors left. We have two choices: stay, or switch door.
			 * If staying means 1/3, then switching should automatically mean 2/3, to fulfill 3/3,
			 * 	since now there are _only chosenDoor and prizeDoor left_
			 * 
			 * This can only be true since game show host 1) does not open your door (chosenDoor), 
			 * 2) does not open door with prize, and most importantly
			 * 3) _eliminates the faulty door among the 2/3 which DOES NOT IMPACT the 2/3 odds, but
			 * 	impacts the number of doors we can choose_
			 */
			if ((chosenDoor == prizeDoor) && !willSwapDoor) {
				winCount++;
			} else if ((chosenDoor != prizeDoor) && willSwapDoor) {
				winCount++;
			}


		}
		
		return winCount;
	}
	
	private static double calculateWinPercentage(long wins, long numberOfSimulations, boolean willSwapDoor) {
		return (double) wins/numberOfSimulations;
	}
	
	
	@PostMapping(value = "/post", consumes = "application/json", produces = "application/json")
	public SimulationOutput postSimulation(@RequestBody Map<String, Object> payload) throws Exception {		
		Map<String, Object> data = new HashMap<>(payload);
		
		Long numberOfSims = ((Number) data.get(SimulationOutputFields.NUM_OF_SIMS.getString())).longValue();
		Boolean willSwapDoor = (Boolean) data.get(SimulationOutputFields.WILL_SWAP_DOOR.getString());
		
		if (numberOfSims == 0 || numberOfSims == null || numberOfSims > 100_000_000L) {
			throw new InternalError("Antalet simulationer måste vara mer än 0 eller mindre än 100_000_000!");
		}
		
		if (willSwapDoor == null) {
			throw new InternalError("Måste ange om du vill byta dörr eller inte!");
		}
		
		long wins = calculateWins(numberOfSims, willSwapDoor);
		double winChance = calculateWinPercentage(wins, numberOfSims, willSwapDoor);
		
		return new SimulationOutput(numberOfSims, winChance, willSwapDoor, wins);
	}
}
